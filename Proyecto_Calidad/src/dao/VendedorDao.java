package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.Vendedor;

public class VendedorDao {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public VendedorDao() {
		// TODO Auto-generated constructor stub
		this.sentencia = null;
		this.rs = null;
	}
	
	
	public ArrayList<Vendedor> GetVendedores(){
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idVendedor, nombre, apellido, identificacion from vendedor;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Vendedor a = new Vendedor();
				a.setIdVendedor(rs.getString("idVendedor"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setIdentificacion(rs.getFloat("identifacion"));
				vendedores.add(a);
				
			}
			sentencia.close();																																																																																																																																																																																																																																																																																						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendedores;
	}

}
