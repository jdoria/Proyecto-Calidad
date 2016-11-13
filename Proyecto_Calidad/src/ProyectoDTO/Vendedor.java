package ProyectoDTO;

public class Vendedor {
	
	private String nombre;
	private String apellido;
	private float identificacion;
	
	
	public Vendedor() {
		// TODO Auto-generated constructor stub
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public float getIdentificacion() {
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
	
	

}
