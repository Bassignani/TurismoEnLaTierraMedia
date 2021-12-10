package services;

import java.util.LinkedList;
import java.util.List;

import model.Usuario;
import model.Vendible;
import persistence.commons.DAOFactory;

public class UsuarioService {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().buscarTodos(LinkedList<Vendible> vendibles);
	}

	public Usuario create(String username, String password, Integer coins, Double time) {
		Usuario usuario = new Usuario(-1, username, password, coins, time, false);
		usuario.setPassword(password);

		if (usuario.isValid()) {
			DAOFactory.getUsuarioDAO().insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}
	
}
