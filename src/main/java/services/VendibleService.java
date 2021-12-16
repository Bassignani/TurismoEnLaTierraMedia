package services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import model.Atraccion;
import model.Promocion;
import model.Tipo;
import model.Usuario;
import model.Vendible;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.UsuarioDAO;
import persistence.PromocionDAO;
import persistence.TipoDAO;
import persistence.commons.DAOFactory;

public class VendibleService {
	
	public  LinkedList<Vendible> listar() {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			TipoDAO tipoDAO = DAOFactory.getTipoDAO();
			LinkedList<Tipo> tipos = tipoDAO.buscarTodos();
			LinkedList<Atraccion> atracciones = atraccionDAO.buscarTodos(tipos);
			LinkedList<Promocion> promociones = promocionDAO.buscarTodos(atracciones, tipos);
			LinkedList<Vendible> vendibles = new LinkedList<Vendible>();
			
			vendibles.addAll(promociones);
			vendibles.addAll(atracciones);	
			return vendibles;
		}

	public Map<String, String> comprar(Usuario usuario, Integer vendible_id, Boolean esPromo) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		TipoDAO tipoDAO = DAOFactory.getTipoDAO();
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		LinkedList<Tipo> tipos = tipoDAO.buscarTodos();
		LinkedList<Atraccion> atracciones = atraccionDAO.buscarTodos(tipos);		
		
		Map<String, String> errors = new HashMap<String, String>();

		if(esPromo) {
			Promocion promocion = promocionDAO.buscarPorId(vendible_id,atracciones,tipos);
			usuario.comprarVendible(promocion);
			usuarioDAO.update(usuario); //UPDATE USER
			for (Atraccion atraccion : promocion.getAtracciones()) { //UPDATE PROMO 
				atraccionDAO.update(atraccion);
			}		
			
		}else {
			Atraccion atraccion = atraccionDAO.buscarPorId(vendible_id, tipos);
			usuario.comprarVendible(atraccion);	
			usuarioDAO.update(usuario);	//UPDATE USER
			atraccionDAO.update(atraccion);		
		}
//		itinerarioDAO.llenarItinerario(usuario);
		return errors;
	}
	
}




