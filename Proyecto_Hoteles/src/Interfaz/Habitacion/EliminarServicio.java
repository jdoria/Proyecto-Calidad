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

import dto.HabitacionDTO;

public class EliminarServicio extends JFrame implements ActionListener{
	
	private JLabel presentacion;
	private JLabel servicio;
	private JButton eliminar;
	private JLabel msg = new JLabel();
	private ArrayList<String> listaServicios = new ArrayList<String>();
	private JComboBox lista = new JComboBox();
	private DefaultComboBoxModel mlista = new DefaultComboBoxModel();
	private HabitacionDTO habitacion = new HabitacionDTO();
	
	public EliminarServicio(HabitacionDTO habitacionPantalla) {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Ingeniería de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		habitacion = habitacionPantalla;

		for (int i = 0; i < habitacion.getServicios().size(); i++) {
			listaServicios.add(habitacion.getServicios().get(i).getDescripcion());
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

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(140, 250, 120, 30);
		eliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(eliminar);

		setVisible(true);

	}

	public void buttonVer(ActionListener l) {
		eliminar.addActionListener(l);
	}

	public String getServicio() {
		return msg.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lista) {
			JComboBox cb = (JComboBox) e.getSource();
			String msg1 = (String) cb.getSelectedItem();
			for (int i = 0; i < listaServicios.size(); i++) {
				if (listaServicios.get(i).equals(msg1)) {
					msg.setText(habitacion.getServicios().get(i).getDescripcion());
				}
			}

		}

	
	}


}
