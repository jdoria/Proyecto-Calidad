package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ConfirmarReserva extends JFrame {
	private JLabel confirmar;
	private JLabel habitacion;
	private JLabel habitacionEscogida;
	private JLabel dias;
	private JLabel numDias;
	private JLabel valorTotal;
	private JLabel valorTotalReserva;
	private JButton aceptar;
	private JButton cancelar;

	public ConfirmarReserva(String tipo, long diasReserva, int valorReserva) {
		// TODO Auto-generated constructor stub
		
		valorReserva = (int) ((valorReserva*0.3)+valorReserva);
		valorReserva = (int) ((valorReserva*0.1)+valorReserva);
		
		valorReserva = (int) (valorReserva * diasReserva);
		
		setTitle("Proyecto Ingeniería de Software I");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		confirmar = new JLabel("CONFIRMAR");
		confirmar.setBounds(150, 50, 150, 30);
		confirmar.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(confirmar);
		
		habitacion = new JLabel("Habitación: ");
		habitacion.setBounds(70, 100, 150, 30);
		habitacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(habitacion);
		
		habitacionEscogida = new JLabel(tipo);
		habitacionEscogida.setBounds(190, 100, 150, 30);
		habitacionEscogida.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(habitacionEscogida);
		
		dias = new JLabel("Noches: ");
		dias.setBounds(70, 130, 150, 30);
		dias.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(dias);
		
		numDias = new JLabel(String.valueOf(diasReserva));
		numDias.setBounds(190, 130, 150, 30);
		numDias.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(numDias);
		
		valorTotal = new JLabel("Valor Reserva: ");
		valorTotal.setBounds(70, 160, 150, 30);
		valorTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(valorTotal);
		
		valorTotalReserva = new JLabel(String.valueOf(valorReserva));
		valorTotalReserva.setBounds(190, 160, 150, 30);
		valorTotalReserva.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(valorTotalReserva);
		
		aceptar = new JButton("Aceptar");
		aceptar.setBounds(60, 250, 120, 30);
		aceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(aceptar);

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(240, 250, 120, 30);
		cancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(cancelar);

		setVisible(true);
	}
	
	
	public void buttonAceptar(ActionListener l){
		aceptar.addActionListener(l);
	}
	
	public void buttonCancelar(ActionListener l){
		cancelar.addActionListener(l);
	}
	
	public int getValorTotal(){
		return Integer.parseInt(valorTotalReserva.getText());
	}
}
