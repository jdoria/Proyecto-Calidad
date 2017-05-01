package Carga;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import dto.AgenciaDTO;
import dto.HabitacionDTO;
import dto.HotelDTO;
import dto.ServicioDTO;

public class CargaJSON {
	
	private ArrayList<HotelDTO> hoteles = new ArrayList<>();
	private HotelDTO hotel = new HotelDTO();
	private HabitacionDTO habitacion = new HabitacionDTO();
	private ServicioDTO servicio = new ServicioDTO();
	private ArrayList<ServicioDTO> servicios = new ArrayList<>();
	/*private String nombreHotel;
	private String direccionHotel;
	private String telefonoHotel;
	private String ciudadHotel;
	private String paisHotel;
	private String tipoHabitacion;
	private int cantidadHabitacion;
	private String camaHabitacion;
	private String tamañoHabitacion;
	private Float precioHabitacion;
	private int numPersonasHabitacion;
	private String descripcionServicio;*/


	public void cargar3() throws FileNotFoundException{
		FileInputStream fr = new FileInputStream("JSON/Dann2.json");
		JsonReader reader = Json.createReader(fr);
		JsonObject hotelesObject = reader.readObject();
		reader.close();
		
		JsonObject dannObject = hotelesObject.getJsonObject("dann");
		JsonArray lugarArreglo = dannObject.getJsonArray("lugar");
		for (JsonObject lugarObject : lugarArreglo.getValuesAs(JsonObject.class)) {
			JsonArray habitacionArreglo = lugarObject.getJsonArray("habitacion");
			for(JsonObject habitacionObject : habitacionArreglo.getValuesAs(JsonObject.class)){
				JsonArray hotelArreglo = habitacionObject.getJsonArray("hotel");
				for(JsonObject hotelObject : hotelArreglo.getValuesAs(JsonObject.class)){

					System.out.println("Nombre: "+hotelObject.getString("_nombre"));
					System.out.println("Direccion: "+hotelObject.getString("_direccion"));
					System.out.println("Telefono: "+hotelObject.getString("_telefono"));
					

					System.out.println("Ciudad: "+lugarObject.getString("_ciudad"));
					System.out.println("Pais: "+lugarObject.getString("_pais"));
					
					System.out.println("Tipo: "+habitacionObject.getString("_tipo"));
					
					System.out.println("Precio: "+hotelObject.getString("precio"));
					JsonObject caracteristicasObject = hotelObject.getJsonObject("caracteristicas");
					System.out.println("Cantidad: "+caracteristicasObject.getString("cantidad"));
					System.out.println("Tamaño: "+caracteristicasObject.getString("tamano"));
					System.out.println("Cama: "+caracteristicasObject.getString("cama"));
					System.out.println("Personas: "+caracteristicasObject.getString("personas"));
					JsonObject servicioObject = hotelObject.getJsonObject("servicios");
					JsonArray servicioArreglo = servicioObject.getJsonArray("servicio");
					System.out.println("servicios: ");
					for(JsonValue jsonValue: servicioArreglo){
						System.out.println(jsonValue.toString());
						
					}
					System.out.println();
					System.out.println();
					
				}
				
			}
		}
		
	}
	
	public AgenciaDTO cargar(AgenciaDTO agencia) throws FileNotFoundException{
		FileInputStream fr = new FileInputStream("JSON/Dann2.json");
		JsonReader reader = Json.createReader(fr);
		JsonObject hotelesObject = reader.readObject();
		reader.close();
		int bandera = 0;
		hotel = new HotelDTO();
		JsonObject dannObject = hotelesObject.getJsonObject("dann");
		JsonArray lugarArreglo = dannObject.getJsonArray("lugar");
		for (JsonObject lugarObject : lugarArreglo.getValuesAs(JsonObject.class)) {
			JsonArray habitacionArreglo = lugarObject.getJsonArray("habitacion");
			
			for(JsonObject habitacionObject : habitacionArreglo.getValuesAs(JsonObject.class)){
				JsonArray hotelArreglo = habitacionObject.getJsonArray("hotel");
				for(JsonObject hotelObject : hotelArreglo.getValuesAs(JsonObject.class)){
					
					
					servicios = new ArrayList<>();
					
					for (int i = 0; i < hoteles.size(); i++) {
						System.out.println(2);
						if(hoteles.get(i).getNombre().equals(hotelObject.getString("_nombre"))){
							hotel = hoteles.get(i);
							bandera = 1;
						}
						
					}
					if(bandera == 0){
						System.out.println(11);
						hotel = new HotelDTO();
						hotel.setNombre(hotelObject.getString("_nombre"));
						hotel.setDireccion(hotelObject.getString("_direccion"));
						hotel.setTelefono(hotelObject.getString("_telefono"));
						hotel.setCiudad(lugarObject.getString("_ciudad"));
						hotel.setPais(lugarObject.getString("_pais"));
						
					}else{
						bandera = 0;
					}
					
					habitacion = new HabitacionDTO();
					habitacion.setTipo(habitacionObject.getString("_tipo"));
					habitacion.setPrecio(Integer.parseInt(hotelObject.getString("precio")));
					JsonObject caracteristicasObject = hotelObject.getJsonObject("caracteristicas");
					habitacion.setCantidad(Integer.parseInt(caracteristicasObject.getString("cantidad")));
					habitacion.setTamaño(caracteristicasObject.getString("tamano"));
					habitacion.setCama(caracteristicasObject.getString("cama"));
					habitacion.setNumPersonas(Integer.parseInt(caracteristicasObject.getString("personas")));
					JsonObject servicioObject = hotelObject.getJsonObject("servicios");
					JsonArray servicioArreglo = servicioObject.getJsonArray("servicio");
					for(JsonValue jsonValue: servicioArreglo){
						servicio = new ServicioDTO();
						servicio.setDescripcion((jsonValue.toString()));
						servicios.add(servicio);
					}
					hotel.crearHabitacion2(habitacion.getTipo(), habitacion.getCantidad(), habitacion.getCama(), 
							habitacion.getTamaño(), habitacion.getPrecio(), habitacion.getNumPersonas(), servicios);
					
				}
				
				
				hoteles.add(hotel);
			}
			
		}
		agencia.setHoteles(hoteles);
		return agencia;
	}
	

/*
	public static void main(String[] args) throws IOException {

		CargaJSON c = new CargaJSON();
		AgenciaDTO a = new AgenciaDTO();
		c.cargar3();
		c.cargar(a);
			
	}	
*/
}
