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

@WebServlet("/tipo/crear.adm")
public class CrearTipoServlet extends HttpServlet {

	private static final long serialVersionUID = -5477230535778977554L;
	private TipoService tipoService;
	LinkedList<Tipo> tipos;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/tipos/crearTipo.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("tipo");
		tipoService.create(nombre); 
		resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/tipos/listar.adm");
	}
	
	
	
}
