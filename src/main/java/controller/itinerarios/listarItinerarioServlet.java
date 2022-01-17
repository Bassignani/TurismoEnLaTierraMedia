package controller.itinerarios;

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

@WebServlet("/itinerario/listar.do")
public class listarItinerarioServlet extends HttpServlet {

	private static final long serialVersionUID = -8120978306478980904L;
	//private ItinerarioService itinerarioService;
	private UsuarioService usuarioService;
	private VendibleService vendibleService;
	private TipoService tipoService;
	public LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();
	public LinkedList<Vendible> vendibles = new LinkedList<Vendible>();
	public LinkedList<Tipo> tipos = new LinkedList<Tipo>();
	public Integer id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		//this.itinerarioService = new ItinerarioService();
		this.usuarioService = new UsuarioService();
		this.vendibleService = new VendibleService();
		this.tipoService = new TipoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		id = Integer.parseInt(req.getParameter("id"));
		vendibles = vendibleService.listar();
		tipos = tipoService.listar();
		//vendiblesComprados = itinerarioService.listar(id);
		Usuario usuario = usuarioService.busacarPorId(id, vendibles, tipos);
		vendiblesComprados = usuario.getVendiblesComprados();
		req.setAttribute("vendiblesComprados", vendiblesComprados);
		req.setAttribute("usuario", usuario);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/itinerario.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
