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
				a.setIdHotel(Integer.parseInt("idHotel"));
				a.setNombre("nombre");
				a.setDireccion("direccion");
				a.setTelefono("telefono");
				a.setCiudad("ciudad");
				a.setPais("pais");
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
			sentencia = conexion.conectar().createStatement();
			query = "delete from hotel where nombre = '"+hotel.getNombre()+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	


}
