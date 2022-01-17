package persistence;

import java.util.LinkedList;

import model.Tipo;
import model.Usuario;
import model.Vendible;

public interface UsuarioDAO {
	
	public LinkedList<Usuario> findAll(LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos);
	
	public Usuario buscarPorNombre(String nombre, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos);

	public int insert(Usuario usuario);
	
	public Usuario buscarPorId(Integer id, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos);
	
	public int update(Usuario usuario);
	
	public int deactivate(Usuario usuario);
	
	public int activate(Usuario usuario);


}
