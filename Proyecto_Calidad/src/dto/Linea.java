package dto;

public class Linea {
	
	private String idLinea;
	private String idVendedor1;
	private String marca;
	private String nombre;
	private float codigo;
	private int numPuntos;
	private int calificacion;
	
	public Linea() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	
	public String getIdLinea() {
		return idLinea;
	}
	
	public float getCodigo() {
		return codigo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumPuntos() {
		return numPuntos;
	}
	
	public String getIdVendedor1() {
		return idVendedor1;
	}
	
	public void setCodigo(float codigo) {
		this.codigo = codigo;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumPuntos(int numPuntos) {
		this.numPuntos = numPuntos;
	}
	
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public void setIdLinea(String idLinea) {
		this.idLinea = idLinea;
	}
	
	public void setIdVendedor1(String idVendedor1) {
		this.idVendedor1 = idVendedor1;
	}
	
	

}
