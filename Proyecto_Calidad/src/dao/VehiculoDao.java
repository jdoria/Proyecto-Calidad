package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.Vehiculo;

public class VehiculoDao {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public VehiculoDao() {
		// TODO Auto-generated constructor stub
		this.sentencia = null;
		this.rs = null;
	}
	
	
	public ArrayList<Vehiculo> GetVehiculos(){
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idVehiculo, precio, modelo, from vehiculo;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Vehiculo a = new Vehiculo();
				a.setIdVehiculo(rs.getString("idVehiculo"));
				a.setPrecio(rs.getFloat("precio"));
				a.setModelo(rs.getInt("modelo"));
				vehiculos.add(a);
				
			}
			sentencia.close();																																																																																																																																																																																																																																																																																						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vehiculos;
	}


}
