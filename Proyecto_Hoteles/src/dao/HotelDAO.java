package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import modelo.Habitacion;


public class HotelDAO {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public ArrayList<Habitacion> GetHabitaciones(){
		ArrayList<Habitacion> habitaciones = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idHabitacion, tipo, cantidad, cama, precio, tamaño, numPersonas from habitacion;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Habitacion a = new Habitacion();
				a.setIdHabitacion(Integer.parseInt("idHabitacion"));
				a.setTipo("tipo");
				a.setCantidad(Integer.parseInt("cantidad"));
				a.setCama("cama");
				a.setPrecio(Integer.parseInt("precio"));
				a.setTamaño("tamaño");
				a.setNumPersonas(Integer.parseInt("numPersonas"));
				habitaciones.add(a);
				
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return habitaciones;
	}
	
	public void adicionarHabitacion(String tipo, int cantidad, String cama, int precio, String tamaño, int numPersonas){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "insert into habitacion(tipo, cantidad, cama, precio, tamaño, numPersonas) values('"+tipo+"', '"+cantidad+"', '"+cama+"', '"+precio+"', '"+tamaño+"', '"+numPersonas+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
