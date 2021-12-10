package controller.usuarios;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UserService;

@WebServlet("/users/index.do")
public class ListarUsuarioServlet extends HttpServlet {


	private static final long serialVersionUID = 8143166732754571330L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Usuario> users = userService.list();
		req.setAttribute("users", users);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/users/index.jsp");
		dispatcher.forward(req, resp);

	}
}
