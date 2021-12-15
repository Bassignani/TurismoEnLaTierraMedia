package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Usuario;
import model.Vendible;
import model.nullobjects.NullUsuario;
import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import model.Tipo;


public class UsuarioDAOImpl implements UsuarioDAO {
	

	public LinkedList<Usuario> buscarTodos(LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) {
		try {
			String sql = "SELECT u.id, u.nombre, u.tipo_id, u.monedas, u.tiempo_disponible, tda.id , group_concat(i.promocion_id),group_concat(i.atraccion_id) , u.admin, u.active, u.password, u.path_img\n"
					+ "		FROM usuarios u  INNER JOIN tipo_de_atracciones tda ON u.tipo_id = tda.id LEFT JOIN itinerarios i ON u.id = i.usuario_id	GROUP BY u.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
			
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados, vendibles, tipos));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public Usuario buscarPorNombre(String nombre, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) {
		try {
			String sql = "SELECT u.id, u.nombre, u.tipo_id, u.monedas, u.tiempo_disponible, tda.id , group_concat(i.promocion_id),group_concat(i.atraccion_id) , u.admin, u.active, u.password, u.path_img\n"
					+ "		FROM usuarios u  INNER JOIN tipo_de_atracciones tda ON u.tipo_id = tda.id LEFT JOIN itinerarios i ON u.id = i.usuario_id  WHERE u.nombre = ?	GROUP BY u.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = NullUsuario.build();

			if (resultados.next()) {
				usuario = toUsuario(resultados, vendibles, tipos);
			}

			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}
	
	
	public int update(Usuario usuario) {
		try {
			String sql = "UPDATE usuarios SET NOMBRE = ?, TIPO_ID = ?, MONEDAS = ?, TIEMPO_DISPONIBLE = ?, ADMIN = ?, ACTIVE = ?, PATH_IMG = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setInt(2, usuario.getTipo().getId());
			statement.setDouble(3, usuario.getPresupuesto());
			statement.setDouble(4, usuario.getTiempoDisponible());
			statement.setBoolean(5, usuario.getAdmin());
			statement.setBoolean(6, true);
			statement.setString(7, usuario.getPathImg());
			statement.setInt(8, usuario.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public int deactivate(Usuario usuario) {
		try {
			String sql = "UPDATE usuarios SET ACTIVE = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, false);
			statement.setInt(2, usuario.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public int activate(Usuario usuario) {
		try {
			String sql = "UPDATE usuarios SET ACTIVE = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, true);
			statement.setInt(2, usuario.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
	public int insert(Usuario usuario) {
		
		try {
			String sql = "INSERT INTO usuarios (NOMBRE, TIPO_ID, MONEDAS, TIEMPO_DISPONIBLE, ADMIN, ACTIVE, PASSWORD, PATH_IMG) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setInt(2, usuario.getTipo().getId());
			statement.setDouble(3, usuario.getPresupuesto());
			statement.setDouble(4, usuario.getTiempoDisponible());
			statement.setBoolean(5, usuario.getAdmin());
			statement.setBoolean(6, true);
			statement.setString(7, usuario.getPassword());
			statement.setString(8, usuario.getPathImg());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	public Usuario buscarPorId(Integer id, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) {
		try {
			String sql = "SELECT u.id, u.nombre, u.tipo_id, u.monedas, u.tiempo_disponible, tda.id , group_concat(i.promocion_id),group_concat(i.atraccion_id) , u.admin, u.active, u.password, u.path_img\n"
					+ "		FROM usuarios u  INNER JOIN tipo_de_atracciones tda ON u.tipo_id = tda.id LEFT JOIN itinerarios i ON u.id = i.usuario_id  WHERE u.id = ?	GROUP BY u.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = NullUsuario.build();

			if (resultados.next()) {
				usuario = toUsuario(resultados, vendibles, tipos);
			}

			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}
	
	
	
	
	
	
	
	
	
	private Usuario toUsuario(ResultSet resultados, LinkedList<Vendible> vendibles, LinkedList<Tipo> tipos) throws SQLException {
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
		return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getDouble(4),
				resultados.getDouble(5), toTipo(resultados.getInt(6), tipos), vendiblesComprados, resultados.getBoolean(9), 
				resultados.getBoolean(10), resultados.getString(11), resultados.getString(12));
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
