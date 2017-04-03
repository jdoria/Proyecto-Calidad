package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.Linea;

public class LineaDao {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public LineaDao() {
		// TODO Auto-generated constructor stub
		this.sentencia = null;
		this.rs = null;
	}
	
	
	public ArrayList<Linea> GetLineas(){
		ArrayList<Linea> lineas = new ArrayList<Linea>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idLinea, marca, nombre, codigo, NumPuntos, calificacion from linea;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Linea a = new Linea();
				a.setIdLinea(rs.getString("idLinea"));
				a.setMarca(rs.getString("marca"));
				a.setNombre(rs.getString("nombre"));
				a.setCodigo(rs.getFloat("codigo"));
				a.setNumPuntos(rs.getInt("NumPuntos"));
				a.setCalificacion(rs.getInt("calificacion"));
				lineas.add(a);
				
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineas;
	}
	
	public ArrayList<Linea> getLineaVendedor(String idVendedor){
		ArrayList<Linea> lineas = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select nombre, numPuntos, calificacion from linea where idVendedor1 = '"+idVendedor+"'";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Linea a = new Linea();
				a.setNombre(rs.getString("nombre"));
				a.setNumPuntos(rs.getInt("numPuntos"));
				a.setCalificacion(rs.getInt("calificacion"));
				lineas.add(a);
				
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return lineas;
	}
	
	public double evaluarVendedores(String idVendedor){
		double sumatoria = 0;
		int suma_puntos_todas = 0;
		LineaDao lineasVendedores = new LineaDao();
		ArrayList<Linea> lineas = lineasVendedores.getLineaVendedor(idVendedor);
		
		for(int i=0; i<lineas.size();i++){
			/**
			 * promedio_vendedor = ((calificacion_linea1*puntos_linea1)+ 
				(calificacion_linea2*puntos_linea2) + (calificacion_linea3*puntos_linea3) + 
				(calificacion_linea4*puntos_linea5) + (calificacion_linea1*puntos_linea5))/suma_puntos_todas 
				las_lineas
			 */
			System.out.println(lineas.get(i).getCalificacion());
			System.out.println(lineas.get(i).getNumPuntos());
			System.out.println(lineas.get(i).getNumPuntos());
			sumatoria += lineas.get(i).getCalificacion() * lineas.get(i).getNumPuntos();
			suma_puntos_todas += lineas.get(i).getNumPuntos();
		}
		System.out.println(sumatoria);
		System.out.println(suma_puntos_todas);
		return sumatoria / suma_puntos_todas;
	}
	
	public void AsignarVendedor(String idVendedor, String nombreLinea){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "UPDATE linea SET idVendedor1 = '"+idVendedor+"' WHERE Nombre = '"+nombreLinea+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void asignarPuntos(int puntos, String nombreLinea){
		//Linea linea = new Linea();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "UPDATE linea SET NumPuntos = '"+puntos+"' WHERE Nombre = '"+nombreLinea+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	

	public void asignarCalificacion(int calificacion, String nombreLinea){
		//Linea linea = new Linea();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "UPDATE linea SET calificacion = '"+calificacion+"' WHERE Nombre = '"+nombreLinea+"'";
			sentencia.executeUpdate(query);
			sentencia.close();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	

}
