package services;


import java.util.LinkedList;
import model.Atraccion;
import persistence.commons.DAOFactory;

public class AtraccionService {
	
	public LinkedList<Atraccion> listar() {
		return DAOFactory.getAtraccionDAO().buscarTodos();
	}
}
