package controller.atracciones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import model.Atraccion;
import services.AtraccionService;
import services.TipoService;

@WebServlet("/atraccion/crear.adm")
public class CrearAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1803785961166384233L;
	private AtraccionService atraccionService;
	private TipoService tipoService;
	LinkedList<Tipo> tipos;
	Tipo tipo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.tipoService = new TipoService();
		tipos = tipoService.listar();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		tipos = tipoService.listar();
		req.setAttribute("tipos", tipos);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/registrar.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double duracion = Double.parseDouble(req.getParameter("duracion"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String description = req.getParameter("description");
		try {
			tipo = tipoService.toTipo(Integer.parseInt(req.getParameter("tipo")), tipos);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path_img = req.getParameter("path_img");
		
		Atraccion tmp_atrac = atraccionService.crear(nombre, costo, duracion, cupo, description, tipo, path_img);
		
		if (tmp_atrac.isValid()) {
			resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/atracciones/listar.adm");
		} else {
			req.setAttribute("tmp_atrac", tmp_atrac);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/TurismoEnLaTierraMedia2021WebApp/atraccion/crear.adm");
			dispatcher.forward(req, resp);
		}
	}
	
	
}
