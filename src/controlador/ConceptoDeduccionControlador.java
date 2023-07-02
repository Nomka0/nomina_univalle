package controlador;

import java.util.List;
import java.util.Scanner;

import modelo.ConceptoDeduccion;
import dao.ConceptoDeduccionDAO;
import java.io.File;
import java.io.FileNotFoundException;

public class ConceptoDeduccionControlador {

	private ConceptoDeduccionDAO conceptoDeduccionDAO;
	private String listaDeducciones;

	public ConceptoDeduccionControlador() {
		conceptoDeduccionDAO = new ConceptoDeduccionDAO();
		listaDeducciones = "CSVs/Deducciones.csv";
	}
	
	public ConceptoDeduccionDAO getDAO() {
		return conceptoDeduccionDAO; 
	}
	
	public void leerArchivo() {
		boolean primeraLinea = true; // Para indicar si es la primera línea del archivo
		try {
	        File archivo = new File(listaDeducciones);
			// Crear instancia de Scanner para leer el archivo
			Scanner scanner = new Scanner(archivo);

			// Iterar sobre las líneas del archivo
			while (scanner.hasNextLine()) {
				// Leer la línea actual
				String linea = scanner.nextLine();

				if (primeraLinea) {
					primeraLinea = false;
					continue;
				}

				// Dividir la línea en campos utilizando la coma como delimitador
				String[] campos = linea.split(",");

				// Acceder a los datos de cada campo
				int codigo = Integer.parseInt(campos[0]);
				String nombre = campos[1];
				boolean esAutomatico = Boolean.parseBoolean(campos[2]);
				double valorBase = Double.parseDouble(campos[3]);

				ConceptoDeduccion deduccion = new ConceptoDeduccion(codigo, nombre, esAutomatico, valorBase);
				conceptoDeduccionDAO.crear(deduccion);
			}
			
			// Cerrar el scanner después de terminar de leer el archivo
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(conceptoDeduccionDAO.obtenerTodos());
	}
}