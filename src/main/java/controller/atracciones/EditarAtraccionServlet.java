package controller.atracciones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Tipo;
import services.AtraccionService;
import services.TipoService;

@WebServlet("/atraccion/editar.adm")
public class EditarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 48924652489099588L;
	private AtraccionService atraccionService;
	private TipoService tipoService;
	LinkedList<Tipo> tipos;
	Integer id;
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
		id = Integer.parseInt(req.getParameter("id"));
		Atraccion atraccion = atraccionService.buscarPorId(id, tipos);
		req.setAttribute("atraccion", atraccion);
		req.setAttribute("tipos", tipos);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/editar.jsp");
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
		
		Atraccion tmp_atrac = atraccionService.update(id,nombre, costo, duracion, cupo, description, tipo, path_img,tipos);
		
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
