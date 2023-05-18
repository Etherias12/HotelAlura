package Jdbc.modelo;

import java.sql.Date;

public class Huespedes {

	private Integer id;
	private String Nombre;
	private String Apellido;
	private Date FechaDeN;
	private String Nacionalidad;
	private String Telefono;
	private Integer idReserva;
	
	public Huespedes(String nombre, String apellido, Date fechaDeN, String nacionalidad, String telefono,Integer idReserva) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		FechaDeN = fechaDeN;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		this.idReserva = idReserva;
	}

	public Huespedes(Integer id, String nombre, String apellido, Date fechaDeN, String nacionalidad, String telefono, Integer idReserva) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		FechaDeN = fechaDeN;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		this.idReserva = idReserva;
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public Date getFechaDeN() {
		return FechaDeN;
	}

	public void setFechaDeN(Date fechaDeN) {
		FechaDeN = fechaDeN;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	
	
	
	
	
}
