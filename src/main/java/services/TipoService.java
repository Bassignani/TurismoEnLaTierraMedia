package services;


import java.sql.SQLException;
import java.util.LinkedList;
import model.Tipo;
import persistence.commons.DAOFactory;

public class TipoService {
	
	public LinkedList<Tipo> listar() {
		return DAOFactory.getTipoDAO().buscarTodos();
	}
	
	public Tipo create(String nombreTipo) {
		Tipo tipo = new Tipo(1, nombreTipo, true);
		DAOFactory.getTipoDAO().insert(tipo);
		return tipo;	
	}
	
	public Tipo toTipo(int resultado, LinkedList<Tipo> tipos) throws SQLException{
		int id = resultado;
		Tipo tmp_tipo = null;
		for (Tipo tipo : tipos) {
			if (tipo.getId() == id) {
				tmp_tipo = tipo;
			}
		}
		return tmp_tipo;
	}
	
	
	public Tipo buscarPorId(Integer id) {
		return DAOFactory.getTipoDAO().buscarPorId(id);
	}
	
	public int deactivate(Tipo tipo) {
		return DAOFactory.getTipoDAO().deactivate(tipo);
	}
	
	public int activate(Tipo tipo) {
		return DAOFactory.getTipoDAO().activate(tipo);
	}
	
	
	
}
