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

@WebServlet("/usuarios/listar.adm")
public class ListarUsuarioServlet  extends HttpServlet{

	private static final long serialVersionUID = 6991562980581721616L;
	private UsuarioService usuarioService;
	private VendibleService vendibleService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.vendibleService = new VendibleService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LinkedList<Vendible> vendibles = vendibleService.listar();
		LinkedList<Usuario> usuarios = usuarioService.listar(vendibles);
		//System.out.println(usuarios);
		req.setAttribute("usuarios", usuarios);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/usuarios.jsp");
		dispatcher.forward(req, resp);

	}

	
}
