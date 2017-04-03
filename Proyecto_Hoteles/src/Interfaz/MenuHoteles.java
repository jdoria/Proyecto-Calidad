package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuHoteles extends JFrame{
	
	private JLabel bienvenida;
	private JButton crearHabitacion;
	private JButton mostrarHabitaciones;
	private JButton modificarHabitaciones;
	private JButton eliminarHabitacion;
	
	public MenuHoteles() {
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

		crearHabitacion = new JButton("Crear Habitacion");
		crearHabitacion.setBounds(220, 180, 160, 30);
		crearHabitacion.setFont(new Font("Tahoma", 0, 15));
		crearHabitacion.setActionCommand("crearHabitacion");
		add(crearHabitacion);

		mostrarHabitaciones = new JButton("Ver Habitaciones");
		mostrarHabitaciones.setBounds(225, 260, 150, 30);
		mostrarHabitaciones.setFont(new Font("Tahoma", 0, 15));
		mostrarHabitaciones.setActionCommand("mostrarHabitaciones");
		add(mostrarHabitaciones);

		modificarHabitaciones = new JButton("Modificar Habitaciones");
		modificarHabitaciones.setBounds(225, 340, 220, 30);
		modificarHabitaciones.setFont(new Font("Tahoma", 0, 15));
		modificarHabitaciones.setActionCommand("modificarHabitaciones");
		add(modificarHabitaciones);

		eliminarHabitacion = new JButton("Eliminar Habitacion");
		eliminarHabitacion.setBounds(225, 420, 220, 30);
		eliminarHabitacion.setFont(new Font("Tahoma", 0, 15));
		eliminarHabitacion.setActionCommand("eliminarHabitacion");
		add(eliminarHabitacion);

		setVisible(true);

	}
	
	public static void main(String[] args){
		MenuHoteles m = new MenuHoteles();
	}
	
	public void setLabel(String nombre){
		bienvenida.setText(bienvenida.getText() + nombre);
	}
	
	public void buttonCrearHabitacion(ActionListener l){
		crearHabitacion.addActionListener(l);
	}
	
	public void buttonMostrarHabitaciones(ActionListener l){
		mostrarHabitaciones.addActionListener(l);
	}
	
	public void buttonModificarHabitacion(ActionListener l){
		modificarHabitaciones.addActionListener(l);
	}
	
	public void buttonEliminarHabitacion(ActionListener l){
		eliminarHabitacion.addActionListener(l);
	}
	
	
	
	

}
