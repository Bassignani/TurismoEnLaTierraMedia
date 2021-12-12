package controller.sessioin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoguotServlet extends HttpServlet {

	private static final long serialVersionUID = 7625182050776504157L;

	// service = doGet || doPost
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getSession().removeAttribute("user");
			req.setAttribute("success", "¡Hasta pronto!");

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
}
