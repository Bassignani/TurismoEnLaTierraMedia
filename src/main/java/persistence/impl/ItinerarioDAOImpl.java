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
import model.Usuario;
import model.Vendible;
import model.nullobjects.NullUsuario;
import persistence.ItinerarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {


	public void llenarItinerario(Usuario usuario) {
		try {	
			Connection conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			try {				

					for (Vendible v : usuario.getVendiblesComprados()) {
						String sql2;
						if (v.esPromo()) {
							sql2 = "INSERT OR IGNORE INTO itinerarios (usuario_id, promocion_id) VALUES (?, ?);";
						} else {
							sql2 = "INSERT OR IGNORE INTO itinerarios (usuario_id, atraccion_id) VALUES (?, ?);";
						}
						PreparedStatement statement2 = conn.prepareStatement(sql2);
						statement2.setInt(1, usuario.getId());
						statement2.setInt(2, v.getId());
						statement2.executeUpdate();
					}	

			} catch (Exception e) {
				conn.rollback();
				throw new MissingDataException(e);
			} finally {
				conn.commit();
			}
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public LinkedList<Vendible> listartinerario(Integer id, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) {
		try {
			String sql = "SELECT u.*, tda.tipo , group_concat(i.promocion_id),group_concat(i.atraccion_id) \r\n"
					+ "FROM usuarios u \r\n" + "    INNER JOIN tipo_de_atracciones tda ON u.tipo_id = tda.id\r\n"
					+ "    LEFT JOIN itinerarios i ON u.id = i.usuario_id\r\n  WHERE u.id =?  	GROUP BY u.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = null;
			while (resultados.next()) {
				usuario = (toUsuario(resultados, vendibles, tipos));
			}

			return usuario.getVendiblesComprados();
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
	
	private Usuario  toUsuario(ResultSet resultados, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) throws SQLException {
		LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();

		for (Vendible v : vendibles) {
			if (v.esPromo()) {
				if (resultados.getString(7) != null) {
					String idPromociones[] = resultados.getString(7).split(",");
					for (int i = 0; i < idPromociones.length; i++) {
						Integer id = Integer.parseInt(idPromociones[i]);
						if (v.getId().equals(id))
							vendiblesComprados.add(v);
					}
				}
			} else {
				if (resultados.getString(8) != null) {
					String idAtracciones[] = resultados.getString(8).split(",");
					for (int i = 0; i < idAtracciones.length; i++) {
						Integer id = Integer.parseInt(idAtracciones[i]);
						if (v.getId().equals(id))
							vendiblesComprados.add(v);
					}
				}
			}

		}
		Usuario usuario = new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getDouble(4),
				resultados.getDouble(5), toTipo(resultados.getInt(6), tipos), vendiblesComprados, resultados.getBoolean(9), 
				resultados.getBoolean(10), resultados.getString(11), resultados.getString(12));
		return usuario;
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
