package services;

import java.util.LinkedList;

import model.Usuario;
import model.Vendible;
import model.nullobjects.NullUsuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class LoginService {
	
	LinkedList<Vendible> vendibles = Vendible.getVendibles();   //Preguntar al igna a donde ponerlo
	
	public Usuario login(String nombre, String password) {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDao.buscarPorNombre(nombre,vendibles);
    	
    	if (usuario.esNull() || !usuario.checkPassword(password)) {
    		usuario = NullUsuario.build();
    	}
    	return usuario;
	}
	
}
