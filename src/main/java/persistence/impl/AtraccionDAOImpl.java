package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Atraccion;
import model.Tipo;
import persistence.AtraccionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import services.TipoService;

public class AtraccionDAOImpl implements AtraccionDAO {

	public LinkedList<Atraccion> buscarTodos(LinkedList<Tipo> tipos) {
		try {
			String sql = "SELECT a.id, a.nombre, a.costo, a.duracion, a.cupo, a.tipo_id, tda.tipo, a.active, a.path_img, a.description\n"
					+ "FROM atracciones a INNER JOIN tipo_de_atracciones tda ON a.tipo_id = tda.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
			while (resultados.next()) {
				
				atracciones.add(toAtraccion(resultados, tipos));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultados,LinkedList<Tipo> tipos) throws SQLException {
		TipoService tipoService = new TipoService();
		return new Atraccion(resultados.getInt(1),resultados.getString(2), resultados.getDouble(3), resultados.getDouble(4), 
				(tipoService.toTipo(resultados.getInt(6),tipos)), resultados.getInt(5),resultados.getBoolean(8),resultados.getString(9), resultados.getString(10));
	}
	
	
	
	public int insert(Atraccion atraccion) {
		
		try {
			String sql = "INSERT INTO atracciones (NOMBRE, COSTO, DURACION, CUPO, TIPO_ID, ACTIVE, PATH_IMG, DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setDouble(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getDuracion());
			statement.setInt(4, atraccion.getCupo());
			statement.setInt(5, atraccion.getTipo().getId());
			statement.setBoolean(6, true);
			statement.setString(7, atraccion.getPathImg());
			statement.setString(8, atraccion.getDescription());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	public Atraccion buscarPorId(Integer id,LinkedList<Tipo> tipos) {
		try {
			String sql = "SELECT a.id, a.nombre, a.costo, a.duracion, a.cupo, a.tipo_id, tda.tipo, a.active, a.path_img, a.description\n"
					+ "FROM atracciones a INNER JOIN tipo_de_atracciones tda ON a.tipo_id = tda.id WHERE a.id=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			Atraccion atraccion = null;
			if (resultados.next()) {
				atraccion = toAtraccion(resultados, tipos);
			}
			return atraccion;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}
	
	
	
	public LinkedList<Atraccion> buscarPorTipoId(Integer id,LinkedList<Tipo> tipos){
		try {
			String sql = "SELECT a.id, a.nombre, a.costo, a.duracion, a.cupo, a.tipo_id, tda.tipo, a.active, a.path_img, a.description\n"
					+ "FROM atracciones a INNER JOIN tipo_de_atracciones tda ON a.tipo_id = tda.id WHERE a.tipo_id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			
			LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
			while (resultados.next()) {
				
				atracciones.add(toAtraccion(resultados, tipos));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	
	public int update(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET NOMBRE = ?, COSTO = ?, DURACION = ?, CUPO = ?, TIPO_ID = ?, ACTIVE = ?, PATH_IMG = ?, DESCRIPTION = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setDouble(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getDuracion());
			statement.setInt(4, atraccion.getCupo());
			statement.setInt(5, atraccion.getTipo().getId());
			statement.setBoolean(6, true);
			statement.setString(7, atraccion.getPathImg());
			statement.setString(8, atraccion.getDescription());
			statement.setInt(9, atraccion.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	public int deactivate(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET ACTIVE = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, false);
			statement.setInt(2, atraccion.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public int activate(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET ACTIVE = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, true);
			statement.setInt(2, atraccion.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	
	
}
