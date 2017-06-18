package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dto.ReservaDTO;

@SuppressWarnings("serial")
public class VerReservas extends JFrame{
	private JLabel reservas;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel quitarReserva;
	private JTextField idReserva;
	private JButton terminar;
	
	
	
	public VerReservas() {
		// TODO Auto-generated constructor stub
		setTitle("Proyecto Ingeniería de Software I");
		setSize(850, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		reservas = new JLabel("RESERVAS");
		reservas.setBounds(350, 30, 150, 30);
		reservas.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(reservas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 800, 300);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setOpaque(true);
		add(scrollPane);
		
		quitarReserva = new JLabel("Id de la Reserva a terminar: ");
		quitarReserva.setBounds(40, 400, 300, 30);
		quitarReserva.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(quitarReserva);
		
		idReserva = new JTextField();
		idReserva.setBounds(40, 440, 80, 30);
		add(idReserva);
		
		terminar = new JButton("Terminar");
		terminar.setBounds(130, 440, 120, 30);
		terminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(terminar);
		
		setVisible(true);
		
	}
	
	public void cargarTablaProductos(ArrayList<ReservaDTO> reservas, ArrayList<String> clientes) {
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable();
		table.setModel(model);
		table.setBackground(Color.WHITE);
		table.setOpaque(true);
		
		model.addColumn("Fecha Reserva");
		model.addColumn("No. Reserva");
		model.addColumn("Habitación");
		model.addColumn("Cliente");
		model.addColumn("Fecha Llegada");
		model.addColumn("Fecha Salida");
		model.addColumn("Días");
		model.addColumn("Valor Total");
		model.addColumn("Estado");
		Object[] fila = new Object[model.getColumnCount()];
		for (int i = 0; i < reservas.size(); i++) {
			fila[0] = reservas.get(i).getFechaReserva();
			fila[1] = reservas.get(i).getIdReserva();
			fila[2] = reservas.get(i).getIdHabitacion();
			fila[3] = clientes.get(i);
			fila[4] = reservas.get(i).getFechaInicio();
			fila[5] = reservas.get(i).getFechaFin();
			fila[6] = reservas.get(i).getDias();
			fila[7] = reservas.get(i).getValorTotal();
			fila[8] = reservas.get(i).getEstado();
			model.addRow(fila);
		}
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
		table.setBackground(Color.WHITE);
		
		scrollPane.setViewportView(table);
		scrollPane.setBackground(Color.WHITE);
	}
	
	public String getIdReserva(){
		return idReserva.getText();
	}
	
	public void buttonTerminar(ActionListener l){
		terminar.addActionListener(l);
	}

}
