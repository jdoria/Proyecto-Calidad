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
			query = "select usuario, contraseña from usuarios;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				Usuario a = new Usuario();
				a.setContraseña("contraseña");
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
	
	public boolean validarUsuarios(String usuario, String contraseña){
		UsuarioDao usuarios = new UsuarioDao();
		boolean validar = true;
		for(int i=0; i<usuarios.GetUsuarios().size();i++){
			if(usuarios.GetUsuarios().get(i).getUsuario().equals(usuario) && 
					usuarios.GetUsuarios().get(i).getContraseña().equals(contraseña)){
				 validar =true;
			}else{
				validar =false;
			}
		}
		return validar;
	}
	
}
