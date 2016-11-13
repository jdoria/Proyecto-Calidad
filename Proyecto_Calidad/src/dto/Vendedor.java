package dto;

public class Vendedor {
	
	private String idVendedor;
	private String nombre;
	private String apellido;
	private double identificacion;
	
	
	public Vendedor() {
		// TODO Auto-generated constructor stub
	}
	
	public String getIdVendedor() {
		return idVendedor;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public double getIdentificacion() {
		return identificacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setIdentificacion(float identificacion) {
		this.identificacion = identificacion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	

}
