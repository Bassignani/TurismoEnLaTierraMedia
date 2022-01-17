package persistence.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionDescuento;
import model.Tipo;
import persistence.PromocionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import services.TipoService;

public class PromocionDAOImpl implements PromocionDAO {

	public LinkedList<Promocion> buscarTodos(LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos) {
		try {
			String sql = "SELECT p.id, tda.id, p.tipo_de_promocion, p.nombre_pack, p.referencia_costo, p.cantidad_atracciones, group_concat(a.nombre), p.active, p.path_img, p.description\n"
					+ "FROM promociones p \n"
					+ "INNER JOIN promociones_atracciones pa ON p.id = pa.promocion_id\n"
					+ "INNER JOIN atracciones a ON pa.atraccion_id = a.id\n"
					+ "INNER JOIN tipo_de_atracciones tda ON p.tipo_id = tda.id\n"
					+ "GROUP BY p.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			LinkedList<Promocion> promociones = new LinkedList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados, atracciones, tipos));
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	
	public Promocion buscarPorId(Integer id, LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos) {
		try {
			String sql = "SELECT p.id, tda.id, p.tipo_de_promocion, p.nombre_pack, p.referencia_costo, p.cantidad_atracciones, group_concat(a.nombre), p.active, p.path_img, p.description\n"
					+ "FROM promociones p \n"
					+ "INNER JOIN promociones_atracciones pa ON p.id = pa.promocion_id\n"
					+ "INNER JOIN atracciones a ON pa.atraccion_id = a.id\n"
					+ "INNER JOIN tipo_de_atracciones tda ON p.tipo_id = tda.id WHERE p.id=?\n"
					+ "GROUP BY p.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			Promocion promocion = null;
			if (resultados.next()) {
				promocion = toPromocion(resultados, atracciones,tipos);
			}
			return promocion;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}
	
	
	public int insert(Promocion promocion, LinkedList<Tipo> tipos, LinkedList<Atraccion> atracciones) {
		try {
			String sql = "INSERT INTO promociones (tipo_id, tipo_de_promocion, nombre_pack, referencia_costo, cantidad_atracciones, active, path_img, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promocion.getTipo().getId());
			statement.setString(2, promocion.getTipoPromocion());
			statement.setString(3, promocion.getNombre());
			
			switch (promocion.getTipoPromocion()) {
			case "AxB":
				statement.setString(4, null);
				break;
			case "Absoluta":
				statement.setDouble(4, promocion.getPrecio()); 
				break;
			case "Descuento":
				statement.setDouble(4, promocion.getPorcentajeDescuento());
				break;
			default:
				break;
			}
			statement.setInt(5, promocion.getCantidadAtracciones()); 
			statement.setBoolean(6, true);
			statement.setString(7, promocion.getPathImg());
			statement.setString(8, promocion.getDescription());
			int rows = statement.executeUpdate();
			
			//Obtengo el id del la promo que se acaba de guardar
			String sql1 = "SELECT id FROM promociones ORDER BY RowId DESC  LIMIT 1";
			Connection conn1 = ConnectionProvider.getConnection();
			PreparedStatement statement1 = conn1.prepareStatement(sql1);
			ResultSet resultado =  statement1.executeQuery();
			Integer id = null;
			if (resultado.next()) {
				id = resultado.getInt("id");
			}
			int rows1 = insertAtracciones(id, atracciones);
			return rows; 
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	public int insertAtracciones(Integer id, LinkedList<Atraccion> atracciones){
		try {
			Integer rows =  null;
			for (Atraccion atraccion : atracciones) {
				String sql = "INSERT INTO promociones_atracciones (promocion_id, atraccion_id) VALUES (?, ?)";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, id);
				statement.setInt(2, atraccion.getId());
				rows = statement.executeUpdate();		
			}
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}	
	}
	
	
	
	public int deactivate(Promocion promocion) {
		try {
			String sql = "UPDATE promociones SET ACTIVE = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, false);
			statement.setInt(2, promocion.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	public int activate(Promocion promocion) {
		try {
			String sql = "UPDATE promociones SET ACTIVE = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, true);
			statement.setInt(2, promocion.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	

	private Promocion toPromocion(ResultSet resultados, LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos) throws SQLException {
		LinkedList<Atraccion> atraccionesPromocion = new LinkedList<Atraccion>();
		TipoService tipoService = new TipoService();
		String tipoPromocion = resultados.getString(3);
		Integer id = resultados.getInt(1);
		Tipo tipo = tipoService.toTipo(resultados.getInt(2), tipos);
		String nombrePack = resultados.getString(4);
		double valor_referencia = resultados.getDouble(5);
		String datos[] = resultados.getString(7).split(",");
		Boolean active = resultados.getBoolean(8);
		String path_img = resultados.getString(9);
		String description = resultados.getString(10);

		atraccionesCompradas(atracciones, atraccionesPromocion, datos);

		if (tipoPromocion.equals("Descuento")) {
			PromocionDescuento pd = new PromocionDescuento(id, tipo, tipoPromocion, nombrePack, atraccionesPromocion,
					valor_referencia, active, path_img, description);
			return pd;

		} else if (tipoPromocion.equals("Absoluta")) {
			PromocionAbsoluta pa = new PromocionAbsoluta(id, tipo, tipoPromocion, nombrePack, atraccionesPromocion,
					valor_referencia, active, path_img, description);
			return pa;

		} else {
			PromocionAxB pp = new PromocionAxB(id, tipo, tipoPromocion, nombrePack, atraccionesPromocion, active, path_img, description);
			return pp;

		}

	}
	


	private void atraccionesCompradas(LinkedList<Atraccion> atracciones, LinkedList<Atraccion> atraccionesPromocion, String[] datos) {
		for (int i = 0; i < datos.length; i++) {
			for (Atraccion atraccionActual : atracciones) {
				if (atraccionActual.getNombre().equals(datos[i])) {
					atraccionesPromocion.add(atraccionActual);
				}
			}
		}
	}
	
	
	
	
	

	
	
	
	
	
}
