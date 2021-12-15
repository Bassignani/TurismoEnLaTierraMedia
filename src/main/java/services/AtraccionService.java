package services;


import java.util.LinkedList;
import model.Atraccion;
import model.Tipo;
import persistence.commons.DAOFactory;

public class AtraccionService {
	
	public LinkedList<Atraccion> listar() {
		return DAOFactory.getAtraccionDAO().buscarTodos();
	}
	
	public Atraccion crear(String nombre,Double costo,Double duracion,Integer cupo,String description,Tipo tipo,String path_img) {
		Atraccion atraccion = new Atraccion(1, nombre, costo, duracion, tipo, cupo, true, path_img, description);
		
		if (atraccion.isValid()) {
			DAOFactory.getAtraccionDAO().insert(atraccion);
		}
		return atraccion;
	}
}
