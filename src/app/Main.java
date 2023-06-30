package app;
import modelo.TarifaCana;
import modelo.ConceptoDevengo;
import dao.ConceptoDevengoDAO;
import controlador.ConceptoDevengoControlador;

//testeando para archivos de corte de caña...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//TarifaCana tarifa = new TarifaCana(); 
		//tarifa.getTarifa(1, 'F');

		//testeando...
		//entonces supongo que lo que podemos hacer es por cada quincena crear dos archivos
		//aquí estoy en devengos
		//testeando para archivo de corte de caña...
		ConceptoDevengoControlador controlador = new ConceptoDevengoControlador();
		controlador.leerArchivo();
		
		
		//debug para ver si se registarion bn
		List<ConceptoDevengo> cortes_cana = controlador.getDevengoDAO();
		int dia = 1;
		for (ConceptoDevengo corte_cana : cortes_cana) {
			System.out.println("valor para el día " + dia + ": " + "$" + corte_cana.getValorDevengo());
			dia++;
		}
		
		
		
		
	}


}