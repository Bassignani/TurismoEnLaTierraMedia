package persistence;

import java.util.LinkedList;

import model.Usuario;
import model.Vendible;

public interface UsuarioDAO {
	
	public LinkedList<Usuario> buscarTodos(LinkedList<Vendible> vendibles);
	
	public Usuario buscarPorNombre(String nombre, LinkedList<Vendible> vendibles);

	public int insert(Usuario usuario);
	
	public Usuario buscarPorId(Integer id, LinkedList<Vendible> vendibles);
	
	public int update(Usuario usuario);

}
