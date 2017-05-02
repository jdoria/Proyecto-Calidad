package Interfaz.Agencia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dao.AgenciaDAO;
import dto.AgenciaDTO;
import dto.HotelDTO;

public class VerHotel extends JFrame implements ActionListener{
	
	private JLabel presentacion;
	private JLabel hotel;
	private JButton ver;
	private JLabel msg = new JLabel();
	private ArrayList<String> listaHoteles = new ArrayList<String>();
	private JComboBox lista = new JComboBox();
	private DefaultComboBoxModel mlista = new DefaultComboBoxModel();
	private ArrayList<HotelDTO> hoteles;
	private AgenciaDAO agenciaDAO = new AgenciaDAO();
	private int idHotel = 0;
	
	public VerHotel() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		hoteles = new ArrayList<>();
		hoteles = agenciaDAO.GetHoteles();
		
		System.out.println(hoteles.size());
		
		for (int i = 0; i < hoteles.size(); i++) {
			listaHoteles.add(hoteles.get(i).getNombre());
			mlista.addElement(listaHoteles.get(i));
		}
		
		lista.setModel(mlista);
		
		presentacion = new JLabel("Ver Hoteles");
		presentacion.setBounds(150, 40, 120, 80);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(presentacion);
		
		hotel = new JLabel("Hotel"); 
		hotel.setBounds(100, 120, 120, 80);
		hotel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(hotel);
		
		lista.setBounds(150, 150, 120, 30);
		//lista.setSelectedIndex(0);
		lista.addActionListener(this);
		msg.setBounds(150, 180, 120, 30);
		msg.setFont(new Font("Tahoma", 0, 15));
		add(lista);
		add(msg);
		
		ver = new JButton("Ver");
		ver.setBounds(160, 250, 80, 30);
		ver.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(ver);
		
		
		setVisible(true);
	}
	
	
	
	public void buttonVer(ActionListener l){
		ver.addActionListener(l);
	}
	
	public String getNombreHotel(){
		return msg.getText();
	}
	
	public int getIdHotel(){
		return idHotel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lista){
			JComboBox cb = (JComboBox)e.getSource();
			String msg1 = (String)cb.getSelectedItem();
			for(int i=0; i<listaHoteles.size(); i++){
				if(listaHoteles.get(i).equals(msg1)){
					msg.setText(hoteles.get(i).getNombre());
					idHotel = hoteles.get(i).getIdHotel();
				}
			}
			
		}
		
	}
	
}
