package controller.promociones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import model.Tipo;
import services.AtraccionService;
import services.PromocionService;
import services.TipoService;

@WebServlet("/promocion/registrarPaso2.adm")
public class RegistrarPromocinPaso2Servlet extends HttpServlet {

	private static final long serialVersionUID = -6950607558307836402L;
	private TipoService tipoService;
	private AtraccionService atraccionService;
	private PromocionService promocionService;
	LinkedList<Tipo> tipos;
	LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
	Atraccion tmp_atraccion;
	Atraccion atraccion_gratis;
	Tipo tipo;
	Promocion promocion;
	Integer i=0;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
		this.atraccionService = new AtraccionService();
		this.promocionService = new PromocionService();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LinkedList<Tipo> tipos = tipoService.listar();
		LinkedList<Atraccion> atraccionesListadas = atraccionService.listar(tipos);
		String nombre = req.getParameter("nombre");
		String tipo_promo = req.getParameter("tipo_promo");
		String[] atraccionesArray = req.getParameterValues("atracciones");
		String description = req.getParameter("description");
		String path_img = req.getParameter("path_img");	
		i=0;
		try {
			 tipo = tipoService.toTipo(Integer.parseInt(req.getParameter("tipo")), tipos);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		for (String strId : atraccionesArray) {
			Integer atraccionId = Integer.parseInt(strId);
			tmp_atraccion = atraccionService.buscarPorId(atraccionId, tipos);
			atracciones.add(tmp_atraccion);
		}
		
		switch (tipo_promo) {
		case "AxB":
			Integer gratis_id = Integer.parseInt(req.getParameter("gratis"));
			atraccion_gratis = atraccionService.buscarPorId(gratis_id, tipos);		
			for (int i=0;i<atracciones.size();i++) {
				if(atracciones.get(i).getId() == atraccion_gratis.getId()) {
					atracciones.remove(atracciones.get(i));
				}
			}
			atracciones.add(atraccion_gratis);
			promocion = promocionService.crearAxB(tipo, tipo_promo, nombre, atracciones, path_img, description, tipos,atraccionesListadas);
			break;
		case "Absoluta":
			Double precio = Double.parseDouble(req.getParameter("precio"));
			promocion = promocionService.crearAbsoluta(tipo, tipo_promo, nombre, atracciones, precio, path_img, description, tipos,atraccionesListadas);
			break;
		case "Descuento":
			Double porcentajeDescuento = Double.parseDouble(req.getParameter("porcentajeDescuento"));
			promocion = promocionService.crearDescuento(tipo, tipo_promo, nombre, atracciones, porcentajeDescuento, path_img, description, tipos,atraccionesListadas);
			break;
		default:
			break;
		}
	
		if (promocion.isValid()) {	
			resp.sendRedirect("/TurismoEnLaTierraMedia2021WebApp/promociones/listar.adm");
		}else {
			System.out.println("Error en la creacion");
		}
		
	}

	
}
