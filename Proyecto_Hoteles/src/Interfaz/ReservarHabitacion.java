package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ReservarHabitacion extends JFrame {
	
	private JLabel anuncioReserva;
	private JLabel nombreCliente;
	private JTextField nombre;
	private JLabel identificacionCliente;
	private JTextField identificacion;
	private JLabel telefonoCliente;
	private JTextField telefono;
	private JLabel fechaInicio;
	//private JTextField fechaIni;
	private JLabel fechaFin;
	//private JTextField fechaFi;
	private JButton reservar;
	private JDateChooser fechaIni;
	private JDateChooser fechaFi;
	private JDateChooser fechaActual;
	private JLabel fecha;
	//private JTextField dias;
	
	public ReservarHabitacion() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(600, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		anuncioReserva = new JLabel("RESERVACIÓN");
		anuncioReserva.setBounds(180, 80, 400, 100);
		anuncioReserva.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(anuncioReserva);

		nombreCliente = new JLabel("Nombre: ");
		nombreCliente.setBounds(100, 220, 100, 80);
		nombreCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(nombreCliente);

		nombre = new JTextField();
		nombre.setBounds(335, 250, 150, 30);
		add(nombre);

		identificacionCliente = new JLabel("Identificación: ");
		identificacionCliente.setBounds(100, 270, 150, 80);
		identificacionCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(identificacionCliente);

		identificacion = new JTextField();
		identificacion.setBounds(335, 300, 150, 30);
		add(identificacion);

		telefonoCliente = new JLabel("Teléfono: ");
		telefonoCliente.setBounds(100, 320, 100, 80);
		telefonoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(telefonoCliente);

		telefono = new JTextField();
		telefono.setBounds(335, 350, 150, 30);
		add(telefono);
		
		fecha = new JLabel("Fecha: ");
		fecha.setBounds(100, 400, 150, 30);
		fecha.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(fecha);
		
		fechaActual = new JDateChooser();
		fechaActual.setBounds(335, 400, 150, 30);
		add(fechaActual);

		fechaInicio = new JLabel("Fecha Inicio \n (DD/MM/AAAA): ");
		fechaInicio.setBounds(100, 420, 230, 80);
		fechaInicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(fechaInicio);

		/*fechaIni = new JTextField();
		fechaIni.setBounds(335, 400, 150, 30);
		add(fechaIni);*/
		fechaIni = new JDateChooser();
		fechaIni.setBounds(335,450,150,30);
		add(fechaIni);

		fechaFin = new JLabel("Fecha Fin (DD/MM/AAAA): ");
		fechaFin.setBounds(100, 470, 210, 80);
		fechaFin.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(fechaFin);

		/*fechaFi = new JTextField();
		fechaFi.setBounds(335, 450, 150, 30);
		add(fechaFi);*/
		fechaFi = new JDateChooser();
		fechaFi.setBounds(335,500,150,30);
		add(fechaFi);

		reservar = new JButton("Reservar");
		reservar.setBounds(220, 570, 150, 40);
		reservar.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(reservar);
		
		setVisible(true);
		

	}
	
	
	public String getFechaInicio(){
		String formato = fechaIni.getDateFormatString();
		Date date = fechaIni.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String fechaIni = String.valueOf(sdf.format(date));
		return fechaIni;
	}
	
	public String getFechaFin(){
		String formato = fechaFi.getDateFormatString();
		Date date = fechaFi.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String fechaFin = String.valueOf(sdf.format(date));
		return fechaFin;
	}
	
	public String getFechaActual(){
		String formato = fechaActual.getDateFormatString();
		Date date = fechaActual.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String fechaActual = String.valueOf(sdf.format(date));
		return fechaActual;
	}
	
	public long getDias(){
		long dias = fechaFi.getDate().getTime() - fechaIni.getDate().getTime();
		//System.out.println(fechaFi.getDate().getDay());
		dias = (TimeUnit.DAYS.convert(dias, TimeUnit.MILLISECONDS));
		//System.out.println(dias);
		return dias;
	}
	
	public String getNombre(){
		return nombre.getText();
	}
	
	public String getTelefono(){
		return telefono.getText();
	}
	
	public String getIdentificacion(){
		return identificacion.getText();
	}
	
	public void buttonReservar(ActionListener l){
		reservar.addActionListener(l);
	}
}
