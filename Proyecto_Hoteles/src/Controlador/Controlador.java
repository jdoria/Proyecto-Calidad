package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Carga.CargaJSON;
import Carga.CargaXML;
import Interfaz.*;
import Interfaz.Agencia.CrearHotel;
import Interfaz.Agencia.EliminarHotel;
import Interfaz.Agencia.ModificarHotel;
import Interfaz.Agencia.VerHotel;
import Interfaz.Habitacion.CrearServicio;
import Interfaz.Habitacion.EliminarServicio;
import Interfaz.Habitacion.ModificarServicio;
import Interfaz.Habitacion.MostrarServicio;
import Interfaz.Habitacion.VerServicios;
import Interfaz.Hotel.CrearHabitacion;
import Interfaz.Hotel.EliminarHabitacion;
import Interfaz.Hotel.ModificarHabitacion;
import Interfaz.Hotel.VerHabitacion;
import modelo.Agencia;
import modelo.Habitacion;
import modelo.Hotel;

@SuppressWarnings("unused")
public class Controlador {
	private String nombreHotel;
	private String nombreHabitacion;
	private Pantalla_Inicio principal;
	private Agencia agencia= new Agencia();
	private Hotel hotel = new Hotel();
	private MenuAgencia menuAgencia;
	private MenuHoteles menuHotel;
	private CrearHotel crearHotel;
	private CrearHabitacion crearHabitacion;
	private VerHotel verHotel;
	private ModificarHotel modificarHotel;
	private EliminarHotel eliminarHotel;
	private VerHabitacion verHabitacion;
	private ModificarHabitacion modificarHabitacion;
	private EliminarHabitacion eliminarHabitacion;
	private CrearServicio crearServicio;
	private EliminarServicio eliminarServicio;
	private ModificarServicio modificarServicio;
	private MenuHabitaciones menuHabitacion;
	private VerServicios verServicios;
	private MostrarServicio mostrarServicio;
	private Habitacion habitacion;
	private CargaXML cargaxml = new CargaXML();
	private CargaJSON cargaJson = new CargaJSON();
	private MenuUsuario menuUsuario;
	private VistaCliente vistaCliente;
	
	public Controlador(Pantalla_Inicio interfaz) {
		// TODO Auto-generated constructor stub
		this.principal = interfaz;
		this.principal.buttonContinue(new listener());
	}
	
