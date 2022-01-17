package controller.tipo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import services.TipoService;

@WebServlet("/tipo/desactivar.adm")
public class DesactivarTipoServlet extends HttpServlet {

	private static final long serialVersionUID = 7771145771579726886L;
	private TipoService tipoService;
	Integer id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		id = Integer.parseInt(req.getParameter("id"));
		Tipo tipo = tipoService.buscarPorId(id); 
		tipoService.deactivate(tipo);
		resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/tipos/listar.adm");
	}

}
