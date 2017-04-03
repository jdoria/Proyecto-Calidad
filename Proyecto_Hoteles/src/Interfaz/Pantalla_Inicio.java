package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Pantalla_Inicio extends JFrame{
	
	private JButton buttonCont;
	private JLabel presentacion;
	private PanelImagen panelImagen;
	
	public Pantalla_Inicio() {
		componentes();
	}
	
	public void componentes(){
		setTitle("Proyecto Ingeniería de Software I");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		presentacion = new JLabel("Agencia de Hoteles UAN");
		presentacion.setBounds(275, 50, 400, 50);
		presentacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(presentacion);
		
		panelImagen = new PanelImagen( );
		panelImagen.setBounds(120, 100, 562, 360);
		add( panelImagen );
		
		buttonCont = new JButton("Continuar");
		buttonCont.setBounds(330, 500, 120, 30);
		buttonCont.setFont(new Font("Tahoma", 0, 15));
		buttonCont.setActionCommand("continuarMenu");
		add(buttonCont);
		
		setVisible(true);
	}
	
	void displayError(String error){
		JOptionPane.showMessageDialog(this, error);
	}
	
	public void buttonContinue(ActionListener l) {
		buttonCont.addActionListener(l);
	}

	
}
