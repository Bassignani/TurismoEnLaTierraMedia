package controller.vendibles;

import java.io.IOException;
import java.util.LinkedList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vendible;
import services.VendibleService;

@WebServlet("/index")
public class ListarVendiblesServlet extends HttpServlet {

	private static final long serialVersionUID = 376734913754092830L;
	private VendibleService vendibleService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.vendibleService = new VendibleService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LinkedList<Vendible> vendibles = vendibleService.listar();
		req.setAttribute("vendibles", vendibles);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);

	}
}
