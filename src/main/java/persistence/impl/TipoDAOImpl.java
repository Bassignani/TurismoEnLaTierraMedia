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
	
	public int insert(Tipo tipo) {
		try {
			String sql = "INSERT INTO tipo_de_atracciones (TIPO, ACTIVE) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();
	
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipo.getNombre().toUpperCase());
			statement.setBoolean(2, true);
			int rows = statement.executeUpdate();

			return rows;
		}catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int delete(Tipo tipo) {
		try {
			String sql = "DELETE FROM tipo_de_atracciones WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tipo.getId());
			int rows = statement.executeUpdate();
			return rows;
		}catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	
	
	public int deactivate(Tipo tipo) {
		try {
			String sql = "UPDATE tipo_de_atracciones SET ACTIVE = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, false);
			statement.setInt(2, tipo.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public int activate(Tipo tipo) {
		try {
			String sql = "UPDATE tipo_de_atracciones SET ACTIVE = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, true);
			statement.setInt(2, tipo.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public Tipo buscarPorId(Integer id) {
		try {
			String sql = "SELECT * FROM tipo_de_atracciones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			Tipo tipo = null;
			if (resultados.next()) {
				tipo = toTipo(resultados);
			}
			return tipo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
	
	private Tipo toTipo(ResultSet resultados) throws SQLException {
		return new Tipo(resultados.getInt(1),resultados.getString(2), resultados.getBoolean(3));
	}

}
