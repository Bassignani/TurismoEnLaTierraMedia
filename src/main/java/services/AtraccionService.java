package services;


import java.util.LinkedList;
import model.Atraccion;
import model.Tipo;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {
	
	public LinkedList<Atraccion> listar(LinkedList<Tipo> tipos) {
		return DAOFactory.getAtraccionDAO().buscarTodos(tipos);
	}
	
	public Atraccion crear(String nombre,Double costo,Double duracion,Integer cupo,String description,Tipo tipo,String path_img) {
		Atraccion atraccion = new Atraccion(1, nombre, costo, duracion, tipo, cupo, true, path_img, description);
		
		if (atraccion.isValid()) {
			DAOFactory.getAtraccionDAO().insert(atraccion);
		}
		return atraccion;
	}
	
	public Atraccion buscarPorId(Integer id, LinkedList<Tipo> tipos) {
		return DAOFactory.getAtraccionDAO().buscarPorId(id, tipos);
	}
	
	public LinkedList<Atraccion> buscarPorTipoId(Integer id, LinkedList<Tipo> tipos) {
		return DAOFactory.getAtraccionDAO().buscarPorTipoId(id, tipos);
	}
	
	public Atraccion update(Integer id,String nombre,Double costo, Double duracion, Integer cupo, String description, Tipo tipo, String path_img, LinkedList<Tipo> tipos ) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.buscarPorId(id, tipos);
		
		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setDuracion(duracion);
		atraccion.setCupo(cupo);
		atraccion.setDescription(description);
		atraccion.setTipo(tipo);
		atraccion.setPathImg(path_img);
		
		if (atraccion.isValid()) {
			DAOFactory.getAtraccionDAO().update(atraccion);
		}
		return atraccion;
	}
	
	public int deactivate(Integer id, LinkedList<Tipo> tipos) {
		Atraccion atraccion = DAOFactory.getAtraccionDAO().buscarPorId(id, tipos);
		return DAOFactory.getAtraccionDAO().deactivate(atraccion);
	}
	
	public int activate(Integer id, LinkedList<Tipo> tipos) {
		Atraccion atraccion = DAOFactory.getAtraccionDAO().buscarPorId(id, tipos);
		return DAOFactory.getAtraccionDAO().activate(atraccion);
	}
	
	
}
