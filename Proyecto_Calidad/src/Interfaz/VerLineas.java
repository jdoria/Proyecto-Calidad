package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.LineaDao;
import dto.Linea;

@SuppressWarnings("serial")
public class VerLineas extends JFrame {

	private JLabel presentacion;
	private JTable tabla;
	private String[] cabecera = {"idLinea", "Marca", "Nombre", "Código", "Numéro de Puntos"};
	private String[][] datos;
	private JScrollPane js;
	private LineaDao lineas1 = new LineaDao();

	
	
	
	public VerLineas() {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Electiva III");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		presentacion = new JLabel("Lineas del almacen");
		presentacion.setBounds(300, 20, 200, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		setTabla();
		setVisible(true);
		
	}
	
	public void setTabla(){
		tabla = new JTable(datos, cabecera);
		js = new JScrollPane(tabla);
		//js.setBounds(300, 200, 500, 100);
		js.setPreferredSize(new Dimension(600,400));
		add(js);
	}
}
