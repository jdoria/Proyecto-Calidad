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

import modelo.Agencia;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Servicio;

public class CargaJSON {
	
	private ArrayList<Hotel> hoteles = new ArrayList<>();
	private Hotel hotel = new Hotel();
	private Habitacion habitacion = new Habitacion();
	private Servicio servicio = new Servicio();
	private ArrayList<Servicio> servicios = new ArrayList<>();
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
	
	public Agencia cargar(Agencia agencia) throws FileNotFoundException{
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
					
					
					servicios = new ArrayList<>();
					hotel = new Hotel();
					
					hotel.setNombre(hotelObject.getString("_nombre"));
					hotel.setDireccion(hotelObject.getString("_direccion"));
					hotel.setTelefono(hotelObject.getString("_telefono"));
					habitacion = new Habitacion();
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
						servicio = new Servicio();
						servicio.setDescripcion((jsonValue.toString()));
						servicios.add(servicio);
					}
					hotel.crearHabitacion2(habitacion.getTipo(), habitacion.getCantidad(), habitacion.getCama(), 
							habitacion.getTamaño(), habitacion.getPrecio(), habitacion.getNumPersonas(), servicios);
					
				}
				
				hotel.setCiudad(lugarObject.getString("_ciudad"));
				hotel.setPais(lugarObject.getString("_pais"));
				
				hoteles.add(hotel);
			}
			
		}
		agencia.setHoteles(hoteles);
		return agencia;
	}
	


	public static void main(String[] args) throws IOException {

		CargaJSON c = new CargaJSON();
		Agencia a = new Agencia();
		c.cargar3();
		c.cargar(a);
			
	}	

}
