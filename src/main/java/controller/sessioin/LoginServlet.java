package controller.sessioin;

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
import persistence.commons.DAOFactory;
import services.LoginService;
import model.Tipo;
import services.TipoService;
import services.VendibleService;

@WebServlet("/usuario/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 6355127484303939305L;
	private LoginService loginService;
	private VendibleService vendibleService;
	private TipoService tipoService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
		this.vendibleService = new VendibleService();
		this.tipoService = new TipoService();
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("flash", "Para comprar debes iniciar sesión");
		RequestDispatcher dispatcher = getServletContext()
  		      .getRequestDispatcher("/TurismoEnLaTierraMedia2021WebApp/views/usuarios/login.jsp");
  		    dispatcher.forward(req, resp);
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String nombre = req.getParameter("nombre");
    	String password = req.getParameter("password");
    	LinkedList<Tipo> tipos = tipoService.listar();
    	LinkedList<Vendible> vendibles = vendibleService.listar();
    	Usuario usuario = loginService.login(nombre, password,vendibles, tipos);
    	
    	if (!usuario.esNull() && usuario.checkPassword(password)) {
    		req.getSession().setAttribute("usuario", usuario);
    		resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/index");    		
       	} else {
    		req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/views/usuarios/login.jsp");
      		    dispatcher.forward(req, resp);
    	}
    }
}
