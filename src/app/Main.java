package app;


import vista.EmpleadoVista;
import vista.BotonesClase;
import controlador.Menu;

import controlador.EmpleadoControlador;

public class Main {
	public static void main(String[] args) {
		// TarifaCana tarifa = new TarifaCana();
		// tarifa.getTarifa(1, 'F');
		BotonesClase vista = new BotonesClase();
		Menu menu = new Menu(vista);
		
		 
		// EmpleadoControlador controlador = new EmpleadoControlador(vista);
		// vista.setVisible(true);

	}
}