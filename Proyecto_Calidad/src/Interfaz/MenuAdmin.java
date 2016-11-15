package Interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuAdmin extends JFrame {
	
	private JLabel bienvenida;
	private JButton perfil;
	private JButton asignarLinea;
	private JButton asignarPuntos;
	private JButton calificarVendedor;
	
	
	public MenuAdmin() {
		// TODO Auto-generated constructor stub
		
		setTitle("Proyecto Electiva III");
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		bienvenida = new JLabel("Bienvenido Administrador");
		bienvenida.setBounds(160, 20, 400, 50);
		bienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(bienvenida);
		
		perfil = new JButton("Perfil");
		perfil.setBounds(235, 180, 120, 30);
		perfil.setFont(new Font("Tahoma", 0, 15));
		add(perfil);
		
		asignarLinea = new JButton("Asignar líneas");
		asignarLinea.setBounds(220, 280, 150, 30);
		asignarLinea.setFont(new Font("Tahoma", 0, 15));
		add(asignarLinea);
		
		asignarPuntos = new JButton("Asignar puntos");
		asignarPuntos.setBounds(220, 380, 150, 30);
		asignarPuntos.setFont(new Font("Tahoma", 0, 15));
		add(asignarPuntos);		

		calificarVendedor = new JButton("Calificar Vendedores");
		calificarVendedor.setBounds(215, 480, 165, 30);
		calificarVendedor.setFont(new Font("Tahoma", 0, 15));
		add(calificarVendedor);
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuAdmin p = new MenuAdmin();
		
		p.setVisible(true);

	}*/

}
