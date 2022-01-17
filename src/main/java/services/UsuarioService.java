package services;

import java.util.LinkedList;

import model.Promocion;
import model.Tipo;
import model.Usuario;
import model.Vendible;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class UsuarioService {
	 
	LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();
	LinkedList<Tipo> tipos = new LinkedList<Tipo>();
	
	public LinkedList<Usuario> listar(LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) {
		return DAOFactory.getUsuarioDAO().findAll(vendibles, tipos);
	}

	public Usuario busacarPorId(Integer id, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) {
		return DAOFactory.getUsuarioDAO().buscarPorId(id, vendibles, tipos);
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
		Usuario usuario = usuarioDAO.buscarPorId(id, vendiblesComprados, tipos);
		
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
	
	
	
	
	public Usuario deactivate(Integer id, String nombre, Double presupuesto, Double tiempoDisponible, Tipo tipoDeAtraccion, Boolean admin,  String path_img){
		
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(id, vendiblesComprados, tipos);
		
		usuario.setNombre(nombre);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempoDisponible(tiempoDisponible);
		usuario.setTipoDeAtraccion(tipoDeAtraccion);
		usuario.setAdmin(admin);
		usuario.setPath_img(path_img);

	if (usuario.isValid()) {
		DAOFactory.getUsuarioDAO().deactivate(usuario);
		// XXX: si no devuelve "1", es que hubo más errores
	}

	return usuario;
	}
	
	
	
	public Usuario activate(Integer id, String nombre, Double presupuesto, Double tiempoDisponible, Tipo tipoDeAtraccion, Boolean admin,  String path_img){
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(id, vendiblesComprados, tipos);
		
		usuario.setNombre(nombre);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempoDisponible(tiempoDisponible);
		usuario.setTipoDeAtraccion(tipoDeAtraccion);
		usuario.setAdmin(admin);
		usuario.setPath_img(path_img);

	if (usuario.isValid()) {
		DAOFactory.getUsuarioDAO().activate(usuario);
		// XXX: si no devuelve "1", es que hubo más errores
	}

	return usuario;
	}
	
	
	
	public LinkedList<Vendible> yaCompro(LinkedList<Vendible> vendibles, LinkedList<Vendible> vendiblesComprados){
		LinkedList<Vendible> vendiblesAOfertar = new LinkedList<Vendible>();
		LinkedList<Vendible> vendiblesPromo = new LinkedList<Vendible>();
		LinkedList<Vendible> vendiblesAtracc = new LinkedList<Vendible>();
		
		LinkedList<Vendible> vendiblesCompradosPromo = new LinkedList<Vendible>();
		LinkedList<Vendible> vendiblesCompradosAtracc = new LinkedList<Vendible>();
		
		for (int i = 0; i < vendibles.size(); i++) {
			if (vendibles.get(i).esPromo()) {
				vendiblesPromo.add(vendibles.get(i));
			}else {
				vendiblesAtracc.add(vendibles.get(i));
			}
		}
		
		for (int j = 0; j < vendiblesComprados.size(); j++) {
			if (vendiblesComprados.get(j).esPromo()) {
				vendiblesCompradosPromo.add(vendibles.get(j));
			}else {
				vendiblesCompradosAtracc.add(vendibles.get(j));
			}
		}
		
		
		for (Vendible vendible : vendiblesPromo) {
			if(!vendiblesCompradosPromo.contains(vendible)) {
				vendiblesAOfertar.add(vendible);
			}
		}	
		
		for (Vendible vendible : vendiblesAtracc) {
			if(!vendiblesCompradosAtracc.contains(vendible)) {
				vendiblesAOfertar.add(vendible);
			}
		}

		return vendiblesAOfertar;
	}
	
	
	
}



