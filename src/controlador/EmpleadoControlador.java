package controlador;

import java.util.List;
import java.util.Scanner;

import modelo.ConceptoDevengo;
import modelo.Empleado;
import modelo.TarifaCana;
import dao.EmpleadoDAO;
import java.io.File;
import java.io.FileNotFoundException;

public class EmpleadoControlador {

	private EmpleadoDAO empleadosDAO;
	private String ruta_archivo;

	public EmpleadoControlador() {
		empleadosDAO = new EmpleadoDAO();
		ruta_archivo = "CSVs/Trabajadores.csv";
	}
	/*
	public crearCarpeta() {

	}
	 */
	public void leerArchivo() {
		boolean primeraLinea = true; // Para indicar si es la primera línea del archivo
		try {
	        File archivo = new File(ruta_archivo);
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
				int ID = Integer.parseInt(campos[0]);
				String nombre = campos[1];
				String apellido = campos[2];
				String direccion = campos[3];
				int EPS = Integer.parseInt(campos[4]);
				int FPP = Integer.parseInt(campos[5]);
				String fecha_ingreso = campos[6];
				String activo = campos[7];
				String tipo_trabajador = campos[8];
				String tipo_salario = campos[9];
				long cuenta_bancaria = Long.parseLong(campos[10]);

				Empleado empleado_individual = new Empleado(ID, nombre, apellido, direccion, EPS, FPP, fecha_ingreso,
						activo, tipo_trabajador, tipo_salario,cuenta_bancaria);
				empleadosDAO.crear(empleado_individual);
			}
			// Cerrar el scanner después de terminar de leer el archivo
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(empleadosDAO.obtenerTodos());
	}
}

