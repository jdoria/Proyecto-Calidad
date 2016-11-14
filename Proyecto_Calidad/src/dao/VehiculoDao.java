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
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vehiculos;
	}

	public void crearVehiculo(Vehiculo vehiculo){
		Conexion conexion = new Conexion();
		String query = "";
		try{
			sentencia = conexion.conectar().createStatement();
			query = "INSERT INTO VEHICULO (idVehiculo, idLinea1, precio, modelo) VALUES ('"+vehiculo.getIdVehiculo()+"', '"+vehiculo.getIdLinea1()+"', '"+vehiculo.getPrecio()+"', '"+vehiculo.getModelo()+"')";
			sentencia.executeUpdate(query);
			sentencia.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
