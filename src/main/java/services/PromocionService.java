package services;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import model.Tipo;
import persistence.commons.DAOFactory;

public class PromocionService {
	
	
	public LinkedList<Promocion> listar(LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos) {
		return DAOFactory.getPromocionDAO().buscarTodos(atracciones, tipos);
	}
}
