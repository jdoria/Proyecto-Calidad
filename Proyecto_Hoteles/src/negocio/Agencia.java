package negocio;

import dao.AgenciaDAO;
import dao.HabitacionDAO;
import dao.HotelDAO;
import dto.HabitacionDTO;
import dto.HotelDTO;
import dto.ServicioDTO;

public class Agencia {
	
	private AgenciaDAO agenciaDAO = new AgenciaDAO();
	private HotelDAO hotelDAO = new HotelDAO();
	private HabitacionDAO habitacionDAO = new HabitacionDAO();
	
	public void adicionarHotel(String nombre, String direccion, String telefono, String ciudad, String pais){
		HotelDTO hotel = new HotelDTO();
		hotel.setNombre(nombre);
		hotel.setDireccion(direccion);
		hotel.setTelefono(telefono);
		hotel.setPais(pais);
		hotel.setCiudad(ciudad);
		agenciaDAO.adicionarHotel(hotel);
	}
	
	public void modificarHotel(String nombre, String direccion, String telefono, String ciudad, String pais, int idHotel){
		HotelDTO hotel = new HotelDTO();
		hotel.setNombre(nombre);
		hotel.setDireccion(direccion);
		hotel.setTelefono(telefono);
		hotel.setPais(pais);
		hotel.setCiudad(ciudad);
		hotel.setIdHotel(idHotel);
		agenciaDAO.modificarHotel(hotel);
	}
	
	public void eliminarHotel(String nombre, int idHotel){
		HotelDTO hotel = new HotelDTO();
		hotel.setNombre(nombre);
		hotel.setIdHotel(idHotel);
		agenciaDAO.eliminarHotel(hotel);
	}
	
	public void adicionarHabitacion(int idHotel1, String tipo, int cantidad, String cama, String tamaño, int precio, int numPersonas){
		HabitacionDTO habitacion = new HabitacionDTO();
		habitacion.setIdHotel1(idHotel1);
		habitacion.setTipo(tipo);
		habitacion.setCantidad(cantidad);
		habitacion.setCama(cama);
		habitacion.setTamaño(tamaño);
		habitacion.setPrecio(precio);
		habitacion.setNumPersonas(numPersonas);
		hotelDAO.adicionarHabitacion(habitacion);
	}
	
	public void modificarHabitacion(int idHabitacion, String tipo, int cantidad, String cama, String tamaño, int precio, int numPersonas){
		HabitacionDTO habitacion = new HabitacionDTO();
		habitacion.setIdHabitacion(idHabitacion);
		habitacion.setTipo(tipo);
		habitacion.setCantidad(cantidad);
		habitacion.setCama(cama);
		habitacion.setTamaño(tamaño);
		habitacion.setPrecio(precio);
		habitacion.setNumPersonas(numPersonas);
		hotelDAO.modificarHabitacion(habitacion);
	}
	
	public void eliminarHabitacion(int idHabitacion){
		HabitacionDTO habitacion = new HabitacionDTO();
		habitacion.setIdHabitacion(idHabitacion);
		hotelDAO.eliminarHabitacion(habitacion);
	}
	
	public void adicionarServicio(String descripcion, int idHabitacion1){
		ServicioDTO servicio = new ServicioDTO();
		servicio.setIdHabitacion1(idHabitacion1);
		servicio.setDescripcion(descripcion);
		habitacionDAO.adicionarServicio(servicio);
	}
	
	public void modificarServicio(String descripcion, int idServicio){
		ServicioDTO servicio = new ServicioDTO();
		servicio.setDescripcion(descripcion);
		servicio.setIdServicio(idServicio);
		habitacionDAO.modificarServicio(servicio);
	}
	
	public void eliminarServicio(String descripcion, int idServicio){
		ServicioDTO servicio = new ServicioDTO();
		servicio.setDescripcion(descripcion);
		servicio.setIdServicio(idServicio);
		habitacionDAO.eliminarServicio(servicio);
	}

}