	class listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("continuarMenu")) {
				menuUsuario = new MenuUsuario();
				menuUsuario.buttonContAdmin(new listenerMenuAgencia());
				menuUsuario.buttonContCliente(new listenerCliente());
			}
			
		}
	}
	
	public class listenerMenuAgencia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			menuAgencia = new MenuAgencia();
			menuAgencia.buttonCrearHotel(new listenerEventosAgencia());
			menuAgencia.buttonMostrarHoteles(new listenerEventosAgencia());
			menuAgencia.buttonModificarHoteles(new listenerEventosAgencia());
			menuAgencia.buttonEliminarHotel(new listenerEventosAgencia());
			menuAgencia.buttonCargarXml(new listenerEventosAgencia());
			menuAgencia.buttonCargarJson(new listenerEventosAgencia());
		}
	}
	
	public class listenerCliente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			verHotel = new VerHotel(agencia);
			verHotel.buttonVer(new listenerVerHotelCliente());
		}
	}
	
	public class listenerVerHotelCliente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < agencia.getHoteles().size(); i++) {
				if(agencia.getHoteles().get(i).getNombre()==verHotel.getNombreHotel()){
					hotel = agencia.getHoteles().get(i);
				}
				
			}
			vistaCliente = new VistaCliente(hotel);
		}
	}
	
	public class listenerEventosAgencia implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("crearHotel")){
				crearHotel = new CrearHotel();
				crearHotel.buttonCrear(new listenerCrearHotel());
			}else if(e.getActionCommand().equals("mostrarHoteles")){
				verHotel = new VerHotel(agencia);
				verHotel.buttonVer(new listenerMostrarHotel());
			}else if(e.getActionCommand().equals("modificarHoteles")){
				verHotel = new VerHotel(agencia);
				verHotel.buttonVer(new listenerModificarHotel());
			}else if(e.getActionCommand().equals("eliminarHotel")){
				eliminarHotel = new EliminarHotel(agencia);
				eliminarHotel.buttonVer(new listenerEliminarHotel());
				
			}else if(e.getActionCommand().equals("cargar")){
				try {
					//agencia = new Agencia();
					agencia = cargaxml.read(); //TODO 
					JOptionPane.showMessageDialog(null, "CARGADO CORRECTAMENTE", "CARGA XML", JOptionPane.INFORMATION_MESSAGE);
				} catch (ParserConfigurationException | SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getActionCommand().equals("cargarJson")){
				try {
					agencia = cargaJson.cargar3(agencia);
					JOptionPane.showMessageDialog(null, "CARGADO CORRECTAMENTE", "CARGA JSON", JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	
	public class listenerCrearHotel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agencia.crearHotel(crearHotel.getNombre(), crearHotel.getDireccion(), crearHotel.getTelefono(), 
					 crearHotel.getCiudad(), crearHotel.getPais());
			JOptionPane.showMessageDialog(null, "HOTEL CREADO CORRECTAMENTE", "CREAR HOTEL", JOptionPane.INFORMATION_MESSAGE);
			
			
		}
	}
	
	public class listenerMostrarHotel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			menuHotel = new MenuHoteles();
			nombreHotel = verHotel.getNombreHotel();
			menuHotel.setLabel(nombreHotel);
			menuHotel.buttonCrearHabitacion(new listenerEventosHotel());
			menuHotel.buttonEliminarHabitacion(new listenerEventosHotel());
			menuHotel.buttonModificarHabitacion(new listenerEventosHotel());
			menuHotel.buttonMostrarHabitaciones(new listenerEventosHotel());
			
		}
	}
	
	public class listenerModificarHotel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			modificarHotel = new ModificarHotel(verHotel.getAgencia(), verHotel.getNombreHotel());
			modificarHotel.buttonModificar(new listenerModificacion());
			
		}
	}
	
	public class listenerModificacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agencia.modificarHotel(modificarHotel.getNombre(), modificarHotel.getDireccion(),
					modificarHotel.getTelefono(), modificarHotel.getCiudad(), modificarHotel.getPais());
			JOptionPane.showMessageDialog(null, "HOTEL MODIFICADO CORRECTAMENTE", "MODIFICAR HOTEL", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public class listenerEliminarHotel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agencia.eliminarHotel(eliminarHotel.getHotel());
			JOptionPane.showMessageDialog(null, "HOTEL ELIMINADO CORRECTAMENTE", "ELIMINAR HOTEL", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public class listenerEventosHotel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("crearHabitacion")){
				crearHabitacion = new CrearHabitacion();
				crearHabitacion.buttonCrear(new listenerCrearHabitacion());
			}else if(e.getActionCommand().equals("mostrarHabitaciones")){
				for(int i= 0; i<agencia.getHoteles().size(); i++){
					if(verHotel.getNombreHotel().equals(agencia.getHoteles().get(i).getNombre())){
						hotel = agencia.getHoteles().get(i);
					}
				}
				verHabitacion = new VerHabitacion(hotel);
				//System.out.println(hotel.getHabitaciones().size());
				verHabitacion.buttonVer(new listenerMostrarHabitacion());
			}else if(e.getActionCommand().equals("modificarHabitaciones")){
				for(int i= 0; i<agencia.getHoteles().size(); i++){
					if(verHotel.getNombreHotel().equals(agencia.getHoteles().get(i).getNombre())){
						hotel = agencia.getHoteles().get(i);
					}
				}
				verHabitacion = new VerHabitacion(hotel);
				verHabitacion.buttonVer(new listenerModificarHabitacion());
			}else if(e.getActionCommand().equals("eliminarHabitacion")){
				eliminarHabitacion = new EliminarHabitacion(hotel);
				eliminarHabitacion.buttonEliminar(new listenerEliminarHabitacion());
			}
		}
	}
	
	public class listenerCrearHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i = 0; i < agencia.getHoteles().size(); i++){
				if(agencia.getHoteles().get(i).getNombre().equals(nombreHotel)){
					hotel = agencia.getHoteles().get(i);
				}
			}
			hotel.crearHabitacion(crearHabitacion.getTipo(), Integer.parseInt(crearHabitacion.getCantidad()),crearHabitacion.getCama(), 
					crearHabitacion.getTamaño(), Integer.parseInt(crearHabitacion.getPrecio()), Integer.parseInt(crearHabitacion.getNumPersonas()));
			JOptionPane.showMessageDialog(null, "HABITACION CREADA CORRECTAMENTE", "CREAR HABITACION", JOptionPane.INFORMATION_MESSAGE);
			/*for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
				System.out.println(hotel.getHabitaciones().get(i).getTipo());
				
			}*/
		}
	}
	
	public class listenerModificarHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i = 0; i < agencia.getHoteles().size(); i++){
				if(agencia.getHoteles().get(i).getNombre().equals(nombreHotel)){
					hotel = agencia.getHoteles().get(i);
				}
			}
			modificarHabitacion = new ModificarHabitacion(hotel, verHabitacion.getHabitacion());
			modificarHabitacion.buttonModificar(new listenerModificacionHabitacion());
		}
	}
	
	public class listenerModificacionHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			hotel.modificarHabitacion(modificarHabitacion.getTipo(), Integer.parseInt(modificarHabitacion.getCantidad()),modificarHabitacion.getCama(), 
					modificarHabitacion.getTamaño(), Integer.parseInt(modificarHabitacion.getPrecio()), Integer.parseInt(modificarHabitacion.getNumPersonas()));
			JOptionPane.showMessageDialog(null, "HABITACION MODIFICADA CORRECTAMENTE", "MODIFICAR HABITACION", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class listenerEliminarHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			hotel.eliminarHabitacion(eliminarHabitacion.getHabitacion());
			JOptionPane.showMessageDialog(null, "HABITACION ELIMINADA CORRECTAMENTE", "ELIMINAR HABITACION", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	
	public class listenerMostrarHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			menuHabitacion = new MenuHabitaciones();
			nombreHabitacion = verHabitacion.getHabitacion();
			menuHabitacion.setLabel(nombreHabitacion);
			menuHabitacion.buttonCrearServicio(new listenerEventosHabitacion());
			menuHabitacion.buttonEliminarServicio(new listenerEventosHabitacion());
			menuHabitacion.buttonModificarServicio(new listenerEventosHabitacion());
			menuHabitacion.buttonMostrarServicio(new listenerEventosHabitacion());
			
			
		}
	}
	
	public class listenerEventosHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("crearServicio")){
				crearServicio = new CrearServicio();
				crearServicio.buttonCrear(new listenerCrearServicio());
			}else if(e.getActionCommand().equals("mostrarServicio")){
				for(int i=0; i<agencia.getHoteles().size(); i++){
					for(int j=0; j<agencia.getHoteles().get(i).getHabitaciones().size();j++){
						if(verHabitacion.getHabitacion().equals(agencia.getHoteles().get(i).getHabitaciones().get(j).getTipo())){
							habitacion = agencia.getHoteles().get(i).getHabitaciones().get(j);
					}
					
					}
				}
				
				verServicios = new VerServicios(habitacion);
				verServicios.buttonVer(new listenerMostrarServicio());
			}else if(e.getActionCommand().equals("modificarServicio")){
				for(int i=0; i<agencia.getHoteles().size(); i++){
					for(int j=0; j<agencia.getHoteles().get(i).getHabitaciones().size();j++){
						if(verHabitacion.getHabitacion().equals(agencia.getHoteles().get(i).getHabitaciones().get(j).getTipo())){
							habitacion = agencia.getHoteles().get(i).getHabitaciones().get(j);
					}
					
					}
				}
				verServicios = new VerServicios(habitacion);
				verServicios.buttonVer(new listenerModificarServicio());
			}else if(e.getActionCommand().equals("eliminarServicio")){
				eliminarServicio = new EliminarServicio(habitacion);
				eliminarServicio.buttonVer(new listenerEliminarServicio());
			}
			
		}
	}
	
	public class listenerMostrarServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mostrarServicio = new MostrarServicio(habitacion, verServicios.getServicio());
			
		}
	}
	
	public class listenerCrearServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
				if(hotel.getHabitaciones().get(i).getTipo().equals(nombreHabitacion)){
					habitacion = hotel.getHabitaciones().get(i);
				}
			}
			habitacion.crearServicio(crearServicio.getDescripcion());
			JOptionPane.showMessageDialog(null, "SERVICIO CREADO CORRECTAMENTE", "CREAR SERVICIO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class listenerModificarServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
				if(hotel.getHabitaciones().get(i).getTipo().equals(nombreHabitacion)){
					habitacion = hotel.getHabitaciones().get(i);
				}
			}
			
			modificarServicio = new ModificarServicio(habitacion, verServicios.getServicio());
			modificarServicio.buttonModificar(new listenerModificacionServicio());
			
		}
	}
	
	
	public class listenerModificacionServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			habitacion.modificarServicio(modificarServicio.getDescripcion(), verServicios.getServicio());
			JOptionPane.showMessageDialog(null, "SERVICIO MODIFICADO CORRECTAMENTE", "MODIFICAR SERVICIO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class listenerEliminarServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			habitacion.eliminarServicio(eliminarServicio.getServicio());
			JOptionPane.showMessageDialog(null, "SERVICIO ELIMINADO CORRECTAMENTE", "ELIMINAR SERVICIO", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	
}
