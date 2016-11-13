package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private final String URL = "jdbc:mysql://localhost:3306/almacen?autoReconnect=true&useSSL=false";
	private final String USUARIO = "root";
	private final String PASS = "juan9608";
	
	public Connection conexion = null;
	
	public Conexion() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("finally")
	public Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(URL, USUARIO, PASS);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			return conexion;
		}
	}

}
