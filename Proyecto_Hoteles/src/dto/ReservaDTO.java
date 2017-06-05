package dto;

public class ReservaDTO {
	
	private int idReserva;
	private int idCliente;
	private int idHabitacion;
	private String fechaInicio;
	private String fechaFin;
	private int dias;
	private int valorTotal;
	private int estado;
	
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	public int getDias() {
		return dias;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdHabitacion() {
		return idHabitacion;
	}
	
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	public int getIdReserva() {
		return idReserva;
	}
	
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	public int getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

}
