package services;

import java.util.LinkedList;
import java.util.List;

import model.Usuario;
import model.Vendible;
import persistence.commons.DAOFactory;

public class UsuarioService {
	
	LinkedList<Vendible> vendibles = Vendible.getVendibles();   //Preguntar al igna a donde ponerlo
	
	public List<Usuario> listar() {
		return DAOFactory.getUsuarioDAO().buscarTodos(vendibles);
	}

//	public Usuario crear(String username, String password, Integer coins, Double time) {
//		User user = new User(-1, username, password, coins, time, false);
//		user.setPassword(password);
//
//		if (user.isValid()) {
//			DAOFactory.getUserDAO().insert(user);
//			// XXX: si no devuelve "1", es que hubo más errores
//		}
//
//		return user;
//	}
	
}
