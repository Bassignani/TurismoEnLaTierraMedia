package controller.promociones;

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

@WebServlet("/promocion/registrarPaso1.adm")
public class RegistrarPromocionPaso1Servlet extends HttpServlet {

	private static final long serialVersionUID = -5971210708112854788L;
	private TipoService tipoService;
	private AtraccionService atraccionService;
	LinkedList<Tipo> tipos;
	LinkedList<Atraccion> atracciones;
	Tipo tipo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		tipos = tipoService.listar();
		req.setAttribute("tipos", tipos);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/registrarPaso1.jsp");
		dispatcher.forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LinkedList<Tipo> tipos = tipoService.listar();
		String nombre = req.getParameter("nombre");
		String tipo_promo = req.getParameter("tipo_promo");
		try {
			 tipo = tipoService.toTipo(Integer.parseInt(req.getParameter("tipo")), tipos);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		atracciones = atraccionService.buscarPorTipoId(tipo.getId(), tipos);
		req.setAttribute("tipo", tipo);
		req.setAttribute("nombre", nombre);
		req.setAttribute("tipo_promo", tipo_promo);
		req.setAttribute("atracciones", atracciones);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/registrarPaso2.jsp");
		dispatcher.forward(req, resp);
	}
	
}
