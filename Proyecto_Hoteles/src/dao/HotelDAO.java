package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.HabitacionDTO;



public class HotelDAO {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public ArrayList<HabitacionDTO> GetHabitaciones(){
		ArrayList<HabitacionDTO> habitaciones = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idHabitacion, idHotel1, tipo, cantidad, cama, precio, tamaño, numPersonas from habitacion;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				HabitacionDTO a = new HabitacionDTO();
				a.setIdHabitacion(Integer.parseInt("idHabitacion"));
				a.setIdHotel1(Integer.parseInt("idHotel1"));
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
	
	public void adicionarHabitacion(HabitacionDTO habitacion){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "insert into habitacion(idHotel1, tipo, cantidad, cama, precio, tamaño, numPersonas) values('"+habitacion.getIdHotel1()+"', '"+habitacion.getTipo()+"', '"+habitacion.getCantidad()+"', '"+habitacion.getCama()+"', '"+habitacion.getPrecio()+"', '"+habitacion.getTamaño()+"', '"+habitacion.getNumPersonas()+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void modificarHabitacion(HabitacionDTO habitacion){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "update habitacion set tipo = '"+habitacion.getTipo()+"', cantidad = '"+habitacion.getCantidad()+"', cama = '"+habitacion.getCama()+"', precio = '"+habitacion.getPrecio()+"', tamaño = '"+habitacion.getTamaño()+"', numPersonas = '"+habitacion.getNumPersonas()+"' where idHabitacion = '"+habitacion.getIdHabitacion()+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void eliminarHabitacion(HabitacionDTO habitacion){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "delete from habitacion where tipo = '"+habitacion.getTipo()+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	
	

}
