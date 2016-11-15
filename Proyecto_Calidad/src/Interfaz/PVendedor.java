package Interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PVendedor extends JFrame {
	
	private JLabel presentacion;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel identificacion;
	private JLabel numCarrosVendidos;
	private JLabel calificaciones;
	private JButton botonCalificaciones;
	private JButton logo;
	
	
	public PVendedor() {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Electiva III");
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		presentacion = new JLabel("Vendedor");
		presentacion.setBounds(220, 50, 150, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		logo = new JButton(new ImageIcon("imagenes/vendedor.jpg"));
		logo.setBackground(Color.black);
		logo.setRolloverIcon(new ImageIcon("imagenes/vendedor.jpg"));
		logo.setBounds(200, 100, 200, 200);
		add(logo);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(140, 320, 120, 30);
		nombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(nombre);
		
		apellido = new JLabel("Apellido:");
		apellido.setBounds(140, 350, 120, 30);
		apellido.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(apellido);
		
		identificacion = new JLabel("Identficacion:");
		identificacion.setBounds(140, 380, 150, 30);
		identificacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(identificacion);
		
		numCarrosVendidos = new JLabel("Número de carros vendidos:");
		numCarrosVendidos.setBounds(140, 410, 250, 30);
		numCarrosVendidos.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(numCarrosVendidos);
		
		calificaciones = new JLabel("Calificaciones");
		calificaciones.setBounds(140, 440, 150, 30);
		calificaciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(calificaciones);
		
		botonCalificaciones = new JButton("Ver");
		botonCalificaciones.setBounds(310, 440, 100, 30);
		botonCalificaciones.setFont(new Font("Tahoma", 0, 15));
		add(botonCalificaciones);
		
		
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		PVendedor p = new PVendedor();
		
		p.setVisible(true);

		}*/
	
}
