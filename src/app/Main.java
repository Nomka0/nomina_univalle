package app;
import modelo.TarifaCana;
import vista.EmpleadoVista;
import modelo.ConceptoDevengo;
import dao.ConceptoDevengoDAO;
import dao.EmpleadoDAO;
import controlador.ConceptoDevengoControlador;
import controlador.DeduccionControlador;
import controlador.EmpleadoControlador;
import controlador.EmpleadoVistaControlador;

//testeando para archivos de corte de caña...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//testeando...
		//entonces supongo que lo que podemos hacer es por cada quincena crear dos archivos
		//aquí estoy en la branch de gestion_Archivos
		//testeando para archivo de corte de caña...
		/*
		ConceptoDevengoControlador controlador_devengo = new ConceptoDevengoControlador();
		controlador_devengo.leerSubArchivos();
		controlador_devengo.crearArchivosCSV();
		*/
		
/*
		//debug para empleados
		//testeando...
		EmpleadoControlador controlador_empleados = new EmpleadoControlador();
		//controlador_empleados.leerArchivo();
		EmpleadoDAO dao_empleados = controlador_empleados.getDAO();
		controlador_empleados.crearEmpleado(12344, "estoy mamado", "lol", "calle", 1255, 546, "20230420", "Sí", "Socio", "Fijo", 2345363);
		System.out.println(dao_empleados.obtener(0).getNombre());
	*/	
		
		
		//test deducciones
		
		
		//DeduccionControlador deduccion_controlador = new DeduccionControlador();
		//deduccion_controlador.leerSubArchivos();
		//deduccion_controlador.crearDeduccionesAuto();
		//deduccion_controlador.crearArchivosCSV();
		
		EmpleadoControlador empleado = new EmpleadoControlador();
		EmpleadoVista ventana = new EmpleadoVista();
		empleado.leerArchivo();
		//datosPersistentes();
		
		EmpleadoVistaControlador controlador = new EmpleadoVistaControlador(ventana,empleado);
		

	}


}