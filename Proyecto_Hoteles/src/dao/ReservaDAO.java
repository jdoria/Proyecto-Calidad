package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConexionBD.Conexion;
import dto.ReservaDTO;

public class ReservaDAO {

	private Statement sentencia;
	private String query;
	private ResultSet rs;

	public void adicionarReserva(ReservaDTO reserva) {
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "insert into reserva(idCliente, idHabitacion, fechaInicio, fechaFin, dias, valorTotal, estado, fechaReserva) values('"
					+ reserva.getIdCliente() + "', '" + reserva.getIdHabitacion() + "', " + "'"
					+ reserva.getFechaInicio() + "', '" + reserva.getFechaFin() + "', '" + reserva.getDias() + "', '"
					+ reserva.getValorTotal() + "', '" + reserva.getEstado() + "', '" + reserva.getFechaReserva()
					+ "');";
			sentencia.executeUpdate(query);
			sentencia.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<ReservaDTO> GetReservas() {
		ArrayList<ReservaDTO> reservas = new ArrayList<>();
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idReserva, idCliente, idHabitacion, fechaInicio, fechaFin, dias, valorTotal, estado, fechaReserva from reserva;";
			rs = sentencia.executeQuery(query);
			while (rs.next()) {
				ReservaDTO a = new ReservaDTO();
				a.setIdReserva(Integer.parseInt(rs.getString("idReserva")));
				a.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
				a.setIdHabitacion(Integer.parseInt(rs.getString("idHabitacion")));
				a.setFechaInicio(rs.getString("fechaInicio"));
				a.setFechaFin(rs.getString("fechaFin"));
				a.setDias(Integer.parseInt(rs.getString("dias")));
				a.setValorTotal(Integer.parseInt(rs.getString("valorTotal")));
				a.setEstado(Integer.parseInt(rs.getString("estado")));
				a.setFechaReserva(rs.getString("fechaReserva"));
				reservas.add(a);
			}
			sentencia.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservas;

	}

	public void terminarReserva(int idReserva) {

		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "update reserva set estado = '" + 0 + "' where idReserva = '" + idReserva + "'; ";
			sentencia.executeUpdate(query);
			sentencia.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void aumentarCantidad(int cantidad, int idHabitacion){
		cantidad = cantidad + 1;
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "update habitacion set cantidad = '" + cantidad + "' where idHabitacion = '" + idHabitacion + "'; ";
			sentencia.executeUpdate(query);
			sentencia.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int getIdHabitacionByReserva(int idReserva){
		int idHabitacion =0;
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idHabitacion from reserva where idReserva = '"+idReserva+"';";
			rs = sentencia.executeQuery(query);
			while(rs.next()){
				idHabitacion = Integer.parseInt(rs.getString("idHabitacion"));
			}
		sentencia.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idHabitacion;
	}

	/*
	 * public int getHabitacionReservada(String nombre){ int reservada =0;
	 * Conexion conexion = new Conexion(); query = ""; try { sentencia =
	 * conexion.conectar().createStatement(); query =
	 * "select estado from reserva where ;"; rs = sentencia.executeQuery(query);
	 * while(rs.next()){ reservada =
	 * Integer.parseInt(rs.getString("idCliente")); } sentencia.close();
	 * rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return reservada; }
	 */

}
