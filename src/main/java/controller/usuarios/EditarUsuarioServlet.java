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
import services.UsuarioService;
import services.VendibleService;

@WebServlet("/usuario/editar.adm")
public class EditarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 6520398452825874636L;
	private UsuarioService usuarioService;
	private VendibleService vendibleService;
	LinkedList<Vendible> vendibles;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.vendibleService = new VendibleService();
		vendibles = vendibleService.listar();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = usuarioService.busacarPorId(id, vendibles);
		req.setAttribute("usuario", usuario);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
		Tipo tipoDeAtraccion = Tipo.valueOf(req.getParameter("tipoDeAtraccion").toUpperCase());
		String path_img = req.getParameter("path_img");
//		String password = usuario.getPas;
		
		Usuario tmp_user = usuarioService.update(nombre, presupuesto, tiempoDisponible, tipoDeAtraccion,admin, path_img);
		
		if (tmp_user.isValid()) {
			resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/usuarios/listar");
		} else {
			req.setAttribute("tmp_user", tmp_user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/TurismoEnLaTierraMedia2021WebApp/usuarios/crear");
			dispatcher.forward(req, resp);
		}

	}
}
