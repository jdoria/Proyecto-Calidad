package Principal;

import dao.AgenciaDAO;
import dao.HabitacionDAO;
import dao.HotelDAO;
import dto.AgenciaDTO;
import dto.HabitacionDTO;
import dto.HotelDTO;
import dto.ServicioDTO;

public class Principal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HabitacionDAO ha = new HabitacionDAO();
		HotelDAO ho = new HotelDAO();
		AgenciaDAO a = new AgenciaDAO();
		HabitacionDTO h = new HabitacionDTO();
		HotelDTO h2 = new HotelDTO();
		AgenciaDTO a2 = new AgenciaDTO();
		/*h2.setNombre("Hotel");
		h2.setDireccion("avenidad");
		h2.setCiudad("bog");
		h2.setTelefono("123123");
		h2.setPais("col");
		h2.setIdHotel(1);
		a.adicionarHotel(h2);
		//a.modificarHotel(h2);
		//a.eliminarHotel(h2);*/
		h.setTipo("suite");
		h.setCama("queen");
		h.setCantidad(22);
		h.setPrecio(1231);
		h.setNumPersonas(2);
		h.setTamaño("da33sd3123");
		h.setIdHotel1(4);
		//ho.adicionarHabitacion(h);
		ho.modificarHabitacion(h);
		
	}

}
