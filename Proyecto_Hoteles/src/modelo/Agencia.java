package modelo;

import java.util.ArrayList;

public class Agencia {
	
	private int idAgencia;
	private String nombre;
	private int idHoteles;
	ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
	
	
	public Agencia() {
		// TODO Auto-generated constructor stub
		
	}
	
	public int getIdAgencia() {
		return idAgencia;
	}
	
	public int getIdHoteles() {
		return idHoteles;
	}
	
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	public void setIdHoteles(int idHoteles) {
		this.idHoteles = idHoteles;
	}
	
	public ArrayList<Hotel> getHoteles() {
		return hoteles;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setHoteles(ArrayList<Hotel> hoteles) {
		this.hoteles.addAll(hoteles);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void crearHotel(String nombre, String direccion, String telefono, String ciudad, String pais){
		Hotel hotel = new Hotel(nombre, direccion, telefono, ciudad, pais);
		hoteles.add(hotel);
		
	}
	
	public void modificarHotel(String nombre, String direccion, String telefono, String ciudad, String pais){
		for (int i = 0; i < hoteles.size(); i++) {
			if(hoteles.get(i).getNombre().equals(nombre)){
				hoteles.get(i).setCiudad(ciudad);
				hoteles.get(i).setDireccion(direccion);
				hoteles.get(i).setTelefono(telefono);
				hoteles.get(i).setPais(pais);
				break;
			}
			
		}
		
		
	}
	
	public void eliminarHotel(String nombre){
		for (int i = 0; i < hoteles.size(); i++) {
			if(hoteles.get(i).getNombre().equals(nombre)){
				hoteles.remove(i);
				break;
			}
			
		}
		
	}

}
