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

import dao.LineaDao;
import dao.VendedorDao;

public class AsignarLineas extends JFrame implements ActionListener{
	
	private JLabel presentacion;
	private JLabel vendedor;
	private JLabel linea;
	private JButton asignar;
	private ArrayList<String> listaLineas = new ArrayList<>();
	private JComboBox lista1 = new JComboBox();
	private ArrayList<String> listaVendedores = new ArrayList<>();
	private JComboBox lista2 = new JComboBox();
	private DefaultComboBoxModel mlista1 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel mlista2 = new DefaultComboBoxModel<>();
	private JLabel msg1 = new JLabel();
	private JLabel msg2 = new JLabel();
	private LineaDao objetoLinea = new LineaDao();
	private VendedorDao objetoVendedor = new VendedorDao();
	private String idVendedor;
	
	
	public AsignarLineas() {
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
		
		for(int i = 0; i< objetoVendedor.GetVendedores().size();i++){
			listaVendedores.add(objetoVendedor.GetVendedores().get(i).getNombre());
			mlista2.addElement(listaVendedores.get(i));
		}
		
		lista1.setModel(mlista1);
		lista2.setModel(mlista2);
		
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
		asignar.setActionCommand("asignar");
		add(asignar);
		
		lista1.setBounds(150, 200, 120, 30);
		lista1.setSelectedIndex(0);
		lista1.addActionListener(this);
		msg1.setBounds(150, 230, 120, 30);
		msg1.setFont(new Font("Tahoma", 0, 15));
		add(lista1);
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
	
	public void buttonAsignar(ActionListener l){
		asignar.addActionListener(l);
	}
	
	public String getLinea(){
		return msg1.getText();
	}
	
	public String getIdVendedor(){
		return idVendedor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lista1){
			JComboBox cb = (JComboBox)e.getSource();
			String msg = (String)cb.getSelectedItem();
			for(int i=0; i<listaLineas.size(); i++){
				if(listaLineas.get(i).equals(msg)){
					msg1.setText(objetoLinea.GetLineas().get(i).getNombre());
				}
			}
			
		}else if(e.getSource() == lista2){
			JComboBox cb = (JComboBox)e.getSource();
			String msg = (String)cb.getSelectedItem();
			for(int i=0; i<listaVendedores.size(); i++){
				if(listaVendedores.get(i).equals(msg)){
					msg2.setText(objetoVendedor.GetVendedores().get(i).getNombre());
					idVendedor = objetoVendedor.GetVendedores().get(i).getIdVendedor();
				}
			}
			
		}
	}

}
