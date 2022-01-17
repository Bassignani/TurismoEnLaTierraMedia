package controller.promociones;

import java.io.IOException;
import java.util.LinkedList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Tipo;
import services.AtraccionService;
import services.PromocionService;
import services.TipoService;


@WebServlet("/promocion/activar.adm")
public class ActivarPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = -6935457974726458838L;
	private PromocionService promocionService;
	private AtraccionService atraccionService;
	private TipoService tipoService;
	Integer id;
	
	@Override
	public void init() throws ServletException{
		super.init();
		this.tipoService = new TipoService();
		this.atraccionService = new AtraccionService();
		this.promocionService = new PromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		id = Integer.parseInt(req.getParameter("id"));
		LinkedList<Tipo> tipos = tipoService.listar();
		LinkedList<Atraccion> atracciones = atraccionService.listar(tipos);
		promocionService.activate(id, atracciones, tipos);
		resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/promociones/listar.adm");
	}
}
