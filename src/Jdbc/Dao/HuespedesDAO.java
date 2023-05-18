package Jdbc.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Jdbc.modelo.Huespedes;

public class HuespedesDAO {

	private Connection con;

	public HuespedesDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Huespedes huespedes) {
		try {
			String sql = "INSERT INTO huespedes(Nombre, Apellido, FechaDeNacimiento, Nacionalidad, Telefono, id_Reserva) "
					+ "Values(?,?,?,?,?,?)";
			try (PreparedStatement prsm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				prsm.setString(1, huespedes.getNombre());
				prsm.setString(2, huespedes.getApellido());
				prsm.setDate(3, huespedes.getFechaDeN());
				prsm.setString(4, huespedes.getNacionalidad());
				prsm.setString(5, huespedes.getTelefono());
				prsm.setInt(6, huespedes.getIdReserva());
				
				prsm.execute();

				try (ResultSet rst = prsm.getGeneratedKeys()) {
					while (rst.next()) {
						huespedes.setId(rst.getInt(1));
					}
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> ListarHuespedes() {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, Nombre, Apellido, FechaDeNacimiento, Nacionalidad, Telefono, id_Reserva FROM huespedes";

			try (PreparedStatement prsm = con.prepareStatement(sql)) {
				prsm.execute();
				ResultSet rst = prsm.getResultSet();

				try (rst) {
					while (rst.next()) {
						huespedes.add(new Huespedes(rst.getInt("id"), rst.getString("Nombre"),
								rst.getString("Apellido"), rst.getDate("FechaDeNacimiento"),
								rst.getString("Nacionalidad"), rst.getString("Telefono"), rst.getInt("id_Reserva")));
					}
				}
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> BusquedaId(String id) {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, Nombre, Apellido, FechaDeNacimiento, Nacionalidad, Telefono, id_Reserva FROM huespedes WHERE id_Reserva = ?";
			try (PreparedStatement prsm = con.prepareStatement(sql)) {
				prsm.setString(1, id);
				prsm.execute();
				ResultSet rst = prsm.getResultSet();

				try (rst) {
					while (rst.next()) {
						huespedes.add(new Huespedes(rst.getInt("id"), rst.getString("Nombre"),
								rst.getString("Apellido"), rst.getDate("FechaDeNacimiento"),
								rst.getString("Nacionalidad"), rst.getString("Telefono"), rst.getInt("idReserva")));
					}
				}
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void actualizar(String nombre, String Apellido, Date FechaDeNacimiento, String Nacionalidad, String Telefono, Integer idReserva, Integer id) {
		try(PreparedStatement pstm = con.prepareStatement("UPDATE huespedes SET Nombre = ?, Apellido = ?, FechaDeNacimiento = ? "
				+ "Nacionalidad = ?, Telefono = ?, idReserva = ?, Id = ?")){
			pstm.setString(1, nombre);
			pstm.setString(2, Apellido);
			pstm.setDate(3, FechaDeNacimiento);
			pstm.setString(4, Nacionalidad);
			pstm.setString(5, Telefono);
			pstm.setInt(6, idReserva);
			pstm.setInt(7, id);
			pstm.execute();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Eliminar(Integer id) {
		try(PreparedStatement pstm = con.prepareStatement("DELETE FROM huespedes WHERE id = ?")){
			pstm.setInt(1, id);
			pstm.execute();		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
