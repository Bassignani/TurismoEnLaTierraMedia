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
import services.AtraccionService;
import services.PromocionService;

@WebServlet("/promociones/listar.adm")
public class ListarPromocionesServlet extends HttpServlet {

	private static final long serialVersionUID = -167544386206483638L;
	private PromocionService promocionService;
	
	private AtraccionService atraccionService;  //INCORPORACION
	private LinkedList<Atraccion> atracciones;//INCORPORACION
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();  //INCORPORACION
		atracciones = atraccionService.listar(); 		//INCORPORACION
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LinkedList<Promocion> promociones = promocionService.listar(atracciones);		//INCORPORACION atracciones en el pedido
		req.setAttribute("promociones", promociones);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/promociones.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
