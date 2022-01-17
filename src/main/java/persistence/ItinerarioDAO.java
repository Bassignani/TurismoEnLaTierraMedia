package persistence;


import java.util.LinkedList;

import model.Tipo;
import model.Usuario;
import model.Vendible;


public interface ItinerarioDAO {

	public void llenarItinerario(Usuario usuario);
	
	public LinkedList<Vendible> listartinerario(Integer id, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos);
}
