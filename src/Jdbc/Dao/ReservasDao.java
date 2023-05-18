package Jdbc.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Jdbc.modelo.Reserva;

public class ReservasDao {

	private Connection con;

	public ReservasDao(Connection connection) {
		this.con = connection;
	}
	
	public void guardar(Reserva reserva) {
		String sql ="INSERT INTO reserva (FechaDeEntrada, FechaDeSalida, Valor,FormaDePago)" + " VALUES(?,?,?,?)";
		
		try(PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			pstm.setDate(1, reserva.getFechaDeE());
			pstm.setDate(2, reserva.getFechaDeS());
			pstm.setString(3, reserva.getValor());
			pstm.setString(4, reserva.getFormaDePago());
			
			pstm.executeUpdate();
			try(ResultSet rst = pstm.getGeneratedKeys()){
				while(rst.next()) {
					reserva.setId(rst.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public List<Reserva> buscar(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			String sql = "SELECT  id, FechaDeEntrada, FechaDeSalida, Valor, FormaDePago FROM reserva ";
		
				try(PreparedStatement pstm = con.prepareStatement(sql)) {
					pstm.execute();
		
				transformarResultSetEnReserva(reservas, pstm);
		}
		return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> BuscarPorId(String id){
		List<Reserva> reserva = new ArrayList<Reserva>();
		try {
		String sql = "SELECT id, FechaDeEntrada, FechaDeSalida, Valor, FormaDePago FROM reserva WHERE id = ?";
		
		try(PreparedStatement pstm = con.prepareStatement(sql)){
			pstm.setString(1, id);
			pstm.execute();
			
			transformarResultSetEnReserva(reserva, pstm);
		}
			return reserva;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Eliminar(Integer id) {
		try(PreparedStatement pstm = con.prepareStatement("DELETE FROM reserva WHERE id = ?")){
		pstm.setInt(1, id);	
		pstm.execute();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	}
	
	public void Actualizar(Date FechaDeE, Date FechaDeS, String Valor, String FormaDePago, Integer id) {
		try(PreparedStatement pstm = con.prepareStatement("UPDATE reserva SET FechaDeSalida = ?, FechaDeSalida = ?,"
				+ "Valor = ?, FormaDePago = ? WHERE id = ?")){
			pstm.setDate(1, FechaDeE);
			pstm.setDate(2, FechaDeS);
			pstm.setString(3, Valor);
			pstm.setString(4, FormaDePago);
			pstm.setInt(5, id);
			pstm.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void transformarResultSetEnReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reserva produto = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

				reservas.add(produto);
			}
		}
	}
}
