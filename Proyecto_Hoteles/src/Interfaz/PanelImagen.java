package Interfaz;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{
private JLabel imagen;
	
	public PanelImagen() {
		// TODO Auto-generated constructor stub
		FlowLayout layout = new FlowLayout( );
        layout.setHgap( 0 );
        layout.setVgap( 0 );
        setLayout( layout );

        ImageIcon icono = new ImageIcon( "imagenes/hotel.jpg" );

        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        add( imagen );

        //Color de fondo blanco
        setBackground( Color.WHITE );
        //setBorder( new LineBorder( Color.GRAY ) );

	}

}
