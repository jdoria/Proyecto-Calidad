package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AccesoSistema extends JFrame {
	
	private JLabel anuncio;
	private JButton logoVendedor;
	private JButton logoAdmin;
	private JLabel labelAdmin;
	private JLabel labelVendedor;
	private JTextField usuarioAdmin;
	private JTextField usuarioVendedor;
	private JTextField passwordAdmin;
	private JTextField passwordVendedor;
	private JLabel nUsuarioAdmin;
	private JLabel nPasswordAdmin;
	private JLabel nUsuarioVendedor;
	private JLabel nPasswordVendedor;
	private JButton ingresarAdmin;
	private JButton ingresarVendedor;
	
	public AccesoSistema() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Electiva III");
		setSize(1000, 650);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		anuncio = new JLabel("INGRESO AL SISTEMA");
		anuncio.setBounds(390, 20, 400, 50);
		anuncio.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(anuncio);
		
		logoAdmin = new JButton(new ImageIcon("imagenes/admin.jpg"));
		logoAdmin.setBackground(Color.black);
		logoAdmin.setRolloverIcon(new ImageIcon("imagenes/admin2.jpg"));
		logoAdmin.setBounds(150, 100, 200, 200);
		add(logoAdmin);
		
		labelAdmin = new JLabel("Administrador");
		labelAdmin.setBounds(170, 320, 400, 50);
		labelAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(labelAdmin);
		
		usuarioAdmin = new JTextField();
		usuarioAdmin.setBounds(170, 390, 150, 30);
		add(usuarioAdmin);
		
		passwordAdmin= new JTextField();
		passwordAdmin.setBounds(170, 450, 150, 30);
		add(passwordAdmin);

		nUsuarioAdmin = new JLabel("Usuario");
		nUsuarioAdmin.setBounds(170, 360, 150, 30);
		nUsuarioAdmin.setFont(new Font("Tahoma", 0, 15));
		add(nUsuarioAdmin);
		
		nPasswordAdmin = new JLabel("Contraseña");
		nPasswordAdmin.setBounds(170, 420, 150, 30);
		nPasswordAdmin.setFont(new Font("Tahoma", 0, 15));
		add(nPasswordAdmin);
		
		ingresarAdmin = new JButton("Ingresar");
		ingresarAdmin.setBounds(190, 500, 100, 30);
		ingresarAdmin.setActionCommand("login_admin");
		//ingresar.setActionCommand("aceptar");
		add(ingresarAdmin);

		
		logoVendedor = new JButton(new ImageIcon("imagenes/vendedor.jpg"));
		logoVendedor.setBackground(Color.black);
		logoVendedor.setRolloverIcon(new ImageIcon("imagenes/vendedor2.jpg"));
		logoVendedor.setBounds(650, 100, 200, 200);
		add(logoVendedor);
		
		labelVendedor = new JLabel("Vendedor");
		labelVendedor.setBounds(700, 320, 400, 50);
		labelVendedor.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(labelVendedor);
		
		usuarioVendedor = new JTextField();
		usuarioVendedor.setBounds(680, 390, 150, 30);
		add(usuarioVendedor);
		
		passwordVendedor= new JTextField();
		passwordVendedor.setBounds(680, 450, 150, 30);
		add(passwordVendedor);

		nUsuarioVendedor = new JLabel("Usuario");
		nUsuarioVendedor.setBounds(680, 360, 150, 30);
		nUsuarioVendedor.setFont(new Font("Tahoma", 0, 15));
		add(nUsuarioVendedor);
		
		nPasswordVendedor = new JLabel("Contraseña");
		nPasswordVendedor.setBounds(680, 420, 150, 30);
		nPasswordVendedor.setFont(new Font("Tahoma", 0, 15));
		add(nPasswordVendedor);
		
		ingresarVendedor = new JButton("Ingresar");
		ingresarVendedor.setBounds(710, 500, 100, 30);
		ingresarVendedor.setActionCommand("login_vendedor");
		//ingresar.setActionCommand("aceptar");
		add(ingresarVendedor);
		
		setVisible(true);
		
	}
	
	public String getUser() {
		return usuarioAdmin.getText();
	}
	
	public String getPassword() {
		return passwordAdmin.getText();
	}

	public String getUserVendedor(){
		return usuarioVendedor.getText();
	}
	
	public String getPasswordVendedor(){
		return passwordVendedor.getText();
	}
	
	
	/**
	 * Manejo de eventos
	 */
	
	public void buttonAdmin(ActionListener l) {
		ingresarAdmin.addActionListener(l);
	}
	
	public void buttonVendedor(ActionListener l) {
		ingresarVendedor.addActionListener(l);
	}
	
}
