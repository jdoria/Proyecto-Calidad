package modelo;

import java.util.ArrayList;

public class Habitacion {
	private int idHabitacion;
	private int idServicios;
	private String tipo;
	private int cantidad;
	private String cama;
	private String tama�o;
	private int precio;
	private int numPersonas;
	private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
	
	public Habitacion() {
		// TODO Auto-generated constructor stub
	}
	
	public Habitacion(String tipo, int cantidad, String cama, String tama�o, int precio, int numPersonas) {
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.cama = cama;
		this.tama�o = tama�o;
		this.precio = precio;
		this.numPersonas = numPersonas;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}
	
	public int getIdServicios() {
		return idServicios;
	}
	
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	public void setIdServicios(int idServicios) {
		this.idServicios = idServicios;
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
	
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	
	public String getTama�o() {
		return tama�o;
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
	
	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public void setTama�o(String tama�o) {
		this.tama�o = tama�o;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public void crearServicio(String descripcion){
		Servicio servicio = new Servicio();
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
