package Clases;

public class Linea {
	
	private String marca;
	private String nombre;
	private float codigo;
	private int numPuntos;
	
	public Linea() {
		// TODO Auto-generated constructor stub
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

}
