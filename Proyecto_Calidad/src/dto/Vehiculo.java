package dto;

public class Vehiculo {
	
	private String idVehiculo;
	private String idLinea1;
	private double precio;
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
	
	public double getPrecio() {
		return precio;
	}
	
	public String getIdLinea1() {
		return idLinea1;
	}
	
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
	public void setIdLinea1(String idLinea1) {
		this.idLinea1 = idLinea1;
	}

}
