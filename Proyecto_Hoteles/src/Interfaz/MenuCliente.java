package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuCliente extends JFrame {
	
	private JLabel cliente;
	private JLabel consultar;
	private JLabel reservar;
	private JButton buttonConsultar;
	private JButton buttonReservar;
	
	public MenuCliente() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		cliente = new JLabel("CLIENTE");
		cliente.setBounds(160,70,100,30);
		cliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(cliente);
		
		consultar = new JLabel("Consultar Habitación");
		consultar.setBounds(45, 130, 180, 30);
		consultar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(consultar);
		
		reservar = new JLabel("Reservar");
		reservar.setBounds(260, 130, 100, 30);
		reservar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(reservar);
		
		buttonConsultar = new JButton("Consultar");
		buttonConsultar.setBounds(60,200,120,30);
		buttonConsultar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(buttonConsultar);
		
		buttonReservar = new JButton("Reservar");
		buttonReservar.setBounds(240, 200, 120, 30);
		buttonReservar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(buttonReservar);
				
		setVisible(true);

	}
	
	public void buttonConsultar(ActionListener l){
		buttonConsultar.addActionListener(l);
	}
	
	public void buttonReservar(ActionListener l){
		buttonReservar.addActionListener(l);
	}

	
	
}
