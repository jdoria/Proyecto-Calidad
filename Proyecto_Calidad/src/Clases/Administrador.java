package Clases;

public class Administrador {
	
	private String nombre;
	private String Apellido;
	private float identificaci�n;
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public float getIdentificaci�n() {
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

}
