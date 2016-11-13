package ProyectoDTO;

public class Vehiculo {
	
	private String idVehiculo;
	private float precio;
	private int modelo;
	
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public String getIdVehiculo() {
		return idVehiculo;
	}
	
	public int getModelo() {
		return modelo;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
	

}
