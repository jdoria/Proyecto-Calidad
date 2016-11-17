package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Interfaz.AccesoSistema;
import Interfaz.AsignarLineas;
import Interfaz.AsignarPuntos;
import Interfaz.MenuAdmin;
import Interfaz.MenuVende;
import Interfaz.PAdministrador;
import Interfaz.PVendedor;
import Interfaz.Principal;
import Interfaz.SeleccionarVendedor;
import Interfaz.VentasRealizadas;
import Interfaz.VerLineas;
import dao.LineaDao;
import dao.UsuarioDao;
import Interfaz.Calificaciones;
import Interfaz.CalificacionesAdmin;

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
	private SeleccionarVendedor seleccionarVendedor;
	private CalificacionesAdmin calificacionesAdmin;
	private LineaDao lineaDao = new LineaDao();
	private String tNumPuntos;
	private int numPuntos;
	private UsuarioDao usuario = new UsuarioDao();
	
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
				System.out.println("user admin: " + accesoSistema.getAdmin());
				System.out.println("user pwd: " + accesoSistema.getPasswordAdmin());
				if(accesoSistema.getAdmin().equals("jdoria") && accesoSistema.getPasswordAdmin().equals("juan9608")){
					administrador_interfaz_principal = new MenuAdmin();
					administrador_interfaz_principal.buttonPerfil(new listenerManejoDeEventosAdmin());
					administrador_interfaz_principal.buttonVerLineas(new listenerManejoDeEventosAdmin());
					administrador_interfaz_principal.buttonAsignarLineas(new listenerManejoDeEventosAdmin());
					administrador_interfaz_principal.buttonAsignarPuntos(new listenerManejoDeEventosAdmin());
					administrador_interfaz_principal.buttonCalificarVendedores(new listenerManejoDeEventosAdmin());
				}else{
					JOptionPane.showMessageDialog(null, "ERROR DE AUTENTICACION", "ACCESO DENEGADO",
							JOptionPane.ERROR_MESSAGE);
				}
					
			
			}else if (e.getActionCommand().equals("login_vendedor")){
				System.out.println("user admin: " + accesoSistema.getUserVendedor());
				System.out.println("user pwd: " + accesoSistema.getPasswordVendedor());
				if(usuario.validarUsuarios(accesoSistema.getUserVendedor(), accesoSistema.getPasswordVendedor())){
					var_Session = accesoSistema.getUserVendedor();
					vendedor_interfaz_principal = new MenuVende();
					vendedor_interfaz_principal.buttonPerfil(new listenerManejoDeEventosVendedor());
					vendedor_interfaz_principal.buttonIngresarVentas(new listenerManejoDeEventosVendedor());
					vendedor_interfaz_principal.buttonVentasRealizadas(new listenerManejoDeEventosVendedor());					vendedor_interfaz_principal.setUserLabel(var_Session);
					
				}else{
					JOptionPane.showMessageDialog(null, "ERROR DE AUTENTICACION", "ACCESO DENEGADO",
							JOptionPane.ERROR_MESSAGE);
				}
				
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
				asignarLineas.buttonAsignar(new listenerAsignarLineas());
			}else if(e.getActionCommand().equals("asignar_puntos")){
				asignarPuntos = new AsignarPuntos();
				asignarPuntos.buttonAsignar(new listenerAsignarPuntos());
				
			}else if(e.getActionCommand().equals("calificar_vendedores")){
				seleccionarVendedor = new SeleccionarVendedor();
				seleccionarVendedor.getIdVendedor();
				seleccionarVendedor.buttonAsignar(new listenerCalificacionesAdmin());
			}
			
		}
		
	}
	
	public class listenerCalificacionesAdmin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//seleccionarVendedor.getIdVendedor();
			calificacionesAdmin = new CalificacionesAdmin(seleccionarVendedor.getIdVendedor());
			
		}
		
	}
	
	public class listenerAsignarLineas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			lineaDao.AsignarVendedor(asignarLineas.getIdVendedor(), asignarLineas.getLinea());
		}
		
	}
	
	public class listenerAsignarPuntos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tNumPuntos = asignarPuntos.getPuntos();
			numPuntos = Integer.parseInt(tNumPuntos);
			if(tNumPuntos == null || asignarPuntos.getLinea().equals(null)){
				JOptionPane.showMessageDialog(null, "ERROR DE ASIGNACION", "CAMPO VACIO",
						JOptionPane.ERROR_MESSAGE);
			}else{
				lineaDao.asignarPuntos(numPuntos, asignarPuntos.getLinea());
			}
		}
		
	}
	
	public static void main(String[] args){
		Principal i = new Principal();
		Controller c = new Controller(i);
		
	}
	
}
