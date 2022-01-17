package controller.tipo;

import java.io.IOException;
import java.util.LinkedList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import services.TipoService;

@WebServlet("/tipos/listar.adm")
public class ListaDeTiposServlat extends HttpServlet {

	
	private static final long serialVersionUID = -6912862572695747801L;
private TipoService tipoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LinkedList<Tipo> tipos = tipoService.listar();
		req.setAttribute("tipos", tipos);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/tipos/tipos.jsp");
		dispatcher.forward(req, resp);
	}
}
