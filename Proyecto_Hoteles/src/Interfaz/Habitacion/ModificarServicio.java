package Interfaz.Habitacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Habitacion;
import modelo.Servicio;

public class ModificarServicio extends JFrame {

	private JLabel anuncio;
	private JLabel descripcionServicio;
	private JTextField descripcion;
	private JButton modificar;
	private Habitacion habitacion;
	private Servicio servicio;

	public ModificarServicio(Habitacion habitacionPantalla, String nombreSeleccion) {
		// TODO Auto-generated constructor stub

		habitacion = habitacionPantalla;

		for (int i = 0; i < habitacion.getServicios().size(); i++) {
			if (habitacion.getServicios().get(i).getDescripcion().equals(nombreSeleccion)) {
				servicio = habitacion.getServicios().get(i);
				break;
			}
		}

		setTitle("Proyecto Ingenier�a de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		anuncio = new JLabel("MODIFICAR SERVICIO");
		anuncio.setBounds(130, 40, 180, 80);
		anuncio.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(anuncio);

		descripcionServicio = new JLabel("Descripcion");
		descripcionServicio.setBounds(60, 150, 120, 80);
		descripcionServicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(descripcionServicio);

		descripcion = new JTextField(servicio.getDescripcion());
		descripcion.setBounds(180, 180, 150, 30);
		add(descripcion);

		modificar = new JButton("Modificar");
		modificar.setBounds(150, 300, 150, 30);
		modificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(modificar);

		setVisible(true);

	}
	
	public String getDescripcion(){
		return descripcion.getText();
	}
	
	public void buttonModificar(ActionListener l){
		modificar.addActionListener(l);
	}
}