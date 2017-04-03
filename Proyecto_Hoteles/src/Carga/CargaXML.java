package Carga;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modelo.Agencia;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Servicio;

public class CargaXML {
	
	private Agencia agencia = new Agencia();
	private Hotel hotel = new Hotel();
	private ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
	private Habitacion habitacion = new Habitacion();
	private Servicio servicio = new Servicio();
	
	public Agencia read() throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File("XML/NH.xml");
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	Document doc = dBuilder.parse(fXmlFile);
    	
    	doc.getDocumentElement().normalize();
    	NodeList nListHotel = doc.getElementsByTagName("hotel");
    	
    	for (int i = 0; i < nListHotel.getLength(); i++) {
    		//System.out.println();
			//System.out.println("-----HOTEL----");
			//System.out.println();
    		Node nNodeHotel = nListHotel.item(i);
    		if (nNodeHotel.getNodeType() == Node.ELEMENT_NODE) {
    			Element eElementHotel = (Element) nNodeHotel;
    			hotel = new Hotel();
    			hotel.setNombre(eElementHotel.getElementsByTagName("nombre").item(0).getTextContent());
    			hotel.setTelefono(eElementHotel.getElementsByTagName("telefono").item(0).getTextContent());
    			hotel.setDireccion(eElementHotel.getElementsByTagName("dirección").item(0).getTextContent());
    			hotel.setCiudad(eElementHotel.getElementsByTagName("ciudad").item(0).getTextContent());
    			hotel.setPais(eElementHotel.getElementsByTagName("pais").item(0).getTextContent());
    			
    			NodeList nListHabitacion = eElementHotel.getElementsByTagName("habitacion");
    			
    			for (int j = 0; j < nListHabitacion.getLength(); j++) {
    				//System.out.println();
        			//System.out.println("-----HABITACIÓN----");
        			//System.out.println();
    				Node nNodeHabitacion = nListHabitacion.item(j);
        			if (nNodeHabitacion.getNodeType() == Node.ELEMENT_NODE) {
        				Element eElementHabitacion = (Element) nNodeHabitacion;
        				habitacion = new Habitacion();
        				habitacion.setTipo(eElementHabitacion.getAttribute("tipo"));
        				habitacion.setCantidad(Integer.parseInt(eElementHabitacion.getAttribute("cantidad")));
        				habitacion.setTamaño(eElementHabitacion.getAttribute("tamano"));
        				habitacion.setCama(eElementHabitacion.getAttribute("cama"));
        				habitacion.setNumPersonas(Integer.parseInt(eElementHabitacion.getAttribute("personas")));
        				habitacion.setPrecio(Integer.parseInt(eElementHabitacion.getElementsByTagName("precio").item(0).getTextContent()));
        				hotel.crearHabitacion(habitacion.getTipo(), habitacion.getCantidad(), habitacion.getCama(), 
        						habitacion.getTamaño(), habitacion.getPrecio(), habitacion.getNumPersonas());
        				
        				NodeList nListServicio = eElementHotel.getElementsByTagName("servicios");
        				//System.out.println();
        				//System.out.println("-----SERVICIOS----");
        				//System.out.println();
        				Node nNodeServicio = nListServicio.item(j);
        				Element eElementServicio = (Element) nNodeServicio;
        				int length = eElementServicio.getElementsByTagName("servicio").getLength();
        				for (int k = 0; k < length; k++) {
        					servicio = new Servicio();
							servicio.setDescripcion(eElementServicio.getElementsByTagName("servicio").item(k).getTextContent());
							hotel.getHabitaciones().get(j).crearServicio(servicio.getDescripcion());
						}
        				
					}
        			
				}
    		}
    		hoteles.add(hotel);
		}
    	agencia.setHoteles(hoteles);
    	
    	return agencia;
	}

	
}
