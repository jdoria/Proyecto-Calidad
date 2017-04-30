package dto;

import java.util.ArrayList;


public class HotelDTO {
	private int idHotel;
	private int idHabitaciones;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;
	private String pais;
	private ArrayList<HabitacionDTO> habitaciones = new ArrayList<HabitacionDTO>();
	
	
	public HotelDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public HotelDTO(String nombre, String direccion, String telefono, String ciudad, String pais) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.pais = pais;
		
	}

	public int getIdHabitaciones() {
		return idHabitaciones;
	}
	
	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHabitaciones(int idHabitaciones) {
		this.idHabitaciones = idHabitaciones;
	}
	
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public ArrayList<HabitacionDTO> getHabitaciones() {
		return habitaciones;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getPais() {
		return pais;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setHabitaciones(ArrayList<HabitacionDTO> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void crearHabitacion(String tipo, int cantidad, String cama, String tamaño, int precio, int numPersonas){
		HabitacionDTO habitacion = new HabitacionDTO(tipo, cantidad, cama, tamaño, precio, numPersonas);
		habitaciones.add(habitacion);
	}
	
	public void crearHabitacion2(String tipo, int cantidad, String cama, String tamaño, int precio, int numPersonas, ArrayList<ServicioDTO> servicios){
		HabitacionDTO habitacion = new HabitacionDTO(tipo, cantidad, cama, tamaño, precio, numPersonas);
		habitacion.setServicios(servicios);
		habitaciones.add(habitacion);
	}

	
	public HabitacionDTO buscarHabitacion(String tipo){//
		HabitacionDTO habitacion = null;
		for (int i = 0; i < habitaciones.size(); i++) {
			if(habitaciones.get(i).getTipo() == tipo){
				habitacion = habitaciones.get(i);
				break;
			}
		}
		return habitacion;
	}
	
	public void modificarHabitacion(String tipo, int cantidad, String cama, String tamaño, int precio, int numPersonas){
		for (int i = 0; i < habitaciones.size(); i++) {
			if(habitaciones.get(i).getTipo().equals(tipo)){
				habitaciones.get(i).setCama(cama);
				habitaciones.get(i).setCantidad(cantidad);
				habitaciones.get(i).setNumPersonas(numPersonas);
				habitaciones.get(i).setPrecio(precio);
				habitaciones.get(i).setTamaño(tamaño);
				break;
			}
		}
	}
	
	public void eliminarHabitacion(String tipo){
		for (int i = 0; i < habitaciones.size(); i++) {
			if(habitaciones.get(i).getTipo() == tipo){
				habitaciones.remove(i);
				break;
			}
			
		}
		
	}
	

}
