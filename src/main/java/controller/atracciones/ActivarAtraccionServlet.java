package controller.atracciones;

import java.io.IOException;
import java.util.LinkedList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import services.AtraccionService;
import services.TipoService;

@WebServlet("/atraccion/activar.adm")
public class ActivarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = -1421778817759219165L;
	private AtraccionService atraccionService;
	private TipoService tipoService;
	Integer id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.tipoService = new TipoService();
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		id = Integer.parseInt(req.getParameter("id"));
		LinkedList<Tipo> tipos = tipoService.listar();
		atraccionService.activate(id, tipos);
		resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/atracciones/listar.adm");
	}

}
