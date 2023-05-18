package Jdbc.Factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
	
	public static void main(String[] args) throws SQLException {
	
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.CrearConexion();

		System.out.println("Probando conexion!!");

		connection.close();
		
		System.out.println("Conexión cerrada!!");
	}
}
