package controller.usuarios;

import java.io.IOException;
import java.util.LinkedList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import model.Usuario;
import model.Vendible;
import services.ItinerarioService;
import services.TipoService;
import services.UsuarioService;
import services.VendibleService;

@WebServlet("/usuario/itinerario.do")
public class ItinerarioUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 5581860280009880117L;
	private TipoService tipoService;
	private UsuarioService usuarioService;
	private VendibleService vendibleService;
	private ItinerarioService itinerarioService;
	LinkedList<Vendible> vendibles;
	LinkedList<Vendible> vendiblesComprados;
	LinkedList<Tipo> tipos;
	Integer id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
		this.itinerarioService = new ItinerarioService();
		this.usuarioService = new UsuarioService();
		this.vendibleService = new VendibleService();
		vendibles = vendibleService.listar();
		tipos = tipoService.listar();
		}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		id = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = usuarioService.busacarPorId(id, vendibles, tipos);
		//vendiblesComprados = itinerarioService.listar(id);
		req.setAttribute("vendiblesComprados", vendiblesComprados);
		req.setAttribute("tmp_user", usuario);	
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/itinerario.jsp");
		dispatcher.forward(req, resp);
	}
	

}
