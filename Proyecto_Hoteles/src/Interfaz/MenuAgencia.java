package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuAgencia extends JFrame {

	private JLabel bienvenida;
	private JButton crearHotel;
	private JButton mostrarHoteles;
	private JButton modificarHoteles;
	private JButton eliminarHotel;
	private JButton cargarXML;
	private JButton cargarJson;

	public MenuAgencia() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(600, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		bienvenida = new JLabel("Bienvenido");
		bienvenida.setBounds(250, 20, 400, 50);
		bienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(bienvenida);

		crearHotel = new JButton("Crear Hotel");
		crearHotel.setBounds(240, 180, 120, 30);
		crearHotel.setFont(new Font("Tahoma", 0, 15));
		crearHotel.setActionCommand("crearHotel");
		add(crearHotel);

		mostrarHoteles = new JButton("Ver Hotel");
		mostrarHoteles.setBounds(235, 260, 120, 30);
		mostrarHoteles.setFont(new Font("Tahoma", 0, 15));
		mostrarHoteles.setActionCommand("mostrarHoteles");
		add(mostrarHoteles);

		modificarHoteles = new JButton("Modificar Hotel");
		modificarHoteles.setBounds(220, 340, 150, 30);
		modificarHoteles.setFont(new Font("Tahoma", 0, 15));
		modificarHoteles.setActionCommand("modificarHoteles");
		add(modificarHoteles);

		eliminarHotel = new JButton("Eliminar Hotel");
		eliminarHotel.setBounds(220, 420, 150, 30);
		eliminarHotel.setFont(new Font("Tahoma", 0, 15));
		eliminarHotel.setActionCommand("eliminarHotel");
		add(eliminarHotel);
		
		cargarXML = new JButton("Cargar XML");
		cargarXML.setBounds(220, 500, 150, 30);
		cargarXML.setFont(new Font("Tahoma", Font.BOLD, 15));
		cargarXML.setActionCommand("cargar");
		add(cargarXML);
		
		cargarJson = new JButton("Cargar Json");
		cargarJson.setBounds(220, 580, 150, 30);
		cargarJson.setFont(new Font("Tahoma", Font.BOLD, 15));
		cargarJson.setActionCommand("cargarJson");
		add(cargarJson);

		setVisible(true);
	}
	
	public void buttonCrearHotel(ActionListener l){
		crearHotel.addActionListener(l);
	}
	
	public void buttonMostrarHoteles(ActionListener l){
		mostrarHoteles.addActionListener(l);
	}
	
	public void buttonModificarHoteles(ActionListener l){
		modificarHoteles.addActionListener(l);
	}
	
	public void buttonEliminarHotel(ActionListener l){
		eliminarHotel.addActionListener(l);
	}
	
	public void buttonCargarXml(ActionListener l){
		cargarXML.addActionListener(l);
	}
	
	public void buttonCargarJson(ActionListener l){
		cargarJson.addActionListener(l);
	}
	
}
