package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Tipo;
import persistence.TipoDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class TipoDAOImpl implements TipoDAO{
	
	
	public LinkedList<Tipo> buscarTodos() {
		try {
			String sql = "SELECT * FROM tipo_de_atracciones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			LinkedList<Tipo> tipos = new LinkedList<Tipo>();
			while (resultados.next()) {
				tipos.add(toTipo(resultados));
			}

			return tipos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Tipo toTipo(ResultSet resultados) throws SQLException {
		return new Tipo(resultados.getInt(1),resultados.getString(2));
	}

}
