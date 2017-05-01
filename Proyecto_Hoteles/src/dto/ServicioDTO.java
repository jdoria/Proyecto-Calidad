package dto;

public class ServicioDTO {
	private int idServicio;
	private int idHabitacion1;
	private String descripcion;
	
	public ServicioDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdHabitacion1() {
		return idHabitacion1;
	}
	
	public void setIdHabitacion1(int idHabitacion1) {
		this.idHabitacion1 = idHabitacion1;
	}
	
	public int getIdServicio() {
		return idServicio;
	}
	
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	 
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
