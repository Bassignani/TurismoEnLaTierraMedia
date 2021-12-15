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
import services.TipoService;
import services.UsuarioService;
import services.VendibleService;

@WebServlet("/usuario/editar.adm")
public class EditarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 6520398452825874636L;
	private TipoService tipoService;
	private UsuarioService usuarioService;
	private VendibleService vendibleService;
	LinkedList<Vendible> vendibles;
	LinkedList<Tipo> tipos;
	Integer id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
		this.usuarioService = new UsuarioService();
		this.vendibleService = new VendibleService();
		vendibles = vendibleService.listar();
		tipos = tipoService.listar();
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		id = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = usuarioService.busacarPorId(id, vendibles, tipos);
		req.setAttribute("tipos", tipos);
		req.setAttribute("tmp_user", usuario);	
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
		Tipo tipoDeAtraccion = toTipo(Integer.parseInt(req.getParameter("tipoDeAtraccion")), tipos);
		String path_img = req.getParameter("path_img");
		
		System.out.println(path_img);
		Usuario tmp_user = usuarioService.update(id , nombre, presupuesto, tiempoDisponible, tipoDeAtraccion,admin, path_img);
		
		if (tmp_user.isValid()) {
			resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/usuarios/listar.adm");
		} else {
			req.setAttribute("tmp_user", tmp_user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/TurismoEnLaTierraMedia2021WebApp/usuarios/editar.jsp");
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
