package Jdbc.modelo;

import java.sql.Date;

public class Reserva {

	private Integer id;
	private Date FechaDeE;
	private Date FechaDeS;
	private String valor;
	private String FormaDePago;
	
	
	public Reserva(Date fechaDeE, Date fechaDeS, String valor, String formaDePago) {
		super();
		FechaDeE = fechaDeE;
		FechaDeS = fechaDeS;
		this.valor = valor;
		FormaDePago = formaDePago;
	}


	public Reserva(Integer id, Date fechaDeE, Date fechaDeS, String valor, String formaDePago) {
		super();
		this.id = id;
		FechaDeE = fechaDeE;
		FechaDeS = fechaDeS;
		this.valor = valor;
		FormaDePago = formaDePago;
	}


	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFechaDeE() {
		return FechaDeE;
	}


	public void setFechaDeE(Date fechaDeE) {
		FechaDeE = fechaDeE;
	}


	public Date getFechaDeS() {
		return FechaDeS;
	}


	public void setFechaDeS(Date fechaDeS) {
		FechaDeS = fechaDeS;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getFormaDePago() {
		return FormaDePago;
	}


	public void setFormaDePago(String formaDePago) {
		FormaDePago = formaDePago;
	}
	
	
	
	
}
