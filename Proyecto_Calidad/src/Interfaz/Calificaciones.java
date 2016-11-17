package Interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.LineaDao;

public class Calificaciones extends JFrame{
	
	private JLabel presentacion;
	private JLabel linea1;
	private JLabel linea2;
	private JLabel linea3;
	private JLabel linea4;
	private JLabel linea5;
	private JLabel calificacion1;
	private JLabel calificacion2;
	private JLabel calificacion3;
	private JLabel calificacion4;
	private JLabel calificacion5;
	private LineaDao lineas;
	
	
	public Calificaciones() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Electiva III");
		setSize(600, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		presentacion = new JLabel("Calificaciones");
		presentacion.setBounds(230, 30, 150, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		linea1 = new JLabel("Linea 1");
		linea1.setBounds(120, 100, 100, 30);
		linea1.setFont(new Font("Tahoma", 0, 15));
		add(linea1);
		
		linea2 = new JLabel("Linea 2");
		linea2.setBounds(120, 150, 100, 30);
		linea2.setFont(new Font("Tahoma", 0, 15));
		add(linea2);
		
		linea3 = new JLabel("Linea 3");
		linea3.setBounds(120, 200, 100, 30);
		linea3.setFont(new Font("Tahoma", 0, 15));
		add(linea3);
		
		linea4 = new JLabel("Linea 4");
		linea4.setBounds(120, 250, 100, 30);
		linea4.setFont(new Font("Tahoma", 0, 15));
		add(linea4);
		
		linea5 = new JLabel("Linea 5");
		linea5.setBounds(120, 300, 100, 30);
		linea5.setFont(new Font("Tahoma", 0, 15));
		add(linea5);
		
		calificacion1 = new JLabel("Calificacion:");
		calificacion1.setBounds(300, 100, 150, 30);
		calificacion1.setFont(new Font("Tahoma",0 , 15));
		add(calificacion1);
		
		calificacion2 = new JLabel("Calificacion:");
		calificacion2.setBounds(300, 150, 150, 30);
		calificacion2.setFont(new Font("Tahoma",0 , 15));
		add(calificacion2);
		
		calificacion3 = new JLabel("Calificacion:");
		calificacion3.setBounds(300, 200, 150, 30);
		calificacion3.setFont(new Font("Tahoma",0 , 15));
		add(calificacion3);
		
		calificacion4 = new JLabel("Calificacion:");
		calificacion4.setBounds(300, 250, 150, 30);
		calificacion4.setFont(new Font("Tahoma",0 , 15));
		add(calificacion4);
		
		calificacion5 = new JLabel("Calificacion:");
		calificacion5.setBounds(300, 300, 150, 30);
		calificacion5.setFont(new Font("Tahoma",0 , 15));
		add(calificacion5);
		
		setVisible(true);
		
	}
	
	
}

