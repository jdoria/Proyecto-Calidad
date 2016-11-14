package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.Ventas;

public class VentasDao {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	
	public VentasDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Ventas> GetVentas(){
		ArrayList<Ventas> ventas = new ArrayList<Ventas>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idVentas, fecha, precioTotal from ventas;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Ventas a = new Ventas();
				a.setIdVentas(rs.getString("idVentas"));
				a.setFecha(rs.getString("fecha"));
				a.setPrecioTotal(rs.getDouble("precioTotal"));
				ventas.add(a);
				
			}	
			sentencia.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ventas;

	}
	
	public void crearVentas(Ventas venta){
		Conexion conexion = new Conexion();
		String query = "";
		try{
			sentencia = conexion.conectar().createStatement();
			query = "INSERT INTO VENTAS (idVentas, idVendedor1, fecha, precioTotal) VALUES ('"+venta.getIdVentas()+"', '"+venta.getIdVendedor1()+"', '"+venta.getFecha()+"', '"+venta.getPrecioTotal()+"')";
			sentencia.executeUpdate(query);
			sentencia.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
