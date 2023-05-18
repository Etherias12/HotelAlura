package Jdbc.Factory;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

	private DataSource datasource;
	
	public ConnectionFactory() {
		var PoollDataSource = new ComboPooledDataSource();
		PoollDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		PoollDataSource.setUser("root");
		PoollDataSource.setPassword("Dioses12@");
		
		datasource = PoollDataSource;
	}

	public Connection CrearConexion()  {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	 
	 
}
