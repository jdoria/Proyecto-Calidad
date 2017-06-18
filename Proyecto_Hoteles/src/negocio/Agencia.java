package negocio;

import java.util.ArrayList;

import dao.AgenciaDAO;
import dao.ClienteDAO;
import dao.HabitacionDAO;
import dao.HotelDAO;
import dao.ReservaDAO;
import dto.ClienteDTO;
import dto.HabitacionDTO;
import dto.HotelDTO;
import dto.ReservaDTO;
import dto.ServicioDTO;

public class Agencia {
	
	private AgenciaDAO agenciaDAO = new AgenciaDAO();
	private HotelDAO hotelDAO = new HotelDAO();
	private HabitacionDAO habitacionDAO = new HabitacionDAO();
	private ClienteDAO clienteDAO = new ClienteDAO();
	private ReservaDAO reservaDAO = new ReservaDAO();
	
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
	
	public boolean rutas(ArrayList<String> rutas, String ruta){
		for (int i = 0; i < rutas.size(); i++) {
			if(rutas.get(i).equals(ruta)){
				return false;
			}
		}
		return true;
	}
	
	public void adicionarCliente(int identificacion, String nombre, String telefono){
		ClienteDTO cliente = new ClienteDTO();
		cliente.setIdentificacion(identificacion);
		cliente.setNombre(nombre);
		cliente.setTelefono(telefono);
		clienteDAO.adicionarCliente(cliente);
	}
	
	public void adicionarReserva(int idCliente, int idHabitacion, String fechaInicio, String fechaFin, long dias, int valorTotal, String fechaReserva){
		ReservaDTO reserva = new ReservaDTO();
		int diasInt = (int) dias;
		int estado = 1;
		reserva.setIdCliente(idCliente);
		reserva.setIdHabitacion(idHabitacion);
		reserva.setFechaFin(fechaFin);
		reserva.setFechaInicio(fechaInicio);
		reserva.setDias(diasInt);
		reserva.setValorTotal(valorTotal);
		reserva.setEstado(estado);
		reserva.setFechaReserva(fechaReserva);
		reservaDAO.adicionarReserva(reserva);
	}
	
	public int getIdCliente(){
		int idCliente = 0;
		idCliente = clienteDAO.getIdCliente();
		return idCliente;
	}
	
	public int getCantidadHabitaciones(int idHabitacion){
		return hotelDAO.getCantidadHabitaciones(idHabitacion);
	}
	
	public void descontarHabitacion(int idHabitacion){
		int cantidad = getCantidadHabitaciones(idHabitacion);
		hotelDAO.descontarHabitacion(idHabitacion, cantidad);
	}
	
	public ArrayList<ReservaDTO> getReservas(){
		ArrayList<ReservaDTO> reservas = new ArrayList<>();
		reservas = reservaDAO.GetReservas();
		return reservas;
	}
	
	public ArrayList<String> getClientes(){
		ArrayList<String> clientes = new ArrayList<>();
		clientes = clienteDAO.getNombreClientes();
		return clientes;
	}
	
	public void terminarReserva(int idReserva, int idHabitacion){
		reservaDAO.terminarReserva(idReserva);
		int cantidad = getCantidadHabitaciones(idHabitacion);
		reservaDAO.aumentarCantidad(cantidad, idHabitacion);
	}
	
	public int getIdHabitacionByReserva(int idReserva){
		return reservaDAO.getIdHabitacionByReserva(idReserva);
	}
	
	
}	

