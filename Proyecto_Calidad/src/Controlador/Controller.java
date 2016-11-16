package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import Interfaz.AccesoSistema;
import Interfaz.AsignarLineas;
import Interfaz.AsignarPuntos;
import Interfaz.MenuAdmin;
import Interfaz.MenuVende;
import Interfaz.PAdministrador;
import Interfaz.PVendedor;
import Interfaz.Principal;
import Interfaz.VentasRealizadas;
import Interfaz.VerLineas;
import Interfaz.Calificaciones;
import Interfaz.CalificarVendedor;

public class Controller {
	
	private String var_Session;
	private Principal interfazPrincipal;
	private AccesoSistema accesoSistema;
	private MenuAdmin administrador_interfaz_principal;
	private MenuVende vendedor_interfaz_principal;
	private PVendedor perfilVendedor;
	private VentasRealizadas ventasVendedor;
	private Calificaciones calificaciones;
	private PAdministrador perfilAdmin;
	private VerLineas verLineas;
	private AsignarLineas asignarLineas;
	private AsignarPuntos asignarPuntos;
	private CalificarVendedor calificarVendedores;
	
	
	public Controller(Principal interfaz) {
		this.interfazPrincipal = interfaz;
		this.interfazPrincipal.buttonContinue(new listener());
	}
	
	class listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("continuar")) {
				accesoSistema = new AccesoSistema();
				accesoSistema.buttonAdmin(new listenerEvent());
				accesoSistema.buttonVendedor(new listenerEvent());
			}
		}
		
	}
	
	
	class listenerEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("login_admin")) {
				System.out.println("user admin: " + accesoSistema.getUser());
				System.out.println("user pwd: " + accesoSistema.getPassword());
				administrador_interfaz_principal = new MenuAdmin();
				administrador_interfaz_principal.buttonPerfil(new listenerManejoDeEventosAdmin());
				administrador_interfaz_principal.buttonVerLineas(new listenerManejoDeEventosAdmin());
				administrador_interfaz_principal.buttonAsignarLineas(new listenerManejoDeEventosAdmin());
				administrador_interfaz_principal.buttonAsignarPuntos(new listenerManejoDeEventosAdmin());
				administrador_interfaz_principal.buttonCalificarVendedores(new listenerManejoDeEventosAdmin());
			}
			else if (e.getActionCommand().equals("login_vendedor")) {
				System.out.println("user admin: " + accesoSistema.getUserVendedor());
				System.out.println("user pwd: " + accesoSistema.getPasswordVendedor());
				var_Session = accesoSistema.getUserVendedor();
				vendedor_interfaz_principal = new MenuVende();
				vendedor_interfaz_principal.buttonPerfil(new listenerManejoDeEventosVendedor());
				vendedor_interfaz_principal.buttonIngresarVentas(new listenerManejoDeEventosVendedor());
				vendedor_interfaz_principal.buttonVentasRealizadas(new listenerManejoDeEventosVendedor());
				vendedor_interfaz_principal.setUserLabel(var_Session);
			}
		}
		
	}
	
	
	
	
	public class listenerManejoDeEventosVendedor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("perfil_usuario")) {
				perfilVendedor = new PVendedor();	
				perfilVendedor.buttonCalificaciones(new listenerPerfilVendedor());
			}else if(e.getActionCommand().equals("ingresar_venta")){
				System.out.println("jdnasjldnas");
			}else if(e.getActionCommand().equals("ventas_realizadas")){
				ventasVendedor = new VentasRealizadas();
			}
		}
		
	}
	

	class listenerPerfilVendedor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("ver_calificaciones")){
				calificaciones = new Calificaciones();
			}
			
		}
		
	}
	
	public class listenerManejoDeEventosAdmin implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("perfil")){
				perfilAdmin = new PAdministrador();
			}else if(e.getActionCommand().equals("ver_lineas")){
				verLineas = new VerLineas();
			}else if(e.getActionCommand().equals("asignar_linea")){
				asignarLineas = new AsignarLineas();
			}else if(e.getActionCommand().equals("asignar_puntos")){
				asignarPuntos = new AsignarPuntos();
			}else if(e.getActionCommand().equals("calificar_vendedores")){
				calificarVendedores = new CalificarVendedor();
			}
			
		}
		
	}
	
	
	public static void main(String[] args){
		Principal i = new Principal();
		Controller c = new Controller(i);
		
	}
	
}
