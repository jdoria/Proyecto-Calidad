package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AsignarPuntos extends JFrame implements ActionListener{
	
	private JLabel presentacion;
	private JLabel linea;
	private JLabel puntos;
	private JTextField numPuntos;
	private JButton asignar;
	private String[] lineas = {"linea 1", "linea 2", "linea 3", "linea 4", "linea 5"};
	private JComboBox lista = new JComboBox(lineas);
	private JLabel msg = new JLabel();
	
	public AsignarPuntos() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Electiva III");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		presentacion = new JLabel("Asignación de Puntos");
		presentacion.setBounds(100, 30, 220, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		linea = new JLabel("Linea");
		linea.setBounds(60, 100, 120, 30);
		linea.setFont(new Font("Tahoma", 0, 15));
		add(linea);
		
		puntos = new JLabel("Puntos");
		puntos.setBounds(60, 160, 100, 30);
		puntos.setFont(new Font("Tahoma",0,15));
		add(puntos);
		
		numPuntos = new JTextField();
		numPuntos.setBounds(150, 160, 150, 30);
		add(numPuntos);
		
		asignar = new JButton("Asignar");
		asignar.setBounds(140, 300, 120, 30);
		asignar.setFont(new Font("Tahoma", 0, 15));
		add(asignar);
		
		lista.setBounds(150, 100, 120, 30);
		lista.setSelectedIndex(0);
		lista.addActionListener(this);
		msg.setBounds(150, 130, 120, 30);
		msg.setFont(new Font("Tahoma", 0, 15));
		add(lista);
		add(msg);
		
		setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lista){
			JComboBox cb = (JComboBox)e.getSource();
			String msg1 = (String)cb.getSelectedItem();
			switch(msg1){
			case "linea 1": msg.setText("Linea 1"); 
			break;
			case "linea 2": msg.setText("Linea 2"); 
			break;
			case "linea 3": msg.setText("Linea 3"); 
			break;
			case "linea 4": msg.setText("Linea 4"); 
			break;
			case "linea 5": msg.setText("Linea 5"); 
			break;
			default: msg.setText("Error");
			}
			
		}

		
	}
	

}
