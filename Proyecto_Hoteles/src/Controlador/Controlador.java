package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import dao.AgenciaDAO;
import dao.HotelDAO;
import dto.AgenciaDTO;
import dto.HabitacionDTO;
import dto.HotelDTO;
import negocio.Agencia;

@SuppressWarnings("unused")
public class Controlador {
	private String nombreHotel;
	private String nombreHabitacion;
	private Pantalla_Inicio principal;
	private AgenciaDTO agencia= new AgenciaDTO();
	private HotelDTO hotel = new HotelDTO();
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
	private HabitacionDTO habitacion;
	private CargaXML cargaxml = new CargaXML();
	private CargaJSON cargaJson = new CargaJSON();
	private MenuUsuario menuUsuario;
	private VistaCliente vistaCliente;
	private Agencia agenciaNegocio = new Agencia();
	private AgenciaDAO agenciaDAO = new AgenciaDAO();
	private ArrayList<HabitacionDTO> habitaciones = new ArrayList<>();
	private HotelDAO hotelDAO = new HotelDAO();
	private ArrayList<String> rutas = new ArrayList<>();
	private MenuCliente menuCliente;
	private ReservarHabitacion reservarHabitacion;
	private ConfirmarReserva confirmarReserva;
	private VerReservas verReservas;
	
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
			menuAgencia.buttonReserva(new listenerEventosAgencia());
		}
	}
	
	public class listenerCliente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			menuCliente = new MenuCliente();
			menuCliente.buttonConsultar(new listenerConsultar());
			menuCliente.buttonReservar(new listenerVerHotelReservar());
		}
	}
	
	public class listenerVerHotelReservar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
			verHotel = new VerHotel();
			verHotel.buttonVer(new listenerVerHabitacionReservar());
		}
	}
	
	public class listenerVerHabitacionReservar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			verHabitacion = new VerHabitacion(verHotel.getIdHotel());
			verHabitacion.buttonVer(new listenerReservarHabitacion());
		}
	}
	
	public class listenerReservarHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			reservarHabitacion = new ReservarHabitacion();
			reservarHabitacion.buttonReservar(new listenerConfirmarReserva());
		}
		
	}
	
	public class listenerConfirmarReserva implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			int valor = hotelDAO.getPrecioHabitacion(verHabitacion.getIdHabitacion());
			confirmarReserva = new ConfirmarReserva(verHabitacion.getHabitacion(), reservarHabitacion.getDias(), valor);
			confirmarReserva.buttonAceptar(new listenerAceptarReserva());
			confirmarReserva.buttonCancelar(new listenerCancelarReserva());
		}
		
	}
	
	public class listenerAceptarReserva implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(agenciaNegocio.getCantidadHabitaciones(verHabitacion.getIdHabitacion())>0){
				agenciaNegocio.adicionarCliente(Integer.parseInt(reservarHabitacion.getIdentificacion()), reservarHabitacion.getNombre(), reservarHabitacion.getTelefono());
				agenciaNegocio.adicionarReserva(agenciaNegocio.getIdCliente(), verHabitacion.getIdHabitacion(), reservarHabitacion.getFechaInicio(), reservarHabitacion.getFechaFin(), reservarHabitacion.getDias(), confirmarReserva.getValorTotal(), reservarHabitacion.getFechaActual());
				agenciaNegocio.descontarHabitacion(verHabitacion.getIdHabitacion());
				JOptionPane.showMessageDialog(null, "RESERVA EXITOSA", "CREAR RESERVA", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "NO HAY HABITACIONES DISPONIBLES", "CREAR RESERVA", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public class listenerTerminarReserva implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int idHabitacion = agenciaNegocio.getIdHabitacionByReserva(Integer.parseInt(verReservas.getIdReserva()));
			agenciaNegocio.terminarReserva(Integer.parseInt(verReservas.getIdReserva()), idHabitacion);
			JOptionPane.showMessageDialog(null, "RESERVA TERMINADA", "TERMINAR RESERVA", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public class listenerCancelarReserva implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class listenerConsultar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			verHotel = new VerHotel();
			verHotel.buttonVer(new listenerVerHotelCliente());
		}
		
	}
	

	
	public class listenerVerHotelCliente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stud
			habitaciones = hotelDAO.GetHabitaciones(verHotel.getIdHotel());
			vistaCliente = new VistaCliente(habitaciones);
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
				verHotel = new VerHotel();
				verHotel.buttonVer(new listenerMostrarHotel());
			}else if(e.getActionCommand().equals("modificarHoteles")){
				verHotel = new VerHotel();
				verHotel.buttonVer(new listenerModificarHotel());
			}else if(e.getActionCommand().equals("eliminarHotel")){
				eliminarHotel = new EliminarHotel();
				eliminarHotel.buttonVer(new listenerEliminarHotel());
				
			}else if(e.getActionCommand().equals("cargar")){
				try {
					JFileChooser archivo =new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
					archivo.setFileFilter(filter);
					archivo.showOpenDialog(archivo);
					File ruta = archivo.getSelectedFile();
					if(agenciaNegocio.rutas(rutas, ruta.getPath())){
						agencia = cargaxml.read(ruta.getPath()); //TODO 
						rutas.add(ruta.getPath());
						JOptionPane.showMessageDialog(null, "CARGADO CORRECTAMENTE", "CARGA XML", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "EL ARCHIVO YA FUE CARGADO", "CARGA XML", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (ParserConfigurationException | SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getActionCommand().equals("cargarJson")){
				try {
					JFileChooser archivo =new JFileChooser();
					FileNameExtensionFilter filtroJson = new FileNameExtensionFilter("JSON", "json");
					archivo.setFileFilter(filtroJson);
					archivo.showOpenDialog(archivo);
					File ruta = archivo.getSelectedFile();
					if(agenciaNegocio.rutas(rutas, ruta.getPath())){
						agencia = cargaJson.cargar(ruta.getPath());
						rutas.add(ruta.getPath());
						JOptionPane.showMessageDialog(null, "CARGADO CORRECTAMENTE", "CARGA XML", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "EL ARCHIVO YA FUE CARGADO", "CARGA XML", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getActionCommand().equals("reporte")){
				verReservas = new VerReservas();
				verReservas.cargarTablaProductos(agenciaNegocio.getReservas(), agenciaNegocio.getClientes());
				verReservas.buttonTerminar(new listenerTerminarReserva());
				
			}
			
		}
		
	}
	
	public class listenerCrearHotel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*agencia.crearHotel(crearHotel.getNombre(), crearHotel.getDireccion(), crearHotel.getTelefono(), 
					 crearHotel.getCiudad(), crearHotel.getPais());*/
			agenciaNegocio.adicionarHotel(crearHotel.getNombre(), crearHotel.getDireccion(), crearHotel.getTelefono(), crearHotel.getCiudad(), crearHotel.getPais());
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
			modificarHotel = new ModificarHotel(verHotel.getNombreHotel());
			modificarHotel.buttonModificar(new listenerModificacion());
			
		}
	}
	
	public class listenerModificacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agenciaNegocio.modificarHotel(modificarHotel.getNombre(), modificarHotel.getDireccion(),
					modificarHotel.getTelefono(), modificarHotel.getCiudad(), modificarHotel.getPais(), modificarHotel.getIdHotel());
			JOptionPane.showMessageDialog(null, "HOTEL MODIFICADO CORRECTAMENTE", "MODIFICAR HOTEL", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public class listenerEliminarHotel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agenciaNegocio.eliminarHotel(eliminarHotel.getHotel(), eliminarHotel.getIdHotel());
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
				verHabitacion = new VerHabitacion(verHotel.getIdHotel());
				//System.out.println(hotel.getHabitaciones().size());
				verHabitacion.buttonVer(new listenerMostrarHabitacion());
			}else if(e.getActionCommand().equals("modificarHabitaciones")){
				verHabitacion = new VerHabitacion(verHotel.getIdHotel());
				verHabitacion.buttonVer(new listenerModificarHabitacion());
			}else if(e.getActionCommand().equals("eliminarHabitacion")){
				eliminarHabitacion = new EliminarHabitacion(verHotel.getIdHotel());
				eliminarHabitacion.buttonEliminar(new listenerEliminarHabitacion());
			}
		}
	}
	
	public class listenerCrearHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agenciaNegocio.adicionarHabitacion(verHotel.getIdHotel(), crearHabitacion.getTipo(), Integer.parseInt(crearHabitacion.getCantidad()),crearHabitacion.getCama(), 
					crearHabitacion.getTamaño(), Integer.parseInt(crearHabitacion.getPrecio()), Integer.parseInt(crearHabitacion.getNumPersonas()));
			JOptionPane.showMessageDialog(null, "HABITACION CREADA CORRECTAMENTE", "CREAR HABITACION", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class listenerModificarHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			modificarHabitacion = new ModificarHabitacion(verHabitacion.getHabitacion(), verHotel.getIdHotel());
			modificarHabitacion.buttonModificar(new listenerModificacionHabitacion());
		}
	}
	
	public class listenerModificacionHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agenciaNegocio.modificarHabitacion(verHabitacion.getIdHabitacion(), modificarHabitacion.getTipo(), Integer.parseInt(modificarHabitacion.getCantidad()),modificarHabitacion.getCama(), 
					modificarHabitacion.getTamaño(), Integer.parseInt(modificarHabitacion.getPrecio()), Integer.parseInt(modificarHabitacion.getNumPersonas()));
			JOptionPane.showMessageDialog(null, "HABITACION MODIFICADA CORRECTAMENTE", "MODIFICAR HABITACION", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class listenerEliminarHabitacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agenciaNegocio.eliminarHabitacion(eliminarHabitacion.getIdHabitacion());
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
				
				verServicios = new VerServicios(verHabitacion.getIdHabitacion());
				verServicios.buttonVer(new listenerMostrarServicio());
			}else if(e.getActionCommand().equals("modificarServicio")){
				verServicios = new VerServicios(verHabitacion.getIdHabitacion());
				verServicios.buttonVer(new listenerModificarServicio());
			}else if(e.getActionCommand().equals("eliminarServicio")){
				eliminarServicio = new EliminarServicio(verHabitacion.getIdHabitacion());
				eliminarServicio.buttonVer(new listenerEliminarServicio());
			}
			
		}
	}
	
	public class listenerMostrarServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mostrarServicio = new MostrarServicio(verServicios.getServicio(), verHabitacion.getIdHabitacion());
			
		}
	}
	
	public class listenerCrearServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			agenciaNegocio.adicionarServicio(crearServicio.getDescripcion(), verHabitacion.getIdHabitacion());
			JOptionPane.showMessageDialog(null, "SERVICIO CREADO CORRECTAMENTE", "CREAR SERVICIO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class listenerModificarServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			modificarServicio = new ModificarServicio(verServicios.getServicio(), verHabitacion.getIdHabitacion());
			modificarServicio.buttonModificar(new listenerModificacionServicio());
			
		}
	}
	
	
	public class listenerModificacionServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agenciaNegocio.modificarServicio(modificarServicio.getDescripcion(), modificarServicio.getIdServicio());
			JOptionPane.showMessageDialog(null, "SERVICIO MODIFICADO CORRECTAMENTE", "MODIFICAR SERVICIO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class listenerEliminarServicio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			agenciaNegocio.eliminarServicio(eliminarServicio.getServicio(), eliminarServicio.getIdServicio());
			JOptionPane.showMessageDialog(null, "SERVICIO ELIMINADO CORRECTAMENTE", "ELIMINAR SERVICIO", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	
}
