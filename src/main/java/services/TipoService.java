package services;

import java.util.LinkedList;

import model.Tipo;
import persistence.commons.DAOFactory;

public class TipoService {
	
	public LinkedList<Tipo> listar() {
		return DAOFactory.getTipoDAO().buscarTodos();
	}
}
