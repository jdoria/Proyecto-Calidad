package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.ClienteDTO;

public class ClienteDAO {
	
	private Statement sentencia;
	private String query;
	private ResultSet rs;
	
	public void adicionarCliente(ClienteDTO cliente){
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "insert into cliente(identificacion, nombre, telefono) values('"+cliente.getIdentificacion()+"', '"+cliente.getNombre()+"', '"+cliente.getTelefono()+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public ArrayList<ClienteDTO> GetClientes(){
		ArrayList<ClienteDTO> clientes = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idCliente, identificacion, nombre, telefono from cliente;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				ClienteDTO a = new ClienteDTO();
				a.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
				a.setIdentificacion(Integer.parseInt(rs.getString("identificacion")));
				a.setNombre(rs.getString("nombre"));
				a.setTelefono(rs.getString("telefono"));
				clientes.add(a);
				
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	
	}
	
	public int getIdCliente(){
		int idCliente =0;
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idCliente from agencia.cliente limit 1;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				idCliente = Integer.parseInt(rs.getString("idCliente"));
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idCliente;
	}
	
	public ArrayList<String> getNombreClientes(){
		 ArrayList<String> clientes = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select nombre from agencia.cliente;";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				clientes.add(rs.getString("nombre"));
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	

}
