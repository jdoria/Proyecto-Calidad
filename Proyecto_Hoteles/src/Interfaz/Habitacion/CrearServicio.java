package Interfaz.Habitacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CrearServicio extends JFrame {
	
	private JLabel anuncio;
	private JLabel descripcionServicio;
	private JTextField descripcion;
	private JButton crear;
	
	public CrearServicio() {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Ingeniería de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		anuncio = new JLabel("CREAR SERVICIO");
		anuncio.setBounds(130, 40, 150, 80);
		anuncio.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(anuncio);
		
		descripcionServicio = new JLabel("Descripcion");
		descripcionServicio.setBounds(60, 150, 120, 80);
		descripcionServicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(descripcionServicio);
		
		descripcion = new JTextField();
		descripcion.setBounds(180, 180, 150, 30);
		add(descripcion);
		
		crear = new JButton("Crear");
		crear.setBounds(150, 300, 100, 30);
		crear.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(crear);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		CrearServicio c = new CrearServicio();
	}
	
	public void buttonCrear(ActionListener l){
		crear.addActionListener(l);
	}
	
	public String getDescripcion(){
		return descripcion.getText();
	}

}
