package Interfaz.Agencia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;


import modelo.Agencia;
import modelo.Hotel;

public class ModificarHotel extends JFrame {
	
	private JLabel nombreHotel;
	private JTextField nombre;
	private JLabel telefonoHotel;
	private JTextField telefono;
	private JLabel direccionHotel;
	private JTextField direccion;
	private JLabel ciudadHotel;
	private JTextField ciudad;
	private JLabel paisHotel;
	private JTextField pais;
	private JLabel anuncio;
	private JButton modificar;
	private String telefonoPantalla;
	private Agencia agencia = new Agencia();
	private Hotel hotel;
	
	
	public ModificarHotel(Agencia agenciaPantalla, String nombreSeleccion) {
		// TODO Auto-generated constructor stub
		
		agencia = agenciaPantalla;
		
		for (int i = 0; i < agencia.getHoteles().size(); i++) {
			if(agencia.getHoteles().get(i).getNombre().equals(nombreSeleccion)){
				hotel = agencia.getHoteles().get(i);
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
		
		anuncio = new JLabel("MODIFICAR UN HOTEL");
		anuncio.setBounds(180, 80, 400, 100);
		anuncio.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(anuncio);
		
		nombreHotel = new JLabel("Nombre: ");
		nombreHotel.setBounds(100, 220, 100, 80);
		nombreHotel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(nombreHotel);
		
		nombre = new JTextField(hotel.getNombre());
		nombre.setBounds(250, 250, 150, 30);
		add(nombre);
		
		telefonoHotel = new JLabel("Teléfono: ");
		telefonoHotel.setBounds(100, 270, 100, 80);
		telefonoHotel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(telefonoHotel);
		
		telefono = new JTextField(telefonoPantalla = String.valueOf(hotel.getTelefono()));
		telefono.setBounds(250, 300, 150, 30);
		add(telefono);
		
		direccionHotel = new JLabel("Direccion: ");
		direccionHotel.setBounds(100, 320, 100, 80);
		direccionHotel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(direccionHotel);
		
		direccion = new JTextField(hotel.getDireccion());
		direccion.setBounds(250, 350, 150, 30);
		add(direccion);
		
		ciudadHotel = new JLabel("Ciudad: ");
		ciudadHotel.setBounds(100, 370, 100, 80);
		ciudadHotel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(ciudadHotel);
		
		ciudad = new JTextField(hotel.getCiudad());
		ciudad.setBounds(250, 400, 150, 30);
		add(ciudad);
		
		paisHotel = new JLabel("Pais: ");
		paisHotel.setBounds(100, 420, 100, 80);
		paisHotel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(paisHotel);
		
		pais = new JTextField(hotel.getPais());
		pais.setBounds(250, 450, 150, 30);
		add(pais);
		
		modificar = new JButton("Modificar");
		modificar.setBounds(250, 550, 130, 50);
		modificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(modificar);
		
		
		
		setVisible(true);
	}
	
	public void buttonModificar(ActionListener l){
		modificar.addActionListener(l);
	}
	
	public String getNombre(){
		return nombre.getText();
	}
	
	public String getTelefono(){
		return telefono.getText();
	}
	
	public String getDireccion(){
		return direccion.getText();
	}
	
	public String getCiudad(){
		return ciudad.getText();
	}
	
	public String getPais(){ 
		return pais.getText();
	}
}
