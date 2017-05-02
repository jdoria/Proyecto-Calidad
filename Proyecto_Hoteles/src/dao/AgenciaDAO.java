package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.HotelDTO;

public class AgenciaDAO {

	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public ArrayList<HotelDTO> GetHoteles(){
		ArrayList<HotelDTO> hoteles = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idHotel, nombre, direccion, telefono, ciudad, pais from hotel;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				HotelDTO a = new HotelDTO();
				a.setIdHotel(Integer.parseInt(rs.getString("idHotel")));
				a.setNombre(rs.getString("nombre"));
				a.setDireccion(rs.getString("direccion"));
				a.setTelefono(rs.getString("telefono"));
				a.setCiudad(rs.getString("ciudad"));
				a.setPais(rs.getString("pais"));
				hoteles.add(a);
				
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hoteles;
	}
	
	public void adicionarHotel(HotelDTO hotel){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "insert into hotel(nombre, direccion, telefono, ciudad, pais) values('"+hotel.getNombre()+"', '"+hotel.getDireccion()+"', '"+hotel.getTelefono()+"', '"+hotel.getCiudad()+"', '"+hotel.getPais()+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void modificarHotel(HotelDTO hotel){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "update hotel set nombre = '"+hotel.getNombre()+"', direccion = '"+hotel.getDireccion()+"', telefono = '"+hotel.getTelefono()+"', ciudad = '"+hotel.getCiudad()+"', pais = '"+hotel.getPais()+"' where idHotel = '"+hotel.getIdHotel()+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void eliminarHotel(HotelDTO hotel){
		Conexion conexion = new Conexion();
		query = "";
		try {
			ArrayList<Integer> lista = new ArrayList<>();
			lista = getHabitacionById(hotel.getIdHotel());
			for (int i = 0; i <lista.size(); i++) {
				eliminarServiciosHabitacion(lista.get(i));
			}			
			eliminarHabitaciones(hotel.getIdHotel());
			sentencia = conexion.conectar().createStatement();
			query = "delete from hotel where nombre = '"+hotel.getNombre()+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private void eliminarHabitaciones(int idHotel){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "delete from habitacion where idHotel1 = '"+idHotel+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private ArrayList<Integer> getHabitacionById(int idHotel) {
		ArrayList<Integer> lista = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idHabitacion from habitacion where idHotel1 = '"+idHotel+"'";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				lista.add(Integer.parseInt(rs.getString("idHabitacion")));
			}
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	private void eliminarServiciosHabitacion(int idHabitacion) {
		// SENTENCIA
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "delete from servicio where idHabitacion1 = '"+idHabitacion+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	


}
