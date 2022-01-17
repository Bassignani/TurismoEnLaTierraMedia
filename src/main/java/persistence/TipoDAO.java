package persistence;

import java.util.LinkedList;

import model.Tipo;

public interface TipoDAO {

	public LinkedList<Tipo> buscarTodos();
	
	public int insert(Tipo tipo);
	
	public int delete(Tipo tipo);
	
	public int deactivate(Tipo tipo);
	
	public int activate(Tipo tipo);
	
	public Tipo buscarPorId(Integer id);
}
