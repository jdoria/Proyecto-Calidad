package Principal;

import Controlador.Controlador;
import Interfaz.Pantalla_Inicio;

public class Principal {

	public static void main(String[] args){
		Pantalla_Inicio i = new Pantalla_Inicio();
		@SuppressWarnings("unused")
		Controlador c = new Controlador(i);
		
	}

}
