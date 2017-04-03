package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.Usuario;

public class UsuarioDao {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public UsuarioDao() {
		// TODO Auto-generated constructor stub
		this.sentencia = null;
		this.rs = null;
	}
	
	public ArrayList<Usuario> GetUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select usuario, contrase�a from usuarios;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Usuario a = new Usuario();
				a.setContrase�a("contrase�a");
				a.setUsuario("usuario");
				usuarios.add(a);
				
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public boolean validarUsuarios(String usuario, String contrase�a){
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select * from usuarios where usuario = '"+usuario+"' and '"+contrase�a+"';";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Usuario a = new Usuario();
				a.setContrase�a("contrase�a");
				a.setUsuario("usuario");
				usuarios.add(a);
			}
			if (usuarios.size() == 0) {
				return false;
			}
			sentencia.close();
			rs.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
