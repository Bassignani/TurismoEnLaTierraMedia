package persistence;

import java.util.LinkedList;

import model.Tipo;

public interface TipoDAO {

	public LinkedList<Tipo> buscarTodos();
}
