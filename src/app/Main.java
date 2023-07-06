package app;

import modelo.TarifaCana;
import vista.EmpleadoVista;
import modelo.ConceptoDevengo;
import controlador.EmpleadoControlador;
import dao.ConceptoDevengoDAO;

public class Main {
	public static void main(String[] args) {
		// TarifaCana tarifa = new TarifaCana();
		// tarifa.getTarifa(1, 'F');
		EmpleadoVista vista = new EmpleadoVista();
		EmpleadoControlador controlador = new EmpleadoControlador(vista);
		vista.setVisible(true);

	}
}