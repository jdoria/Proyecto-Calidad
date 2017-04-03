package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame{
	private JLabel ingreso;
	private JLabel admin;
	private JLabel cliente;
	private JButton contAdmin;
	private JButton contCliente;
	
	public MenuUsuario() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		ingreso = new JLabel("INGRESO");
		ingreso.setBounds(150,80,100,30);
		ingreso.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(ingreso);
		
		admin = new JLabel("Administrador");
		admin.setBounds(70, 130, 120, 30);
		admin.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(admin);
		
		cliente = new JLabel("Cliente");
		cliente.setBounds(260, 130, 100, 30);
		cliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(cliente);
		
		contAdmin = new JButton("Continuar");
		contAdmin.setBounds(60,200,120,30);
		contAdmin.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(contAdmin);
		
		contCliente = new JButton("Continuar");
		contCliente.setBounds(240, 200, 120, 30);
		contCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(contCliente);
				
		setVisible(true);

	}
	
	public void buttonContAdmin(ActionListener l){
		contAdmin.addActionListener(l);
	}
	
	public void buttonContCliente(ActionListener l){
		contCliente.addActionListener(l);
	}
}
