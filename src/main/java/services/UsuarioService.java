package services;

import java.util.LinkedList;

import model.Tipo;
import model.Usuario;
import model.Vendible;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class UsuarioService {
	 
	LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();
	
	public LinkedList<Usuario> listar(LinkedList<Vendible> vendibles) {
		return DAOFactory.getUsuarioDAO().buscarTodos(vendibles);
	}

	public Usuario busacarPorId(Integer id, LinkedList<Vendible> vendibles) {
		return DAOFactory.getUsuarioDAO().buscarPorId(id,vendibles);
	}
	
	
	public Usuario create(String nombre, Double presupuesto, Double tiempoDisponible, Tipo tipoDeAtraccion, Boolean admin, String password, String path_img){
		Usuario usuario = new Usuario(1, nombre, presupuesto, tiempoDisponible, tipoDeAtraccion, vendiblesComprados, admin, true, password, path_img);
		usuario.setPassword(password);

	if (usuario.isValid()) {
		DAOFactory.getUsuarioDAO().insert(usuario);
		// XXX: si no devuelve "1", es que hubo más errores
	}

	return usuario;
	}
	
	
	public Usuario update(Integer id, String nombre, Double presupuesto, Double tiempoDisponible, Tipo tipoDeAtraccion, Boolean admin,  String path_img){
		
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(id, vendiblesComprados);
		
		usuario.setNombre(nombre);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempoDisponible(tiempoDisponible);
		usuario.setTipoDeAtraccion(tipoDeAtraccion);
		usuario.setAdmin(admin);
		usuario.setPath_img(path_img);

	if (usuario.isValid()) {
		DAOFactory.getUsuarioDAO().update(usuario);
		// XXX: si no devuelve "1", es que hubo más errores
	}

	return usuario;
	}
	
}
