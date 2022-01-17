package services;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import model.Tipo;
import model.Vendible;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.TipoDAO;
import persistence.commons.DAOFactory;

public class ItinerarioService {
	
	public  LinkedList<Vendible> listar(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		TipoDAO tipoDAO = DAOFactory.getTipoDAO();
		LinkedList<Tipo> tipos = tipoDAO.buscarTodos();
		LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();
		LinkedList<Atraccion> atracciones = atraccionDAO.buscarTodos(tipos);
		LinkedList<Promocion> promociones = promocionDAO.buscarTodos(atracciones, tipos);
		LinkedList<Vendible> vendibles = new LinkedList<Vendible>();	
		vendibles.addAll(promociones);
		vendibles.addAll(atracciones);
		vendiblesComprados = itinerarioDAO.listartinerario(id, vendibles ,tipos);
		
		return vendiblesComprados;
	}
	


}
