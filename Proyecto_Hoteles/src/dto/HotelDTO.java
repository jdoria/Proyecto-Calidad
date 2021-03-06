package dto;

import java.util.ArrayList;


public class HotelDTO {
	private int idHotel;
	private int idAgencia1;
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
		return idAgencia1;
	}
	
	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHabitaciones(int idHabitaciones) {
		this.idAgencia1 = idHabitaciones;
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
	
	public void crearHabitacion(String tipo, int cantidad, String cama, String tama�o, int precio, int numPersonas){
		HabitacionDTO habitacion = new HabitacionDTO(tipo, cantidad, cama, tama�o, precio, numPersonas);
		habitaciones.add(habitacion);
	}
	
	public void crearHabitacion2(String tipo, int cantidad, String cama, String tama�o, int precio, int numPersonas, ArrayList<ServicioDTO> servicios){
		HabitacionDTO habitacion = new HabitacionDTO(tipo, cantidad, cama, tama�o, precio, numPersonas);
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
	
	

}
