package dto;

public class Administrador {
	
	private String idAdmin;
	private String nombre;
	private String Apellido;
	private double identificaci�n;
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	
	public String getIdAdmin() {
		return idAdmin;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public double getIdentificaci�n() {
		return identificaci�n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	public void setIdentificaci�n(float identificaci�n) {
		this.identificaci�n = identificaci�n;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setIdAdmin(String idAdmin) {
		this.idAdmin = idAdmin;
	}

}