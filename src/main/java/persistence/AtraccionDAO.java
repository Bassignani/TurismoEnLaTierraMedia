package persistence;

import java.util.LinkedList;

import model.Atraccion;
import model.Tipo;

public interface AtraccionDAO {
	
	public LinkedList<Atraccion> buscarTodos(LinkedList<Tipo> tipos);
	
	public int insert(Atraccion atraccion);

}
