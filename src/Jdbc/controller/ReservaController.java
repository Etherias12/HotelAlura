package Jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import Jdbc.Dao.ReservasDao;
import Jdbc.Factory.ConnectionFactory;
import Jdbc.modelo.Reserva;

public class ReservaController {

	private ReservasDao reservaDao;

	public ReservaController() {
		Connection con = new ConnectionFactory().CrearConexion();
		this.reservaDao = new ReservasDao(con);
	}
	
	public void guardar(Reserva reserva) {
		this.reservaDao.guardar(reserva);
	}
	
	public List<Reserva> Buscar(){
		return this.reservaDao.buscar();
	}
	
	public List<Reserva> BuscarId(String id){
		return this.reservaDao.BuscarPorId(id);
	}
	
	public void Eliminar(Integer id) {
		this.reservaDao.Eliminar(id);
	}
	
	public void Actualizar(Date FechaDeEntrada, Date FechaDeSalida, String Valor, String FormaDePago, Integer id) {
		this.reservaDao.Actualizar(FechaDeEntrada, FechaDeSalida, Valor, FormaDePago, id);
	}
}
