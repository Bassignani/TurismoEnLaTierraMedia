package services;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import persistence.commons.DAOFactory;

public class PromocionService {
	
	
	public LinkedList<Promocion> listar(LinkedList<Atraccion> atracciones) {
		return DAOFactory.getPromocionDAO().buscarTodos(atracciones);
	}
}
