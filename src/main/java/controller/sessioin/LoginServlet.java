package controller.sessioin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 6355127484303939305L;
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String nombre = req.getParameter("nombre");
    	String password = req.getParameter("password");
    	
    	Usuario usuario = loginService.login(nombre, password);
    	
    	if (!usuario.esNull()) {
    		req.getSession().setAttribute("usuario", usuario);
    		resp.sendRedirect("index.jsp");    		
       	} else {
    		req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/login.jsp");
      		    dispatcher.forward(req, resp);
    	}
    }
}
