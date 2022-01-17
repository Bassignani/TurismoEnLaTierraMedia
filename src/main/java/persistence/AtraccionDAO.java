package persistence;

import java.util.LinkedList;

import model.Atraccion;
import model.Tipo;

public interface AtraccionDAO {
	
	public LinkedList<Atraccion> buscarTodos(LinkedList<Tipo> tipos);
	
	public int insert(Atraccion atraccion);
	
	public Atraccion buscarPorId(Integer id,LinkedList<Tipo> tipos);
	
	public LinkedList<Atraccion> buscarPorTipoId(Integer id,LinkedList<Tipo> tipos);
	
	public int update(Atraccion atraccion);
	
	public int deactivate(Atraccion atraccion);
	
	public int activate(Atraccion atraccion);

}
