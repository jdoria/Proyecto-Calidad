package Interfaz;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PPrincipal1 extends JFrame {

	private JButton buttonCont;
	private JLabel presentacion;
	private JButton buttonLogo;
	
	public PPrincipal1() {
		componentes();
	}
	
	public void componentes(){
		setTitle("Proyecto Electiva III");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		
		buttonLogo = new JButton(new ImageIcon("imagenes/Logo.jpg"));
		buttonLogo.setBackground(Color.black);
		buttonLogo.setBounds(200, 100, 200, 200);
		add(buttonLogo);
		
		presentacion = new JLabel("Almacen de Carros AutoUAN");
		presentacion.setBounds(250, 50, 400, 50);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		buttonCont = new JButton("Continuar");
		buttonCont.setBounds(330, 400, 120, 30);
		buttonCont.setFont(new Font("Tahoma", 0, 15));
		add(buttonCont);

	}
	
	void addContinue(ActionListener listenForContinue){
		
		buttonCont.addActionListener(listenForContinue);
	}
	
	
	void displayError(String error){
		JOptionPane.showMessageDialog(this, error);
	}
}
