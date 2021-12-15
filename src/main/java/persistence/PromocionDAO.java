package persistence;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import model.Tipo;

public interface PromocionDAO {

	public LinkedList<Promocion> buscarTodos(LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos);
	
	public Promocion buscarPorId(Integer id, LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos);
}
