package app;
import modelo.TarifaCana;
import modelo.ConceptoDevengo;
import dao.ConceptoDevengoDAO;
import dao.EmpleadoDAO;
import controlador.ConceptoDevengoControlador;
import controlador.EmpleadoControlador;

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
		ConceptoDevengoControlador controlador_devengo = new ConceptoDevengoControlador();
		controlador_devengo.leerSubArchivos();
		
		/*
		
		//debug para ver si se registarion bn
		//List<ConceptoDevengo> cortes_cana = controlador.getDevengoDAO();
		
		
		int quincena = 1;
		for (ConceptoDevengo corte_cana : cortes_cana) {
			System.out.println("valor para la quincena " + quincena + ": " + "$" + corte_cana.getValorDevengo());
			quincena++;
		}
		//controlador.listarArchivos();
		
		//debug para empleados
		//testeando...
		EmpleadoControlador controlador_empleados = new EmpleadoControlador();
		controlador_empleados.leerArchivo();
		EmpleadoDAO dao_empleados = controlador_empleados.getDAO();
		System.out.println(dao_empleados.obtener(3).getId());
			
		*/		
	}


}