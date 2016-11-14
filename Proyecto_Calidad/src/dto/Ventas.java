package dto;

public class Ventas {
	
	private String idVentas;
	private String idVendedor1;
	private String fecha;
	private double precioTotal;
	
	
	public Ventas() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public String getIdVentas() {
		return idVentas;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public String getIdVendedor1() {
		return idVendedor1;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setIdVentas(String idVentas) {
		this.idVentas = idVentas;
	}
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public void setIdVendedor1(String idVendedor1) {
		this.idVendedor1 = idVendedor1;
	}
	
	

}
