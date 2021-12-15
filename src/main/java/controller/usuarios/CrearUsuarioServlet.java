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
import model.Tipo;
import services.TipoService;
import services.UsuarioService;

@WebServlet("/usuario/crear.adm")
public class CrearUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 2792106066044749125L;
	private UsuarioService usuarioService;
	private TipoService tipoService;
	LinkedList<Tipo> tipos;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.tipoService = new TipoService();
		tipos = tipoService.listar();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("tipos", tipos);
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
		Tipo tipoDeAtraccion = toTipo(Integer.parseInt(req.getParameter("tipoDeAtraccion")), tipos);
		String path_img = req.getParameter("path_img");
		
		
		Usuario tmp_user = usuarioService.create(nombre, presupuesto, tiempoDisponible, tipoDeAtraccion,admin,password,path_img);
		
		if (tmp_user.isValid()) {
			resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/usuarios/listar.adm");
		} else {
			req.setAttribute("tmp_user", tmp_user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/TurismoEnLaTierraMedia2021WebApp/usuarios/crear.adm");
			dispatcher.forward(req, resp);
		}

	}
	
	private Tipo toTipo(int resultado, LinkedList<Tipo> tipos) {
		int id = resultado;
		Tipo tmp_tipo = null;
		for (Tipo tipo : tipos) {
			if (tipo.getId() == id) {
				tmp_tipo = tipo;
			}
		}
		return tmp_tipo;
	}
}
