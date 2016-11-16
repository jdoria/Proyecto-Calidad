package Interfaz;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JButton buttonCont;
	private JLabel presentacion;
	private PanelImagen panelImagen;
	
	public Principal() {
		componentes();
	}
	
	public void componentes(){
		setTitle("Proyecto Electiva III");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		presentacion = new JLabel("Almacen de Carros AutoUAN");
		presentacion.setBounds(250, 50, 400, 50);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		panelImagen = new PanelImagen( );
		panelImagen.setBounds(120, 100, 562, 360);
		add( panelImagen );
		
		buttonCont = new JButton("Continuar");
		buttonCont.setBounds(330, 500, 120, 30);
		buttonCont.setFont(new Font("Tahoma", 0, 15));
		buttonCont.setActionCommand("continuar");
		add(buttonCont);
		
		setVisible(true);
	}
	
	void addContinue(ActionListener listenForContinue){
		
		buttonCont.addActionListener(listenForContinue);
	}
	
	
	void displayError(String error){
		JOptionPane.showMessageDialog(this, error);
	}
	
	public void buttonContinue(ActionListener l) {
		buttonCont.addActionListener(l);
	}
}

