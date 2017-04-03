package dto;

public class Vendedor {
	
	private String idVendedor;
	private String idUsuario1;
	private String nombre;
	private String apellido;
	private double identificacion;
	private String calificacion;
	
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
	
	public String getIdUsuario1() {
		return idUsuario1;
	}
	
	public String getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	public void setIdUsuario1(String idUsuario1) {
		this.idUsuario1 = idUsuario1;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setIdentificacion(double identificacion) {
		this.identificacion = identificacion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	

}
