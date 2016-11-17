package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.LineaDao;

public class AsignarPuntos extends JFrame implements ActionListener{
	
	private JLabel presentacion;
	private JLabel linea;
	private JLabel puntos;
	private JTextField numPuntos;
	private JButton asignar;
	private ArrayList<String> listaLineas = new ArrayList<>();
	private DefaultComboBoxModel mlista1 = new DefaultComboBoxModel<>();
	private JComboBox lista = new JComboBox();
	private JLabel msg = new JLabel();
	private LineaDao objetoLinea = new LineaDao();
	
	public AsignarPuntos() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Electiva III");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		for(int i = 0; i< objetoLinea.GetLineas().size();i++){
			listaLineas.add(objetoLinea.GetLineas().get(i).getNombre());
			mlista1.addElement(listaLineas.get(i));
		}
		
		lista.setModel(mlista1);
		
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
		asignar.setActionCommand("asignar");
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
	
	
	public String getPuntos(){
		return numPuntos.getText();
	}
	
	public String getLinea(){
		return msg.getText();
	}
	
	public void buttonAsignar(ActionListener l){
		asignar.addActionListener(l);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lista){
			JComboBox cb = (JComboBox)e.getSource();
			String msg1 = (String)cb.getSelectedItem();
			for(int i=0; i<listaLineas.size(); i++){
				if(listaLineas.get(i).equals(msg1)){
					msg.setText(objetoLinea.GetLineas().get(i).getNombre());
				}
			}
			
			
		}

		
	}
	

}
