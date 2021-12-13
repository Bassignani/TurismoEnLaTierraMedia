package controller.sessioin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuario/logout")
public class LoguotServlet extends HttpServlet {

	private static final long serialVersionUID = 7625182050776504157L;

	// service = doGet || doPost
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getSession().removeAttribute("usuario");
			req.setAttribute("success", "¡Hasta pronto!");

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/index");
			dispatcher.forward(req, resp);
//			resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/index.jsp"); 
		}
}
