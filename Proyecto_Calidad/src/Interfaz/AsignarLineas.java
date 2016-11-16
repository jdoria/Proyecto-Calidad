package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AsignarLineas extends JFrame implements ActionListener{
	
	private JLabel presentacion;
	private JLabel vendedor;
	private JLabel linea;
	private JButton asignar;
	private String[] lineas = {"linea 1", "linea 2", "linea 3", "linea 4", "linea 5"};
	private JComboBox lista = new JComboBox(lineas);
	private String[] vendedores = {"vendedor 1", "vendedor 2", "vendedor 3", "vendedor 4", "vendedor 5"};
	private JComboBox lista2 = new JComboBox(vendedores);
	private JLabel msg1 = new JLabel();
	private JLabel msg2 = new JLabel();
	
	
	public AsignarLineas() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Electiva III");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		presentacion = new JLabel("Asignación de Lineas");
		presentacion.setBounds(100, 30, 220, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		vendedor = new JLabel("Vendedores");
		vendedor.setBounds(60, 100, 120, 30);
		vendedor.setFont(new Font("Tahoma",0, 15));
		add(vendedor);
		
		linea = new JLabel("Linea");
		linea.setBounds(60, 200, 120, 30);
		linea.setFont(new Font("Tahoma", 0, 15));
		add(linea);
		
		asignar = new JButton("Asignar");
		asignar.setBounds(140, 300, 120, 30);
		asignar.setFont(new Font("Tahoma", 0, 15));
		add(asignar);
		
		lista.setBounds(150, 200, 120, 30);
		lista.setSelectedIndex(0);
		lista.addActionListener(this);
		msg1.setBounds(150, 230, 120, 30);
		msg1.setFont(new Font("Tahoma", 0, 15));
		add(lista);
		add(msg1);
		
		lista2.setBounds(150, 100, 120, 30);
		lista2.setSelectedIndex(0);
		lista2.addActionListener(this);
		msg2.setBounds(150, 130, 120, 30);
		msg2.setFont(new Font("Tahoma", 0, 15));
		add(lista2);
		add(msg2);
		
		setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lista){
			JComboBox cb = (JComboBox)e.getSource();
			String msg = (String)cb.getSelectedItem();
			switch(msg){
			case "linea 1": msg1.setText("Linea 1"); 
			break;
			case "linea 2": msg1.setText("Linea 2"); 
			break;
			case "linea 3": msg1.setText("Linea 3"); 
			break;
			case "linea 4": msg1.setText("Linea 4"); 
			break;
			case "linea 5": msg1.setText("Linea 5"); 
			break;
			default: msg1.setText("Error");
			}
			
		}
		
	}

}
