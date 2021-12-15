package controller.usuarios;

import java.io.IOException;
import java.util.LinkedList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.Vendible;
import services.UsuarioService;
import services.VendibleService;

@WebServlet("/usuario/borrar.adm")
public class BorrarUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 1758513436112811512L;
	private UsuarioService usuarioService;
	private VendibleService vendibleService;
	LinkedList<Vendible> vendibles;
	Integer id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.vendibleService = new VendibleService();
		vendibles = vendibleService.listar();
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		id = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = usuarioService.busacarPorId(id, vendibles);
		System.out.println(id);
		req.setAttribute("tmp_user", usuario);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/index");
		dispatcher.forward(req, resp);
	}
	
}
