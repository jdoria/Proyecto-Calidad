package Interfaz.Habitacion;

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

import dao.HabitacionDAO;
import dto.HabitacionDTO;
import dto.HotelDTO;
import dto.ServicioDTO;

public class VerServicios extends JFrame implements ActionListener {

	private JLabel presentacion;
	private JLabel servicio;
	private JButton ver;
	private JLabel msg = new JLabel();
	private ArrayList<String> listaServicios = new ArrayList<String>();
	private JComboBox lista = new JComboBox();
	private DefaultComboBoxModel mlista = new DefaultComboBoxModel();
	private ArrayList<ServicioDTO> servicios = new ArrayList<>();
	private HabitacionDAO habitacionDAO = new HabitacionDAO();
	private int idServicio = 0;
		
	public VerServicios(int idHabitacion) {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Ingeniería de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		servicios = habitacionDAO.GetServicios(idHabitacion);

		for (int i = 0; i < servicios.size(); i++) {
			listaServicios.add(servicios.get(i).getDescripcion());
			mlista.addElement(listaServicios.get(i));
		}

		lista.setModel(mlista);

		presentacion = new JLabel("Ver Servicios");
		presentacion.setBounds(130, 40, 150, 80);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(presentacion);

		servicio = new JLabel("Servicio");
		servicio.setBounds(55, 120, 120, 80);
		servicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(servicio);

		lista.setBounds(150, 150, 120, 30);
		// lista.setSelectedIndex(0);
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

	public void buttonVer(ActionListener l) {
		ver.addActionListener(l);
	}

	public String getServicio() {
		return msg.getText();
	}

	public int getIdServicio(){
		return idServicio;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lista) {
			JComboBox cb = (JComboBox) e.getSource();
			String msg1 = (String) cb.getSelectedItem();
			for (int i = 0; i < listaServicios.size(); i++) {
				if (listaServicios.get(i).equals(msg1)) {
					msg.setText(servicios.get(i).getDescripcion());
					idServicio = servicios.get(i).getIdServicio();
				}
			}

		}

	}

}
