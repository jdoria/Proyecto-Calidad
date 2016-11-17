package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.LineaDao;

@SuppressWarnings("serial")
public class CalificacionesAdmin extends JFrame implements ActionListener {
	
	private JLabel presentacion;
	private JLabel linea1;
	private JLabel linea2;
	private JLabel linea3;
	private JLabel linea4;
	private JLabel linea5;
	private JTextField cuadro1;
	private JTextField cuadro2;
	private JTextField cuadro3;
	private JTextField cuadro4;
	private JTextField cuadro5;
	private JLabel calificacion1;
	private JLabel calificacion2;
	private JLabel calificacion3;
	private JLabel calificacion4;
	private JLabel calificacion5;
	private ArrayList<String> listaLineas1 = new ArrayList<>();
	private DefaultComboBoxModel mlista1 = new DefaultComboBoxModel<>();
	private JComboBox lista1 = new JComboBox();
	private JLabel msg1 = new JLabel();
	private ArrayList<String> listaLineas2 = new ArrayList<>();
	private DefaultComboBoxModel mlista2 = new DefaultComboBoxModel<>();
	private JComboBox lista2 = new JComboBox();
	private JLabel msg2 = new JLabel();
	private ArrayList<String> listaLineas3 = new ArrayList<>();
	private DefaultComboBoxModel mlista3 = new DefaultComboBoxModel<>();
	private JComboBox lista3 = new JComboBox();
	private JLabel msg3 = new JLabel();
	private ArrayList<String> listaLineas4 = new ArrayList<>();
	private DefaultComboBoxModel mlista4 = new DefaultComboBoxModel<>();
	private JComboBox lista4 = new JComboBox();
	private JLabel msg4 = new JLabel();
	private ArrayList<String> listaLineas5 = new ArrayList<>();
	private DefaultComboBoxModel mlista5 = new DefaultComboBoxModel<>();
	private JComboBox lista5 = new JComboBox();
	private JLabel msg5 = new JLabel();
	private LineaDao objetoLinea = new LineaDao();
	
	
	
	public CalificacionesAdmin(String idVendedor) {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Electiva III");
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(int i = 0; i< objetoLinea.GetLineas().size();i++){
			listaLineas1.add(objetoLinea.getLineaVendedor(idVendedor).get(i).getNombre());
			mlista1.addElement(listaLineas1.get(i));
		}
		
		lista1.setModel(mlista1);
		
		for(int i = 0; i< objetoLinea.GetLineas().size();i++){
			listaLineas2.add(objetoLinea.getLineaVendedor(idVendedor).get(i).getNombre());
			mlista2.addElement(listaLineas2.get(i));
		}
		
		lista2.setModel(mlista2);
		
		for(int i = 0; i< objetoLinea.GetLineas().size();i++){
			listaLineas3.add(objetoLinea.getLineaVendedor(idVendedor).get(i).getNombre());
			mlista3.addElement(listaLineas3.get(i));
		}
		
		lista3.setModel(mlista3);
		
		for(int i = 0; i< objetoLinea.GetLineas().size();i++){
			listaLineas4.add(objetoLinea.getLineaVendedor(idVendedor).get(i).getNombre());
			mlista4.addElement(listaLineas4.get(i));
		}
		
		lista4.setModel(mlista4);
		
		for(int i = 0; i< objetoLinea.GetLineas().size();i++){
			listaLineas5.add(objetoLinea.getLineaVendedor(idVendedor).get(i).getNombre());
			mlista5.addElement(listaLineas5.get(i));
		}
		
		lista5.setModel(mlista5);
		
		presentacion = new JLabel("Calificaciones");
		presentacion.setBounds(230, 30, 150, 30);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		linea1 = new JLabel("Linea 1");
		linea1.setBounds(70, 100, 100, 30);
		linea1.setFont(new Font("Tahoma", 0, 15));
		add(linea1);
		
		linea2 = new JLabel("Linea 2");
		linea2.setBounds(70, 200, 100, 30);
		linea2.setFont(new Font("Tahoma", 0, 15));
		add(linea2);
		
		linea3 = new JLabel("Linea 3");
		linea3.setBounds(70, 300, 100, 30);
		linea3.setFont(new Font("Tahoma", 0, 15));
		add(linea3);
		
		linea4 = new JLabel("Linea 4");
		linea4.setBounds(70, 400, 100, 30);
		linea4.setFont(new Font("Tahoma", 0, 15));
		add(linea4);
		
		linea5 = new JLabel("Linea 5");
		linea5.setBounds(70, 500, 100, 30);
		linea5.setFont(new Font("Tahoma", 0, 15));
		add(linea5);
		
		calificacion1 = new JLabel("Calificacion:");
		calificacion1.setBounds(300, 100, 150, 30);
		calificacion1.setFont(new Font("Tahoma",0 , 15));
		add(calificacion1);
		
		cuadro1 = new JTextField();
		cuadro1.setBounds(400, 100, 150, 30);
		add(cuadro1);
		
		
		calificacion2 = new JLabel("Calificacion:");
		calificacion2.setBounds(300, 200, 150, 30);
		calificacion2.setFont(new Font("Tahoma",0 , 15));
		add(calificacion2);
		
		cuadro2 = new JTextField();
		cuadro2.setBounds(400, 200, 150, 30);
		add(cuadro2);
		
		calificacion3 = new JLabel("Calificacion:");
		calificacion3.setBounds(300, 300, 150, 30);
		calificacion3.setFont(new Font("Tahoma",0 , 15));
		add(calificacion3);
		
		cuadro3 = new JTextField();
		cuadro3.setBounds(400, 300, 150, 30);
		add(cuadro3);
		
		calificacion4 = new JLabel("Calificacion:");
		calificacion4.setBounds(300, 400, 150, 30);
		calificacion4.setFont(new Font("Tahoma",0 , 15));
		add(calificacion4);
		
		cuadro4 = new JTextField();
		cuadro4.setBounds(400, 400, 150, 30);
		add(cuadro4);
		
		calificacion5 = new JLabel("Calificacion:");
		calificacion5.setBounds(300, 500, 150, 30);
		calificacion5.setFont(new Font("Tahoma",0 , 15));
		add(calificacion5);
		
		cuadro5 = new JTextField();
		cuadro5.setBounds(400, 500, 150, 30);
		add(cuadro5);
		
		lista1.setBounds(130, 100, 120, 30);
		lista1.setSelectedIndex(0);
		lista1.addActionListener(this);
		msg1.setBounds(130, 130, 120, 30);
		msg1.setFont(new Font("Tahoma", 0, 15));
		add(lista1);
		add(msg1);
		
		lista2.setBounds(130, 200, 120, 30);
		lista2.setSelectedIndex(0);
		lista2.addActionListener(this);
		msg2.setBounds(130, 230, 120, 30);
		msg2.setFont(new Font("Tahoma", 0, 15));
		add(lista2);
		add(msg2);
		
		lista3.setBounds(130, 300, 120, 30);
		lista3.setSelectedIndex(0);
		lista3.addActionListener(this);
		msg3.setBounds(130, 330, 120, 30);
		msg3.setFont(new Font("Tahoma", 0, 15));
		add(lista3);
		add(msg3);
		
		lista4.setBounds(130, 400, 120, 30);
		lista4.setSelectedIndex(0);
		lista4.addActionListener(this);
		msg4.setBounds(130, 430, 120, 30);
		msg4.setFont(new Font("Tahoma", 0, 15));
		add(lista4);
		add(msg4);
		
		lista5.setBounds(130, 500, 120, 30);
		lista5.setSelectedIndex(0);
		lista5.addActionListener(this);
		msg5.setBounds(130, 530, 120, 30);
		msg5.setFont(new Font("Tahoma", 0, 15));
		add(lista5);
		add(msg5);
		
		
		setVisible(true);
		
	}
	
