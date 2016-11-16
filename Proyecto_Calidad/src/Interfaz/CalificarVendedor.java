package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CalificarVendedor extends JFrame implements ActionListener{

	private JLabel presentacion;
	private JLabel vendedor;
	private JButton ver;
	private String[] vendedores = {"vendedor 1", "vendedor 2", "vendedor 3", "vendedor 4", "vendedor 5"};
	private JComboBox lista2 = new JComboBox(vendedores);
	private JLabel msg1 = new JLabel();
	
	public CalificarVendedor() {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Electiva III");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		presentacion = new JLabel("Calificar Vendedores");
		presentacion.setBounds(100, 30, 220, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		vendedor = new JLabel("Vendedores");
		vendedor.setBounds(60, 100, 120, 30);
		vendedor.setFont(new Font("Tahoma",0, 15));
		add(vendedor);
		
		ver = new JButton("Ver Perfil");
		ver.setBounds(140, 300, 120, 30);
		ver.setFont(new Font("Tahoma", 0, 15));
		add(ver);
		
		lista2.setBounds(150, 100, 120, 30);
		lista2.setSelectedIndex(0);
		lista2.addActionListener(this);
		msg1.setBounds(150, 130, 120, 30);
		msg1.setFont(new Font("Tahoma", 0, 15));
		add(lista2);
		add(msg1);
		
		setVisible(true);
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == lista2){
			JComboBox cb = (JComboBox)e.getSource();
			String msg = (String)cb.getSelectedItem();
			switch(msg){
			case "vendedor 1": msg1.setText("Vendedor 1"); 
			break;
			case "vendedor 2": msg1.setText("Vendedor 2"); 
			break;
			case "vendedor 3": msg1.setText("Vendedor 3"); 
			break;
			case "vendedor 4": msg1.setText("Vendedor 4"); 
			break;
			case "vendedor 5": msg1.setText("Vendedor 5"); 
			break;
			default: msg1.setText("Error");
			}
		// TODO Auto-generated method stub
		
		}
	}

}
