package ProyectoDTO;

public class Administrador {
	
	private String idAdmin;
	private String nombre;
	private String Apellido;
	private float identificación;
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	
	public String getIdAdmin() {
		return idAdmin;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public float getIdentificación() {
		return identificación;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	public void setIdentificación(float identificación) {
		this.identificación = identificación;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setIdAdmin(String idAdmin) {
		this.idAdmin = idAdmin;
	}

}
