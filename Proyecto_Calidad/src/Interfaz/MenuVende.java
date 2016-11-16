package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		bienvenida = new JLabel("Bienvenido ");
		bienvenida.setBounds(200, 20, 400, 50);
		bienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(bienvenida);
		
		perfil = new JButton("Perfil");
		perfil.setBounds(220, 200, 120, 30);
		perfil.setFont(new Font("Tahoma", 0, 15));
		perfil.setActionCommand("perfil_usuario");
		add(perfil);
		
		ingresarVenta = new JButton("Ingresar Venta");
		ingresarVenta.setBounds(205, 300, 150, 30);
		ingresarVenta.setFont(new Font("Tahoma", 0, 15));
		ingresarVenta.setActionCommand("ingresar_venta");
		add(ingresarVenta);
		
		ventasRealizadas = new JButton("Ventas Realizadas");
		ventasRealizadas.setBounds(200, 400, 165, 30);
		ventasRealizadas.setFont(new Font("Tahoma", 0, 15));
		ventasRealizadas.setActionCommand("ventas_realizadas");
		add(ventasRealizadas);
		
		setVisible(true);
	}
	
	public void setUserLabel(String username) {
		bienvenida.setText(bienvenida.getText() + username);
	}
	
	/**
	 * Manejo de eventos
	 */
	
	public void buttonPerfil(ActionListener l) {
		perfil.addActionListener(l);
	}
	
	public void buttonIngresarVentas(ActionListener l){
		ingresarVenta.addActionListener(l);
	}
	
	public void buttonVentasRealizadas(ActionListener l){
		ventasRealizadas.addActionListener(l);
	}
	
	
}
