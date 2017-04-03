package Interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import modelo.Hotel;

public class VistaCliente extends JFrame {
	private int y1 = 50;
	private int y2 = 50;
	private int y3 = 90;
	private int y =  0;
	private JLabel habitacion;
	private JLabel servicio;
	private JLabel tipo;
	private JLabel cantidad;
	private JLabel cama;
	private JLabel tamaño;
	private JLabel precio;
	private JLabel numPersonas; 
	private JLabel tipoHabitacion;
	private JLabel cantidadHabitacion;
	private JLabel camaHabitacion;
	private JLabel tamañoHabitacion;
	private JLabel precioHabitacion;
	private JLabel numPersonasHabitacion; 
	private JLabel serviciosHabitacion;
	private String cantidadPantalla;
	private String precioPantalla;
	private String numPersonasPantalla;
	private int precio1;
	
	
	public VistaCliente(Hotel hotel) {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
			precio1 = hotel.getHabitaciones().get(i).getPrecio();
			precio1 = (int) ((precio1*0.3)+precio1);
			precio1 = (int) ((precio1*0.1)+precio1);
			habitacion = new JLabel("Habitacion. ");
			habitacion.setBounds(100, y=y+50, 150,30);
			habitacion.setFont(new Font("Tahoma", Font.BOLD, 17));
			add(habitacion);
			tipo = new JLabel("Tipo: ");
			tipo.setBounds(70, y=y+60, 100, 30);
			tipo.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(tipo);
			cantidad = new JLabel("Cantidad: ");
			cantidad.setBounds(70, y=y+20, 100, 30);
			cantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(cantidad);
			cama = new JLabel("Cama: ");
			cama.setBounds(70, y=y+20, 100, 30);
			cama.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(cama);
			tamaño = new JLabel("Tamaño: ");
			tamaño.setBounds(70, y=y+20, 100, 30);
			tamaño.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(tamaño);
			precio = new JLabel("Precio: ");
			precio.setBounds(70, y=y+20, 100, 30);
			precio.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(precio);
			numPersonas = new JLabel("Personas: ");
			numPersonas.setBounds(70, y=y+20, 100, 30);
			numPersonas.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(numPersonas);
			tipoHabitacion = new JLabel(hotel.getHabitaciones().get(i).getTipo());
			tipoHabitacion.setBounds(170, y1=y1+60, 100, 30);
			tipoHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(tipoHabitacion);
			cantidadHabitacion = new JLabel(cantidadPantalla = String.valueOf(hotel.getHabitaciones().get(i).getCantidad()));
			cantidadHabitacion.setBounds(170, y1=y1+20, 100, 30);
			cantidadHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(cantidadHabitacion);
			camaHabitacion = new JLabel(hotel.getHabitaciones().get(i).getCama());
			camaHabitacion.setBounds(170, y1=y1+20, 100, 30);
			camaHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(camaHabitacion);
			tamañoHabitacion = new JLabel(hotel.getHabitaciones().get(i).getTamaño());
			tamañoHabitacion.setBounds(170, y1=y1+20, 100, 30);
			tamañoHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(tamañoHabitacion);
			precioHabitacion = new JLabel(precioPantalla = String.valueOf(precio1));
			precioHabitacion.setBounds(170, y1=y1+20, 100, 30);
			precioHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(precioHabitacion);
			numPersonasHabitacion = new JLabel(numPersonasPantalla = String.valueOf(hotel.getHabitaciones().get(i).getNumPersonas()));
			numPersonasHabitacion.setBounds(170, y1=y1+20, 100, 30);
			numPersonasHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(numPersonasHabitacion);
			y1 = y1+50;
			servicio = new JLabel("Servicios. ");
			servicio.setBounds(400, y2, 150, 30);
			servicio.setFont(new Font("Tahoma", Font.BOLD, 17));
			add(servicio);
			y2 = y2+210;
			for (int j = 0; j < hotel.getHabitaciones().get(i).getServicios().size(); j++) {
				serviciosHabitacion = new JLabel(hotel.getHabitaciones().get(i).getServicios().get(j).getDescripcion());
				serviciosHabitacion.setBounds(400, y3=y3+20, 200, 30);
				serviciosHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
				add(serviciosHabitacion);
			}
			y3 = y2+40;
		}
		
		setVisible(true);
	}

}
