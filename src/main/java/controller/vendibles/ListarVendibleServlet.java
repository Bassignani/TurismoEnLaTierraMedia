package controller.vendibles;

import java.io.IOException;
import java.util.LinkedList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import model.Vendible;

import services.AtraccionService;
import services.PromocionService;
import services.VendibleService;

public class ListarVendibleServlet extends HttpServlet {

	private static final long serialVersionUID = -5020477282852856688L;	
	private PromocionService promocionService;
	LinkedList<Promocion> promociones;
	private AtraccionService atraccionService;  //INCORPORACION
	private LinkedList<Atraccion> atracciones;//INCORPORACION
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();  //INCORPORACION
		atracciones = atraccionService.listar(); 		//INCORPORACION
		promociones = promocionService.listar(atracciones);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		LinkedList<Vendible> vendibles = new LinkedList<Vendible>();		//INCORPORACION atracciones en el pedido
		req.setAttribute("vendibles", vendibles);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/promociones.jsp");
		dispatcher.forward(req, resp);
	}
}


