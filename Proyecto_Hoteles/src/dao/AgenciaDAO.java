package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import modelo.Hotel;

public class AgenciaDAO {

	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public ArrayList<Hotel> GetHoteles(){
		ArrayList<Hotel> hoteles = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idHotel, nombre, direccion, telefono, ciudad, pais from hotel;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Hotel a = new Hotel();
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
	
	public void adicionarHotel(String nombre, String direccion, String telefono, String ciudad, String pais){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "insert into hotel(nombre, direccion, telefono, ciudad, pais) values('"+nombre+"', '"+direccion+"', '"+telefono+"', '"+ciudad+"', '"+pais+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void modificarHotel(int idHotel, String nombre, String direccion, String telefono, String ciudad, String pais){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "update hotel set nombre = '"+nombre+"', direccion = '"+direccion+"', telefono = '"+telefono+"', ciudad = '"+ciudad+"', pais = '"+pais+"' where idHotel = '"+idHotel+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void eliminarHotel(String nombre){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "delete from hotel where nombre = '"+nombre+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	


}
