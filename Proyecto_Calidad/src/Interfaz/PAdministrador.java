package Interfaz;

import javax.swing.*;

import dao.AdminDao;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class PAdministrador extends JFrame {
	
	private JLabel presentacion;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel identificacion;
	private JLabel nombreAdmin;
	private JLabel apellidoAdmin;
	private JLabel identifAdmin;
	private JButton logo;
	private AdminDao objetoAdmin = new AdminDao();
	
	public PAdministrador() {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Electiva III");
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		presentacion = new JLabel("Administrador");
		presentacion.setBounds(220, 50, 150, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		logo = new JButton(new ImageIcon("imagenes/admin.jpg"));
		logo.setBackground(Color.black);
		logo.setRolloverIcon(new ImageIcon("imagenes/admin2.jpg"));
		logo.setBounds(200, 100, 200, 200);
		add(logo);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(170, 320, 120, 30);
		nombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(nombre);
		
		nombreAdmin = new JLabel(objetoAdmin.GetAdmin().getNombre());
		nombreAdmin.setBounds(200, 320, 120, 30);
		nombreAdmin.setFont(new Font("Tahoma", 0, 15));
		add(nombreAdmin);
		
		apellido = new JLabel("Apellido:");
		apellido.setBounds(170, 370, 120, 30);
		apellido.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(apellido);
		
		apellidoAdmin = new JLabel();
		apellidoAdmin.setText(objetoAdmin.GetAdmin().getApellido());
		apellidoAdmin.setBounds(200, 370, 120, 30);
		apellidoAdmin.setFont(new Font("Tahoma", 0, 15));
		add(apellidoAdmin);
		
		identificacion = new JLabel("Identficacion:");
		identificacion.setBounds(170, 420, 150, 30);
		identificacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(identificacion);
		
		identifAdmin = new JLabel(objetoAdmin.GetAdmin().getIdentificación());
		identifAdmin.setBounds(200, 420, 150, 30);
		identifAdmin.setFont(new Font("Tahoma", 0, 15));
		add(identifAdmin);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args){
		PAdministrador p = new PAdministrador();
	}
}
