package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.Tipo;
import services.UsuarioService;

@WebServlet("/usuario/crear")
public class CrearUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 2792106066044749125L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/registrar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
		String password = req.getParameter("password");
		Tipo tipoDeAtraccion = Tipo.valueOf(req.getParameter("tipoDeAtraccion"));
		String path_img = req.getParameter("path_img");
		System.out.println(nombre);
		
		Usuario tmp_user = usuarioService.create(nombre, presupuesto, tiempoDisponible, tipoDeAtraccion,admin,password,path_img);
		
		if (tmp_user.isValid()) {
			resp.sendRedirect("/views/usuarios/usuarios.jsp");
		} else {
			req.setAttribute("tmp_user", tmp_user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuarios/usuarios.jsp");
			dispatcher.forward(req, resp);
		}

	}
}
