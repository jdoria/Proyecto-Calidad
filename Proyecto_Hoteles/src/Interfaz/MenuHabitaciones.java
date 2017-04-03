package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuHabitaciones extends JFrame {

	private JLabel bienvenida;
	private JButton crearServicio;
	private JButton mostrarServicio;
	private JButton modificarServicio;
	private JButton eliminarServicio;

	public MenuHabitaciones() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(600, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		bienvenida = new JLabel("Bienvenido a ");
		bienvenida.setBounds(240, 20, 400, 50);
		bienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(bienvenida);

		crearServicio = new JButton("Crear Servicio");
		crearServicio.setBounds(220, 180, 160, 30);
		crearServicio.setFont(new Font("Tahoma", 0, 15));
		crearServicio.setActionCommand("crearServicio");
		add(crearServicio);

		mostrarServicio = new JButton("Ver Servicio");
		mostrarServicio.setBounds(225, 260, 150, 30);
		mostrarServicio.setFont(new Font("Tahoma", 0, 15));
		mostrarServicio.setActionCommand("mostrarServicio");
		add(mostrarServicio);

		modificarServicio = new JButton("Modificar Servicio");
		modificarServicio.setBounds(225, 340, 220, 30);
		modificarServicio.setFont(new Font("Tahoma", 0, 15));
		modificarServicio.setActionCommand("modificarServicio");
		add(modificarServicio);

		eliminarServicio = new JButton("Eliminar Servicio");
		eliminarServicio.setBounds(225, 420, 220, 30);
		eliminarServicio.setFont(new Font("Tahoma", 0, 15));
		eliminarServicio.setActionCommand("eliminarServicio");
		add(eliminarServicio);

		setVisible(true);

	}
	
	public void setLabel(String nombre){
		bienvenida.setText(bienvenida.getText() + nombre);
	}
	
	public void buttonCrearServicio(ActionListener l){
		crearServicio.addActionListener(l);
	}
	
	public void buttonMostrarServicio(ActionListener l){
		mostrarServicio.addActionListener(l);
	}
	
	public void buttonEliminarServicio(ActionListener l){
		eliminarServicio.addActionListener(l);
	}
	
	public void buttonModificarServicio(ActionListener l){
		modificarServicio.addActionListener(l);
	}

}
