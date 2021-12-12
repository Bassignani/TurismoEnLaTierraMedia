package services;

import java.util.LinkedList;
import model.Tipo;
import model.Usuario;
import model.Vendible;
import persistence.commons.DAOFactory;

public class UsuarioService {
	
	LinkedList<Vendible> vendibles = Vendible.getVendibles();   //Preguntar al igna a donde ponerlo
	LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();
	
	public LinkedList<Usuario> listar() {
		return DAOFactory.getUsuarioDAO().buscarTodos(vendibles);
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
	
}
