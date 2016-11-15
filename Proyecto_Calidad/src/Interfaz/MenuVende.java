package Interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuVende extends JFrame {
	
	private JButton perfil;
	private JButton ingresarVenta;
	private JButton ventasRealizadas;
	private JLabel bienvenida;
	
	
	public MenuVende() {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Electiva III");
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		bienvenida = new JLabel("Bienvenido ___");
		bienvenida.setBounds(200, 20, 400, 50);
		bienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(bienvenida);
		
		perfil = new JButton("Perfil");
		perfil.setBounds(220, 200, 120, 30);
		perfil.setFont(new Font("Tahoma", 0, 15));
		add(perfil);
		
		ingresarVenta = new JButton("Ingresar Venta");
		ingresarVenta.setBounds(205, 300, 150, 30);
		ingresarVenta.setFont(new Font("Tahoma", 0, 15));
		add(ingresarVenta);
		
		ventasRealizadas = new JButton("Ventas Realizadas");
		ventasRealizadas.setBounds(200, 400, 165, 30);
		ventasRealizadas.setFont(new Font("Tahoma", 0, 15));
		add(ventasRealizadas);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuVende p = new MenuVende();
		
		p.setVisible(true);

	}
}
