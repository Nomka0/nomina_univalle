package controlador;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelo.ConceptoDevengo;
import modelo.Empleado;
import modelo.TarifaCana;
//import modelo.Usuario;
import vista.EmpleadoVista;
import dao.ConceptoDevengoDAO;
import dao.EmpleadoDAO;
//import dao.UsuarioDAOImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class EmpleadoControlador {

	private EmpleadoDAO empleadosDAO;
	private String lista_trabajadores;
	private ConceptoDevengoControlador controlador_devengo;
	//private Map<Integer, EmpleadoDAO> empleadosDAOs;

	private EmpleadoVista ventana;
	
	public EmpleadoControlador() {
		empleadosDAO = new EmpleadoDAO();		
		lista_trabajadores = "CSVs/Trabajadores.csv";
		leerArchivo();
		//ventana = new EmpleadoVista();
		//ventana.setVisible(true);
	}
	
	public EmpleadoDAO getDAO() {
		return empleadosDAO; 
	}
	
	/*
	public Map<Integer, EmpleadoDAO> getMapEmpleadosDAO() {
		return empleadosDAOs; 
	}
	*/
	
	/*
	public EmpleadoDAO seleccionarDAO(int ID) {//Selecciona un DAO del map según su id
		return empleadosDAOs.get(ID);
	}
	*/
	
	public void retiroCompania(int index) {// este index corresponderá con el de la tabla de la vista
	//así será fácil navegar en el dao, respectivamente con la tabla de la vista
		Empleado empleado = empleadosDAO.obtener(index);
		if(empleado.getActivo()) { // si está activo
			empleado.setActivo(false);
		} else System.out.println("El usuario ya está retirado"); // lo puedes reemplazar con
		//un mensaje de error en pantalla de la vista
		
	}
	
    public void datosPersistentes() {
        for (Empleado empleado : empleadosDAO.obtenerTodos()) {
            ventana.addDatosTabla(empleado);
        }
    }
	
	public void crearEmpleado (int id, String nombre, String apellido, String direccion, int eps, int fpp,
			String fecha_ingreso, String activo, String tipo_trabajador,
			String tipo_salario, long cuenta_bancaria) {
		
		Empleado empleado = new Empleado(id, nombre, apellido, direccion, eps, fpp,
			 fecha_ingreso, activo, tipo_trabajador,
			 tipo_salario, cuenta_bancaria);
		leerArchivo();
		empleadosDAO.crear(empleado);
		verificarCarpetas();
		crearArchivoCSV();
	}
	
	public void crearCarpeta(int id_empleado) {
		String ruta_carpeta = "CSVs/empleados/" + id_empleado + "/cortes_semanales";
		
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
	
	
	 
	public void crearArchivoCSV() {
		List<Empleado> dao = empleadosDAO.obtenerTodos();
	        String nombreArchivo = lista_trabajadores;
	        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
	            // Escribir encabezados en el archivo CSV
	            writer.println("ID,Nombre,Apellido,Dirección,EPS,FPP,Fecha de ingreso,Activo,Tipo de trabajador,Tipo de Salario,Cuenta bancaria");
	            
	            // Escribir los datos de devengos en el archivo CSV
	            for (Empleado empleado : dao) {
	            	int id = empleado.getId();
	            	String nombre = empleado.getNombre();
	            	String apellido = empleado.getApellido();
	            	String direccion = empleado.getDireccion();
	            	int eps = empleado.getEps();
	            	int fpp = empleado.getFpp();
	            	SimpleDateFormat formatoDeseado = new SimpleDateFormat("yyyyMMdd");
	    			Date fecha_ingreso = empleado.getFechaIngreso();
	       
	            	String fechaFormateada = formatoDeseado.format(fecha_ingreso);
	    			String activo;
	    			if (empleado.getActivo()) {
	    				 activo = "Sí";
	    			} else activo = "No";
	    			
	    			String tipo_trabajador = empleado.getTipoTrabajador();
	    			String tipo_salario = empleado.getTipoSalario();
	    			long cuenta_bancaria = empleado.getCuentaBancaria();
	            	
	                writer.println(id + "," + nombre + "," +  apellido + "," +  direccion + "," +  eps + "," +  fpp + "," +  fechaFormateada + "," +  activo + "," +  tipo_trabajador + "," +  tipo_salario + "," +  cuenta_bancaria);
	            
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
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

