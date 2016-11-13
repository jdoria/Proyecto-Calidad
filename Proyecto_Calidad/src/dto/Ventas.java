package dto;

public class Ventas {
	
	private String idVentas;
	private String fecha;
	private float precioTotal;
	
	
	public Ventas() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public String getIdVentas() {
		return idVentas;
	}
	
	public float getPrecioTotal() {
		return precioTotal;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setIdVentas(String idVentas) {
		this.idVentas = idVentas;
	}
	
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	
	

}
