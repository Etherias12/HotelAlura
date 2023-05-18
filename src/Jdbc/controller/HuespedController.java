package Jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import Jdbc.Dao.HuespedesDAO;
import Jdbc.Factory.ConnectionFactory;
import Jdbc.modelo.Huespedes;

public class HuespedController {

	private HuespedesDAO huespedesDAO;

	public HuespedController() {
		Connection connection = new ConnectionFactory().CrearConexion();
		this.huespedesDAO = new HuespedesDAO(connection);
	}
	
	public void guardar(Huespedes huespedes) {
		this.huespedesDAO.guardar(huespedes);
	}
	
	public List<Huespedes> ListarHuespedes(){
	 return this.huespedesDAO.ListarHuespedes();
	}
	
	public List<Huespedes> ListarPorId(String Id){
		return this.huespedesDAO.BusquedaId(Id);
	}
	
	
	public void Actualizar(String nombre, String Apellido, Date FechaDeNacimiento, String Nacionalidad, String Telefono, Integer idReserva, Integer id) {
		this.huespedesDAO.actualizar(nombre, Apellido, FechaDeNacimiento, Nacionalidad, Telefono, idReserva, id);
	}
	
	public void Eliminar(Integer id) {
		this.huespedesDAO.Eliminar(id);
	}
}
