package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interfaz.AccesoSistema;
import Interfaz.MenuAdmin;
import Interfaz.MenuVende;
import Interfaz.PVendedor;
import Interfaz.Principal;
import Interfaz.VentasRealizadas;

public class Controller {
	
	private String var_Session;
	private Principal interfazPrincipal;
	private AccesoSistema accesoSistema;
	private MenuAdmin administrador_interfaz_principal;
	private MenuVende vendedor_interfaz_principal;
	private PVendedor perfilVendedor;
	private VentasRealizadas ventasVendedor;
	
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
			}else if(e.getActionCommand().equals("ingresar_venta")){
				System.out.println("jdnasjldnas");
			}else if(e.getActionCommand().equals("ventas_realizadas")){
				ventasVendedor = new VentasRealizadas();
			}
		}
		
	}
	
	public static void main(String[] args){
		Principal i = new Principal();
		Controller c = new Controller(i);
		
	}
	
}
