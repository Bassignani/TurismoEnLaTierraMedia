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
	
	

	private Promocion toPromocion(ResultSet resultados, LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos) throws SQLException {
		LinkedList<Atraccion> atraccionesPromocion = new LinkedList<Atraccion>();
		String tipoPromocion = resultados.getString(3);
		Integer id = resultados.getInt(1);
		Tipo tipo = toTipo(resultados.getInt(2), tipos);
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
	
	
	
	private Tipo toTipo(int resultado, LinkedList<Tipo> tipos) throws SQLException{
		int id = resultado;
		Tipo tmp_tipo = null;
		for (Tipo tipo : tipos) {
			if (tipo.getId() == id) {
				tmp_tipo = tipo;
			}
		}
		return tmp_tipo;
	}
	
	
}
