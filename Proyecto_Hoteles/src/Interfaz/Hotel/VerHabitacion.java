package Interfaz.Hotel;

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

import dao.HotelDAO;
import dto.HabitacionDTO;
import dto.HotelDTO;

public class VerHabitacion extends JFrame implements ActionListener{
	
	private JLabel presentacion;
	private JLabel habitacion;
	private JButton ver;
	private JLabel msg = new JLabel();
	private ArrayList<String> listaHabitaciones = new ArrayList<String>();
	private JComboBox lista = new JComboBox();
	private DefaultComboBoxModel mlista = new DefaultComboBoxModel();
	private HotelDTO hotel = new HotelDTO();
	private HotelDAO hotelDAO = new HotelDAO();
	private ArrayList<HabitacionDTO> habitaciones = new ArrayList<>();
	private int idHabitacion = 0;
	
	public VerHabitacion(int idHotel) {
		
		habitaciones = hotelDAO.GetHabitaciones(idHotel);
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		for (int i = 0; i < habitaciones.size(); i++) {
			listaHabitaciones.add(habitaciones.get(i).getTipo());
			mlista.addElement(listaHabitaciones.get(i));
		}
		
		lista.setModel(mlista);
		
		presentacion = new JLabel("Ver Habitaciones");
		presentacion.setBounds(130, 40, 150, 80);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(presentacion);
		
		habitacion = new JLabel("Habitacion"); 
		habitacion.setBounds(55, 120, 120, 80);
		habitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(habitacion);
		
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
	
	public String getHabitacion(){
		return msg.getText();
	}
	
	public int getIdHabitacion(){
		return idHabitacion;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lista){
			JComboBox cb = (JComboBox)e.getSource();
			String msg1 = (String)cb.getSelectedItem();
			for(int i=0; i<listaHabitaciones.size(); i++){
				if(listaHabitaciones.get(i).equals(msg1)){
					msg.setText(habitaciones.get(i).getTipo());
					idHabitacion = habitaciones.get(i).getIdHabitacion();
				}
			}
			
		}
		
	}


}
