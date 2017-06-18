package Carga;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConexionBD.Conexion;
import dto.AgenciaDTO;
import dto.HabitacionDTO;
import dto.HotelDTO;
import dto.ServicioDTO;

public class CargaBD {

	private Statement sentencia;
	private String query;
	private ResultSet rs;

	/*public void cargar(AgenciaDTO agencia) {
		for (int i = 0; i < agencia.getHoteles().size(); i++) {
			HotelDTO hotel = new HotelDTO();
			hotel = agencia.getHoteles().get(i);
			Conexion conexion = new Conexion();
			query = "";
			try {
				sentencia = conexion.conectar().createStatement();
				query = "insert into hotel(nombre, direccion, telefono, ciudad, pais) values('" + hotel.getNombre()
						+ "', '" + hotel.getDireccion() + "', '" + hotel.getTelefono() + "', '" + hotel.getCiudad()
						+ "', '" + hotel.getPais() + "');";
				sentencia.executeUpdate(query);
				query = "select idHotel from hotel where nombre = '" + hotel.getNombre() + "'";
				rs = sentencia.executeQuery(query);
				rs.next();
				hotel.setIdHotel(Integer.parseInt(rs.getString("idHotel")));
				sentencia.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < agencia.getHoteles().get(i).getHabitaciones().size(); j++) {
				HabitacionDTO habitacion = new HabitacionDTO();
				habitacion = agencia.getHoteles().get(i).getHabitaciones().get(j);
				habitacion.setIdHotel1(hotel.getIdHotel());
				try {
					sentencia = conexion.conectar().createStatement();
					query = "insert into habitacion(idHotel1, tipo, cantidad, cama, precio, tamaño, numPersonas) values('"
							+ habitacion.getIdHotel1() + "', '" + habitacion.getTipo() + "', '"
							+ habitacion.getCantidad() + "', '" + habitacion.getCama() + "', '" + habitacion.getPrecio()
							+ "', '" + habitacion.getTamaño() + "', '" + habitacion.getNumPersonas() + "');";
					sentencia.executeUpdate(query);
					query = "select idHabitacion from habitacion where tipo = '" + habitacion.getTipo() + "'";
					rs = sentencia.executeQuery(query);
					rs.next();
					habitacion.setIdHabitacion(Integer.parseInt(rs.getString("idHabitacion")));
					sentencia.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				for (int k = 0; k < agencia.getHoteles().get(i).getHabitaciones().get(j).getServicios().size(); k++) {
					ServicioDTO servicio = new ServicioDTO();
					servicio = agencia.getHoteles().get(i).getHabitaciones().get(j).getServicios().get(k);
					servicio.setIdHabitacion1(habitacion.getIdHabitacion());
					try {
						sentencia = conexion.conectar().createStatement();
						query = "insert into servicio(idHabitacion1, descripcion) values('"
								+ servicio.getIdHabitacion1() + "', '" + servicio.getDescripcion() + "')";
						sentencia.executeUpdate(query);
						sentencia.close();

					} catch (SQLException e) {
						// TODO: handle exc eption
						e.printStackTrace();
					}
				}

			}

		}

	}*/

	public void cargar2(AgenciaDTO agencia) {
		int idHotel = 0;
		for (int i = 0; i < agencia.getHoteles().size(); i++) {
			HotelDTO hotel = new HotelDTO();
			hotel = agencia.getHoteles().get(i);
			Conexion conexion = new Conexion();
			query = "";
			try {
				sentencia = conexion.conectar().createStatement();
				query = "insert into hotel(nombre, direccion, telefono, ciudad, pais) values('" + hotel.getNombre()
						+ "', '" + hotel.getDireccion() + "', '" + hotel.getTelefono() + "', '" + hotel.getCiudad()
						+ "', '" + hotel.getPais() + "');";
				sentencia.executeUpdate(query);
				idHotel = getIdHotel(hotel.getNombre());
				hotel.setIdHotel(idHotel);
				sentencia.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < agencia.getHoteles().get(i).getHabitaciones().size(); j++) {
				int idHabitacion = 0;
				HabitacionDTO habitacion = new HabitacionDTO();
				habitacion = agencia.getHoteles().get(i).getHabitaciones().get(j);
				habitacion.setIdHotel1(hotel.getIdHotel());
				try {
					sentencia = conexion.conectar().createStatement();
					query = "insert into habitacion(idHotel1, tipo, cantidad, cama, precio, tamaño, numPersonas) values('"
							+ habitacion.getIdHotel1() + "', '" + habitacion.getTipo() + "', '"
							+ habitacion.getCantidad() + "', '" + habitacion.getCama() + "', '" + habitacion.getPrecio()
							+ "', '" + habitacion.getTamaño() + "', '" + habitacion.getNumPersonas() + "');";
					sentencia.executeUpdate(query);
					idHabitacion = getIdHabitacion(habitacion.getTipo(), habitacion.getIdHotel1());
					habitacion.setIdHabitacion(idHabitacion);
					sentencia.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				for (int k = 0; k < agencia.getHoteles().get(i).getHabitaciones().get(j).getServicios().size(); k++) {
					ServicioDTO servicio = new ServicioDTO();
					servicio = agencia.getHoteles().get(i).getHabitaciones().get(j).getServicios().get(k);
					servicio.setIdHabitacion1(habitacion.getIdHabitacion());
					try {
						sentencia = conexion.conectar().createStatement();
						query = "insert into servicio(idHabitacion1, descripcion) values('"
								+ servicio.getIdHabitacion1() + "', '" + servicio.getDescripcion() + "')";
						sentencia.executeUpdate(query);
						sentencia.close();

					} catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}

			}

		}

	}

	private int getIdHotel(String nombre) {
		int idHotel = 0;
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idHotel from hotel where nombre = '" + nombre + "'";
			rs = sentencia.executeQuery(query);
			rs.next();
			idHotel = Integer.parseInt(rs.getString("idHotel"));
			sentencia.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idHotel;
	}

	private int getIdHabitacion(String tipo, int idHotel) {
		int idHabitacion = 0;
		Conexion conexion = new Conexion();
		query = "";
		try {
			sentencia = conexion.conectar().createStatement();
			query = "select idHabitacion from habitacion where tipo = '" + tipo + "' and idHotel1 = '"+idHotel+"'";
			rs = sentencia.executeQuery(query);
			rs.next();
			idHabitacion = Integer.parseInt(rs.getString("idHabitacion"));
			sentencia.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idHabitacion;

	}

}
