package Interfaz.Hotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dao.HotelDAO;
import dto.AgenciaDTO;
import dto.HabitacionDTO;
import dto.HotelDTO;

public class ModificarHabitacion extends JFrame {
	
	private JLabel tipoHabitacion;
	private JTextField tipo;
	private JLabel cantidadHabitacion;
	private JTextField cantidad;
	private JLabel camaHabitacion;
	private JTextField cama;
	private JLabel numPersonasHabitacion;
	private JTextField numPersonas;
	private JLabel precioHabitacion;
	private JTextField precio;
	private JLabel tamañoHabitacion;
	private JTextField tamaño;
	private JLabel anuncio;
	private String precioPantalla;
	private String cantidadPantalla;
	private String numPersonasPantalla;
	private JButton modificar;
	private HotelDTO hotel;
	private HabitacionDTO habitacion;
	private ArrayList<HabitacionDTO> habitaciones = new ArrayList<>();
	private HotelDAO hotelDAO = new HotelDAO();
	
	
	public ModificarHabitacion(String nombreSeleccion, int idHotel) {
		// TODO Auto-generated constructor stub
		
		habitaciones = hotelDAO.GetHabitaciones(idHotel);
		
		for(int i = 0; i<habitaciones.size();i++){
			if(habitaciones.get(i).getTipo().equals(nombreSeleccion)){
				habitacion = habitaciones.get(i);
				break;
			}
		}
		
		setTitle("Proyecto Ingeniería de Software I");
		setSize(600, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		anuncio = new JLabel("MODIFICAR UNA HABITACION");
		anuncio.setBounds(150, 80, 400, 100);
		anuncio.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(anuncio);
		
		tipoHabitacion = new JLabel("Tipo: ");
		tipoHabitacion.setBounds(90, 210, 100, 80);
		tipoHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(tipoHabitacion);
		
		tipo = new JTextField(habitacion.getTipo());
		tipo.setBounds(260, 240, 150, 30);
		add(tipo);
		
		cantidadHabitacion = new JLabel("Cantidad: ");
		cantidadHabitacion.setBounds(90, 260, 100, 80);
		cantidadHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(cantidadHabitacion);
		
		cantidad = new JTextField(cantidadPantalla = String.valueOf(habitacion.getCantidad()));
		cantidad.setBounds(260, 290, 150, 30);
		add(cantidad);
		
		camaHabitacion = new JLabel("Cama: ");
		camaHabitacion.setBounds(90, 310, 100, 80);
		camaHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(camaHabitacion);
		
		cama = new JTextField(habitacion.getCama());
		cama.setBounds(260, 340, 150, 30);
		add(cama);
		
		tamañoHabitacion = new JLabel("Tamaño: ");
		tamañoHabitacion.setBounds(90, 360, 100, 80);
		tamañoHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(tamañoHabitacion);
		
		tamaño = new JTextField(habitacion.getTamaño());
		tamaño.setBounds(260, 390, 150, 30);
		add(tamaño);
		
		precioHabitacion = new JLabel("Precio: ");
		precioHabitacion.setBounds(90, 410, 100, 80);
		precioHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(precioHabitacion);
		
		precio = new JTextField(precioPantalla = String.valueOf(habitacion.getPrecio()));
		precio.setBounds(260, 440, 150, 30);
		add(precio);
		
		numPersonasHabitacion = new JLabel("Número de personas: ");
		numPersonasHabitacion.setBounds(90, 460, 200, 80);
		numPersonasHabitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(numPersonasHabitacion);
		
		numPersonas = new JTextField(numPersonasPantalla = String.valueOf(habitacion.getNumPersonas()));
		numPersonas.setBounds(260, 490, 150, 30);
		add(numPersonas);
		
		modificar = new JButton("Modificar");
		modificar.setBounds(250, 550, 130, 50);
		modificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(modificar);
		
		
		setVisible(true);
		
	}
	
	public void buttonModificar(ActionListener l){
		modificar.addActionListener(l);
	}
	
	public String getTipo(){
		return tipo.getText();
	}
	
	public String getCantidad(){
		return cantidad.getText();
	}
	
	public String getCama(){
		return cama.getText();
	}
	
	public String getNumPersonas(){
		return numPersonas.getText();
	}
	
	public String getPrecio(){
		return precio.getText();
	}
	
	public String getTamaño(){
		return tamaño.getText();
	}
}
