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

import dao.VendedorDao;

public class SeleccionarVendedor extends JFrame implements ActionListener {
	
	private JLabel presentacion;
	private JLabel vendedor;
	private JButton asignar;
	private ArrayList<String> listaVendedores = new ArrayList<>();
	private JComboBox lista = new JComboBox();
	private DefaultComboBoxModel mlista = new DefaultComboBoxModel<>();
	private JLabel msg = new JLabel();
	private VendedorDao objetoVendedor = new VendedorDao();
	private String idVendedor;
	
	public SeleccionarVendedor() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Electiva III");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		for(int i = 0; i< objetoVendedor.GetVendedores().size();i++){
			listaVendedores.add(objetoVendedor.GetVendedores().get(i).getNombre());
			mlista.addElement(listaVendedores.get(i));
		}
		
		lista.setModel(mlista);
		
		presentacion = new JLabel("Seleccionar Vendedor");
		presentacion.setBounds(100, 30, 230, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		vendedor = new JLabel("Vendedores");
		vendedor.setBounds(60, 100, 120, 30);
		vendedor.setFont(new Font("Tahoma",0, 15));
		add(vendedor);
		
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
	
	public void buttonAsignar(ActionListener l){
		asignar.addActionListener(l);
	}
	
	public String getIdVendedor(){
		return idVendedor;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == lista){
			JComboBox cb = (JComboBox)e.getSource();
			String msgItem = (String)cb.getSelectedItem();
			for(int i=0; i<listaVendedores.size(); i++){
				if(listaVendedores.get(i).equals(msgItem)){
					msg.setText(objetoVendedor.GetVendedores().get(i).getNombre());
					idVendedor = objetoVendedor.GetVendedores().get(i).getIdVendedor();
				}
			}
			
		}
	}
	
	

}
