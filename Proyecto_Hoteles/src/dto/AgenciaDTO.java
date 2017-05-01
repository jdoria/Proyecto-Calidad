package dto;

import java.util.ArrayList;

public class AgenciaDTO {
	
	private int idAgencia;
	private String nombre;
	ArrayList<HotelDTO> hoteles = new ArrayList<HotelDTO>();
	
	
	public AgenciaDTO() {
		// TODO Auto-generated constructor stub
		
	}
	
	public int getIdAgencia() {
		return idAgencia;
	}
	
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	public ArrayList<HotelDTO> getHoteles() {
		return hoteles;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setHoteles(ArrayList<HotelDTO> hoteles) {
		this.hoteles.addAll(hoteles);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void crearHotel(String nombre, String direccion, String telefono, String ciudad, String pais){
		HotelDTO hotel = new HotelDTO(nombre, direccion, telefono, ciudad, pais);
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
	
	public HotelDTO buscarHotel(String nombre){
		HotelDTO hotel = new HotelDTO();
		for (int i = 0; i < hoteles.size(); i++) {
			if(hoteles.get(i).getNombre().equals(nombre)){
				return hoteles.get(i);
			}
		}
		return hotel;
	}

}
