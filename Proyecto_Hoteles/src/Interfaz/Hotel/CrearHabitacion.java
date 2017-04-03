package Interfaz.Hotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CrearHabitacion extends JFrame{
	
	private JLabel anuncio;
	private JLabel tipoHabitacion;
	private JTextField tipo;
	private JLabel cantidadHabitacion;
	private JTextField cantidad;
	private JLabel camaHabitacion;
	private JTextField cama;
	private JLabel tamañoHabitacion;
	private JTextField tamaño;
	private JLabel precioHabitacion;
	private JTextField precio;
	private JLabel numPersonasHabitacion;
	private JTextField numPersonas;
	private JButton crear;
	
	public CrearHabitacion() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(600, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		anuncio = new JLabel("CREAR UNA NUEVA HABITACION");
		anuncio.setBounds(150, 80, 450, 100);
		anuncio.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(anuncio);
		
		tipoHabitacion = new JLabel("Tipo: ");
		tipoHabitacion.setBounds(100, 220, 100, 80);
		tipoHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(tipoHabitacion);
		
		tipo = new JTextField();
		tipo.setBounds(300, 250, 150, 30);
		add(tipo);
		
		cantidadHabitacion = new JLabel("Cantidad: ");
		cantidadHabitacion.setBounds(100, 270, 100, 80);
		cantidadHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(cantidadHabitacion);
		
		cantidad = new JTextField();
		cantidad.setBounds(300, 300, 150, 30);
		add(cantidad);
		
		camaHabitacion = new JLabel("Cama: ");
		camaHabitacion.setBounds(100, 320, 200, 80);
		camaHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(camaHabitacion);
		
		cama = new JTextField();
		cama.setBounds(300, 350, 150, 30);
		add(cama);
		
		numPersonasHabitacion = new JLabel("Número de Personas: ");
		numPersonasHabitacion.setBounds(100, 370, 200, 80);
		numPersonasHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(numPersonasHabitacion);
		
		numPersonas = new JTextField();
		numPersonas.setBounds(300, 400, 150, 30);
		add(numPersonas);
		
		tamañoHabitacion = new JLabel("Tamaño: ");
		tamañoHabitacion.setBounds(100, 420, 100, 80);
		tamañoHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(tamañoHabitacion);
		
		tamaño = new JTextField();
		tamaño.setBounds(300, 450, 150, 30);
		add(tamaño);
		
		precioHabitacion = new JLabel("Precio: ");
		precioHabitacion.setBounds(100, 470, 100, 80);
		precioHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(precioHabitacion);
		
		precio = new JTextField();
		precio.setBounds(300, 500, 150, 30);
		add(precio);
		
		crear = new JButton("Crear");
		crear.setBounds(250, 550, 100, 40);
		crear.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(crear);
		
		setVisible(true);
	
		
		
	}
	
	
	public void buttonCrear(ActionListener l){
		crear.addActionListener(l);
	}
	
	public String getTipo(){
		return tipo.getText();
	}
	
	public String getCantidad(){
		return cantidad.getText();
	}
	
	public String getTamaño(){
		return tamaño.getText();
	}
	
	public String getPrecio(){
		return precio.getText();
	}
	
	public String getCama(){
		return cama.getText();
	}
	
	public String getNumPersonas(){
		return numPersonas.getText();
	}

}
