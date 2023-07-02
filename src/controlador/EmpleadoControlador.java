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
	private String lista_trabajadores;

	public EmpleadoControlador() {
		empleadosDAO = new EmpleadoDAO();
		lista_trabajadores = "CSVs/Trabajadores.csv";
	}
	
	public EmpleadoDAO getDAO() {
		return empleadosDAO; 
	}
	
	public void crearCarpeta(int id_empleado) {
		String ruta_carpeta = "CSVs/empleados/" + id_empleado + "devengos";
		File carpeta = new File(ruta_carpeta);
		
        // Verificamos si la carpeta ya existe
        if (!carpeta.exists()) {
            // Intentamos crear la carpeta
            if (carpeta.mkdirs()) {
                System.out.println("La carpeta ha sido creada exitosamente.");
            } else {
                System.out.println("Error al crear la carpeta.");
            }
        } else {
            System.out.println("La carpeta ya existe.");
        }
	}
	
	//verifica si todos los usuarios tienen sus carpetas creadas. Si uno no la tiene, tin, la crea
	public void verificarCarpetas() {
		List<Empleado> all_empleados = getDAO().obtenerTodos();
		
		for(Empleado empleado : all_empleados) {
			int id_empleado = empleado.getId();
			crearCarpeta(id_empleado);
		}
	}
	 
	public void leerArchivo() {
		boolean primeraLinea = true; // Para indicar si es la primera línea del archivo
		try {
	        File archivo = new File(lista_trabajadores);
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
			
			//ESTE BLOQUE SE VA A COMENTAR. SOLAMENTE ES PARA DEBUGGEAR UNA CUESTIÓN DE CARPETAS//
			Empleado empleado_test = new Empleado(1000, "empleado", "ficticio", "nose jajaj", 69420, 1234, "20230619",
					"Sí", "Socio", "Fijo",235437364);
			empleadosDAO.crear(empleado_test);
			//ESTE BLOQUE SE VA A COMENTAR. SOLAMENTE ES PARA DEBUGGEAR UNA CUESTIÓN DE CARPETAS//
			
			// Cerrar el scanner después de terminar de leer el archivo
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(empleadosDAO.obtenerTodos());
	}
}

