package Interfaz.Habitacion;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.HabitacionDAO;
import dto.HabitacionDTO;
import dto.ServicioDTO;

public class MostrarServicio extends JFrame {
	
	private JLabel anuncio;
	private JLabel descripcionServicio;
	private JLabel descripcion;
	private JButton modificar;
	private ServicioDTO servicio;
	private ArrayList<ServicioDTO> servicios = new ArrayList<>();
	private HabitacionDAO habitacionDAO = new HabitacionDAO();
	
	public MostrarServicio(String nombreSeleccion, int idHabitacion) {
		// TODO Auto-generated constructor stub
		servicios = habitacionDAO.GetServicios(idHabitacion);

		for (int i = 0; i < servicios.size(); i++) {
			if (servicios.get(i).getDescripcion().equals(nombreSeleccion)) {
				servicio = servicios.get(i);
				break;
			}
		}

		setTitle("Proyecto Ingenierķa de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		anuncio = new JLabel("MOSTRAR SERVICIO");
		anuncio.setBounds(130, 40, 180, 80);
		anuncio.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(anuncio);

		descripcionServicio = new JLabel("Descripcion");
		descripcionServicio.setBounds(60, 150, 120, 80);
		descripcionServicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(descripcionServicio);

		descripcion = new JLabel(servicio.getDescripcion());
		descripcion.setBounds(180, 180, 150, 30);
		descripcion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(descripcion);
		
		setVisible(true);
	}

}
