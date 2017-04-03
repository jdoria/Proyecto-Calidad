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

public class EvaluarVendedores extends JFrame implements ActionListener {
	
	private JLabel presentacion;
	private JLabel vendedor;
	private JButton evaluar;
	private JLabel promedio;
	private ArrayList<String> listaVendedores = new ArrayList<>();
	private JComboBox lista1 = new JComboBox();
	private DefaultComboBoxModel mlista1 = new DefaultComboBoxModel<>();
	private JLabel msg1 = new JLabel();
	private VendedorDao objetoVendedor = new VendedorDao();
	private String idVendedor;
	
	public EvaluarVendedores() {
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
			mlista1.addElement(listaVendedores.get(i));
		}
		
		lista1.setModel(mlista1);
		
		presentacion = new JLabel("Evaluar Vendedores");
		presentacion.setBounds(100, 30, 220, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		vendedor = new JLabel("Vendedor:");
		vendedor.setBounds(70, 150, 150, 30);
		vendedor.setFont(new Font("Tahoma", 0, 15));
		add(vendedor);
		
		promedio = new JLabel("Promedio: ");
		promedio.setBounds(70,200,150,30);
		promedio.setFont(new Font("Tahoma",0,15));
		add(promedio);
		
		evaluar = new JButton("Evaluar");
		evaluar.setBounds(140, 300, 120, 30);
		evaluar.setFont(new Font("Tahoma", 0, 15));
		evaluar.setActionCommand("evaluar");
		add(evaluar);
		
		lista1.setBounds(150, 150, 120, 30);
		lista1.setSelectedIndex(0);
		lista1.addActionListener(this);
		msg1.setBounds(150, 180, 120, 30);
		msg1.setFont(new Font("Tahoma", 0, 15));
		add(lista1);
		add(msg1);
		
		setVisible(true);
		
	}
	
	public String getIdVendedor(){
		return idVendedor;
	}
	
	public void setTextPromedio(String str) {
		promedio.setText(str);
	}
	
	public void buttonEvaluar(ActionListener l){
		evaluar.addActionListener(l);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lista1){
			JComboBox cb = (JComboBox)e.getSource();
			String msg = (String)cb.getSelectedItem();
			for(int i=0; i<listaVendedores.size(); i++){
				if(listaVendedores.get(i).equals(msg)){
					msg1.setText(objetoVendedor.GetVendedores().get(i).getNombre());
					idVendedor = objetoVendedor.GetVendedores().get(i).getIdVendedor();
				}
			}
		
	}
	}
}
