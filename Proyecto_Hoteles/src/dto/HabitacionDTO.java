package dto;

import java.util.ArrayList;

public class HabitacionDTO {
	private int idHabitacion;
	private int idHotel1;
	private String tipo;
	private int cantidad;
	private String cama;
	private String tamaño;
	private int precio;
	private int numPersonas;
	private ArrayList<ServicioDTO> servicios = new ArrayList<ServicioDTO>();
	
	public HabitacionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public HabitacionDTO(String tipo, int cantidad, String cama, String tamaño, int precio, int numPersonas) {
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.cama = cama;
		this.tamaño = tamaño;
		this.precio = precio;
		this.numPersonas = numPersonas;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}
	
	public int getIdHotel1() {
		return idHotel1;
	}
	
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	public void setIdHotel1(int idHotel1) {
		this.idHotel1 = idHotel1;
	}
	
	public String getCama() {
		return cama;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public int getNumPersonas() {
		return numPersonas;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public ArrayList<ServicioDTO> getServicios() {
		return servicios;
	}
	
	public String getTamaño() {
		return tamaño;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setCama(String cama) {
		this.cama = cama;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void setServicios(ArrayList<ServicioDTO> servicios) {
		this.servicios = servicios;
	}
	
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public void crearServicio(String descripcion){
		ServicioDTO servicio = new ServicioDTO();
		servicio.setDescripcion(descripcion);
		servicios.add(servicio);
		
	}
	
	
	public void modificarServicio(String nuevaDescripcion, String descripcion){
		for (int i = 0; i < servicios.size(); i++) {
			if(servicios.get(i).getDescripcion().equals(descripcion)){
				servicios.get(i).setDescripcion(nuevaDescripcion);
				break;
			}
			
		}
	}
	
	public void eliminarServicio(String descripcion){
		for (int i = 0; i < servicios.size(); i++) {
			if(servicios.get(i).getDescripcion().equals(descripcion)){
				servicios.remove(i);
				break;
			}
			
		}
		
	}
	
}
