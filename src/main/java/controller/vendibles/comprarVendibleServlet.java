package controller.vendibles;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import model.Usuario;
import model.Vendible;
import services.VendibleService;


@WebServlet("/usuario/comprar.do")
public class comprarVendibleServlet extends HttpServlet {

	private static final long serialVersionUID = -4263676902665865658L;
	private VendibleService vendibleService;
	LinkedList<Vendible> vendibles;
	LinkedList<Tipo> tipos = new LinkedList<Tipo>();
	Integer id;
	Boolean esPromo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.vendibleService = new VendibleService();		
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//vendibles = vendibleService.listar();
		id = Integer.parseInt(req.getParameter("id"));
		esPromo = Boolean.parseBoolean(req.getParameter("promo"));
			
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Map<String, String> errors = vendibleService.comprar(usuario, id, esPromo);
		
		if (errors.isEmpty()) {
			req.setAttribute("success", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}
		req.setAttribute("id", usuario.getId());
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/vendibles/ofertar.do");
		dispatcher.forward(req, resp);	
		
	}
}
