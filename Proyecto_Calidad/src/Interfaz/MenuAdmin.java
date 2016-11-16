package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuAdmin extends JFrame {
	
	private JLabel bienvenida;
	private JButton perfil;
	private JButton verLineas;
	private JButton asignarLinea;
	private JButton asignarPuntos;
	private JButton calificarVendedor;
	
	
	public MenuAdmin() {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Electiva III");
		setSize(600, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		bienvenida = new JLabel("Bienvenido Administrador");
		bienvenida.setBounds(160, 20, 400, 50);
		bienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(bienvenida);
		
		perfil = new JButton("Perfil");
		perfil.setBounds(235, 180, 120, 30);
		perfil.setFont(new Font("Tahoma", 0, 15));
		perfil.setActionCommand("perfil");
		add(perfil);
		
		verLineas = new JButton("Ver Lineas");
		verLineas.setBounds(220, 280, 150, 30);
		verLineas.setFont(new Font("Tahoma", 0, 15));
		verLineas.setActionCommand("ver_lineas");
		add(verLineas);
		
		asignarLinea = new JButton("Asignar líneas");
		asignarLinea.setBounds(220, 380, 150, 30);
		asignarLinea.setFont(new Font("Tahoma", 0, 15));
		asignarLinea.setActionCommand("asignar_linea");
		add(asignarLinea);
		
		asignarPuntos = new JButton("Asignar puntos");
		asignarPuntos.setBounds(220, 480, 150, 30);
		asignarPuntos.setFont(new Font("Tahoma", 0, 15));
		asignarPuntos.setActionCommand("asignar_puntos");
		add(asignarPuntos);		

		calificarVendedor = new JButton("Calificar Vendedores");
		calificarVendedor.setBounds(215, 580, 165, 30);
		calificarVendedor.setFont(new Font("Tahoma", 0, 15));
		calificarVendedor.setActionCommand("calificar_vendedores");
		add(calificarVendedor);
		
		setVisible(true);
	}
	
	
	/**
	 * Manejo de eventos
	 */
	
	public void buttonPerfil(ActionListener l){
		perfil.addActionListener(l);
	}
	
	public void buttonVerLineas(ActionListener l){
		verLineas.addActionListener(l);
	}
	
	public void buttonAsignarLineas(ActionListener l){
		asignarLinea.addActionListener(l);
	}
	
	public void buttonAsignarPuntos(ActionListener l){
		asignarPuntos.addActionListener(l);
	}
	
	public void buttonCalificarVendedores(ActionListener l){
		calificarVendedor.addActionListener(l);
	}
}
