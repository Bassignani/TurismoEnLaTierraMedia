package controller.promociones;

import java.io.IOException;
import java.util.LinkedList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion; //INCORPORACION
import model.Promocion;
import model.Tipo;
import services.AtraccionService;
import services.PromocionService;
import services.TipoService;

@WebServlet("/promociones/listar.adm")
public class ListarPromocionesServlet extends HttpServlet {

	private static final long serialVersionUID = -167544386206483638L;
	private TipoService tipoService;
	private PromocionService promocionService;
	private AtraccionService atraccionService;  //INCORPORACION
	private LinkedList<Atraccion> atracciones;//INCORPORACION
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
		LinkedList<Tipo> tipos = tipoService.listar();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();  //INCORPORACION
		atracciones = atraccionService.listar(tipos); 		//INCORPORACION
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LinkedList<Tipo> tipos = tipoService.listar();
		LinkedList<Promocion> promociones = promocionService.listar(atracciones, tipos);	
		req.setAttribute("promociones", promociones);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/promociones.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
