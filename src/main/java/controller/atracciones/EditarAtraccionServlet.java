package controller.atracciones;

import java.io.IOException;
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
}
