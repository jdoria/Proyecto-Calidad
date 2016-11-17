package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.Administrador;

public class AdminDao {
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public AdminDao() {
		// TODO Auto-generated constructor stub
		this.sentencia = null;
		this.rs = null;
	}
	
	public Administrador GetAdmin(){
		Administrador admin = new Administrador();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idAdmin, nombre, apellido, identificacion from administrador;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Administrador a = new Administrador();
				a.setApellido("apellido");
				a.setIdAdmin("idAdmin");
				a.setIdentificacion("identifacion");
				
				
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	

}