	public static void main(String[] args){
		CalificacionesAdmin p = new CalificacionesAdmin("111613");
	}
	
	/**
	 * Manejo de eventos
	 */
	
	public String getCuadro1(){
		return cuadro1.getText();
	}
	
	public String getCuadro2(){
		return cuadro2.getText();
	}
	
	public String getCuadro3(){
		return cuadro3.getText();
	}
	
	public String getCuadro4(){
		return cuadro4.getText();
	}
	
	public String getCuadro5(){
		return cuadro5.getText();
	}
	
	public String getLinea1(){
		return msg1.getText();
	}
	
	public String getLinea2(){
		return msg2.getText();
	}
	
	public String getLinea3(){
		return msg3.getText();
	}
	
	public String getLinea4(){
		return msg4.getText();
	}
	
	public String getLinea5(){
		return msg5.getText();
	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lista1){
			JComboBox cb = (JComboBox)e.getSource();
			String msgItem = (String)cb.getSelectedItem();
			for(int i=0; i<listaLineas1.size(); i++){
				if(listaLineas1.get(i).equals(msgItem)){
					msg1.setText(objetoLinea.GetLineas().get(i).getNombre());
				}
			}
			
			
		}else if(e.getSource() == lista2){
			JComboBox cb = (JComboBox)e.getSource();
			String msgItem = (String)cb.getSelectedItem();
			for(int i=0; i<listaLineas2.size();i++){
				if(listaLineas2.get(i).equals(msgItem)){
					msg2.setText(objetoLinea.GetLineas().get(i).getNombre());
				}
			}
		}else if(e.getSource() == lista3){
			JComboBox cb = (JComboBox)e.getSource();
			String msgItem = (String)cb.getSelectedItem();
			for(int i=0; i<listaLineas3.size();i++){
				if(listaLineas3.get(i).equals(msgItem)){
					msg3.setText(objetoLinea.GetLineas().get(i).getNombre());
				}
			}
		}else if(e.getSource() == lista4){
			JComboBox cb = (JComboBox)e.getSource();
			String msgItem = (String)cb.getSelectedItem();
			for(int i=0; i<listaLineas4.size();i++){
				if(listaLineas4.get(i).equals(msgItem)){
					msg4.setText(objetoLinea.GetLineas().get(i).getNombre());
				}
			}
		}else if(e.getSource() == lista5){
			JComboBox cb = (JComboBox)e.getSource();
			String msgItem = (String)cb.getSelectedItem();
			for(int i=0; i<listaLineas5.size();i++){
				if(listaLineas5.get(i).equals(msgItem)){
					msg5.setText(objetoLinea.GetLineas().get(i).getNombre());
				}
			}
		}




		
	}
	
	
}
