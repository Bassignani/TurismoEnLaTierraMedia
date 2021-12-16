package services;

import java.util.LinkedList;

import model.Tipo;
import model.Usuario;
import model.Vendible;
import model.nullobjects.NullUsuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class LoginService { 
	
	public Usuario login(String nombre, String password,LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDao.buscarPorNombre(nombre,vendibles, tipos);
    	
    	if (usuario.esNull() || !usuario.checkPassword(password) || !usuario.getActive()) {
    		usuario = NullUsuario.build();
    	}
    	return usuario;
	}
	
}
