package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.ServicioDTO;

public class HabitacionDAO {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	
	public ArrayList<ServicioDTO> GetServicios(int idHabitacion){
		ArrayList<ServicioDTO> servicios = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idServicio, descripcion from servicio where idHabitacion1 = '"+idHabitacion+"';";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				ServicioDTO a = new ServicioDTO();
				a.setIdServicio(Integer.parseInt(rs.getString("idServicio")));
				a.setDescripcion(rs.getString("descripcion"));
				servicios.add(a);
				
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servicios;
	}
	
	public void adicionarServicio(ServicioDTO servicio){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "insert into servicio(idHabitacion1, descripcion) values('"+servicio.getIdHabitacion1()+"', '"+servicio.getDescripcion()+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarServicio(ServicioDTO servicio){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "update servicio set descripcion = '"+servicio.getDescripcion()+"' where idServicio = '"+servicio.getIdServicio()+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarServicio(ServicioDTO servicio){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "delete from servicio where idServicio = '"+servicio.getIdServicio()+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
