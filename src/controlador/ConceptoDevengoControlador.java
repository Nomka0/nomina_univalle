package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.ConceptoDevengoDAO;
import modelo.ConceptoDevengo;
import modelo.TarifaCana;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class ConceptoDevengoControlador {
	//private ConceptoDevengoDAO devengosDAO; //DEPRECATED
	//private List<ConceptoDevengo> devengos;
	private String carpeta;
	private File[] archivos = {};
    private Map<Integer, ConceptoDevengoDAO> empleadosDAOS;
    		
	public ConceptoDevengoControlador() {
		//devengosDAO = new ConceptoDevengoDAO(); //DEPRECATED
		//devengos = devengosDAO.obtenerTodos();  //DEPRECATED
		carpeta = "CSVs/empleados/";
		empleadosDAOS = new HashMap<>();
		//ruta_archivo = "CSVs/corte_cana1.csv";
	}

	public Map<Integer, ConceptoDevengoDAO> getMapDevengosDAO() {
		return empleadosDAOS; 
	}
	
	public ConceptoDevengoDAO seleccionarDAO(int ID) {//Selecciona un DAO del map según su id
		return empleadosDAOS.get(ID);
	}

	public void listarArchivos(int id_empleado) {
		File directorio = new File(carpeta + id_empleado + "/devengos");
		//System.out.println("Nombre de carpeta: " + directorio);
		if (directorio.isDirectory()) {
			// Obtener la lista de archivos en la carpeta
			archivos = directorio.listFiles();
			reverseFileArray(archivos);
			// Recorrer y mostrar el nombre de los archivos
			if (archivos != null) {
				for (File archivo : archivos) {
					System.out.println("Nombre del archivo: " + archivo.getName());
				}
			} else {
				System.out.println("La carpeta está vacía o no se pudo acceder a los archivos.");
			}
		} else {
			System.out.println("La ruta especificada no es una carpeta válida.");
		}
	}

	//para averiguar cuando es un periodo de semestre
	public int mesesTranscurridos(int id_empleado) {
		ConceptoDevengoDAO devengos_empleado = seleccionarDAO(id_empleado);
		ConceptoDevengo primero = devengos_empleado.obtener(0);//obtengo la primer fecha de trabajo, para comparlo
		ConceptoDevengo ultimo = devengos_empleado.obtener(devengos_empleado.obtenerTodos().size()-1);//obtengo el último, para averiguar la última fehca
		Date ultima_fecha = ultimo.getFecha();
		Date primera_fecha = primero.getFecha();

	    int mes_primero = primera_fecha.getMonth() + 1;
	    int mes_ultimo = ultima_fecha.getMonth() + 1;

	    int ano_primero = primera_fecha.getYear() + 1900;//esa librería está komo deprecated
	    //y tiene ciertas cosas raras, como que eñ año comienza desde 1900, entonces x eso se le suma 1900
	    int ano_ultimo = ultima_fecha.getYear() + 1900;

	    int cuantos_meses = (ano_ultimo - ano_primero) * 12 + (mes_ultimo - mes_primero);

	    System.out.println("Han pasado " + cuantos_meses + " meses.");
	    return cuantos_meses;
	}

	public int[] getEmpleadosDir() {
	    File directorio = new File(carpeta);
	    File[] archivos = directorio.listFiles();

	    // Verificar si la ruta corresponde a un directorio válido
	    if (directorio.isDirectory()) {
	        // Invertir el orden del arreglo de archivos (opcional)
	        Arrays.asList(archivos).sort((a, b) -> b.getName().compareTo(a.getName()));

	        int[] nombres_subdirectorios = new int[archivos.length];
	        for (int i = 0; i < archivos.length; i++) {
	            if (archivos[i].isDirectory()) {
	                try {
	                    nombres_subdirectorios[i] = Integer.parseInt(archivos[i].getName());
	                    System.out.println("Directorio: " + nombres_subdirectorios[i]);
	                } catch (NumberFormatException e) {
	                    // Manejo de excepción si el nombre del subdirectorio no es un número válido
	                    System.out.println("El nombre del subdirectorio no es un número válido.");
	                }
	            }
	        }
	        return nombres_subdirectorios;
	    } else {
	        System.out.println("La ruta no corresponde a un directorio válido.");
	        return new int[0]; // Retorna un arreglo vacío en caso de que no sea un directorio válido
	    }
	}


	//un leerArchivo pero para todos los empleados
	public void leerSubArchivos() { //Toma toooodos los empleados que listó getEmpleadosDir() y lee sus archivos con el método de leerArchivo
		int[] directorios_empleados = getEmpleadosDir();
		
		for (int directorio : directorios_empleados) {
			empleadosDAOS.put(directorio, leerArchivo(directorio)); //pone en el map la clave (que sería el nombre de la carpeta, la cual es el id de
			//empleado) y el dao de devengo retornado por leerArchivo.
			int meses = mesesTranscurridos(directorio);// ver si retrona correctamente la fecha
			prestacioneSociales(directorio, meses);
			ConceptoDevengoDAO dao_test = empleadosDAOS.get(directorio);
			ConceptoDevengo ultimo_dao = dao_test.obtener(dao_test.obtenerTodos().size()-1);
			String tipo_devengo = ultimo_dao.getNombre();
			System.out.println("Total de devengos: " + dao_test.obtenerTodos());
			System.out.println("Ultimo devengo: " + tipo_devengo);
		}
		System.out.println("Empleados y devengos: " + empleadosDAOS);
	}
	
	public ConceptoDevengoDAO leerArchivo(int id_empleado) {
		listarArchivos(id_empleado); // esto va a listar los archivos en el atributo de archivos de la clase, y así se va a poder usar acá
		int quincena_counter = 0; //cuando llegue a 12, significa que habrán pasado 2 semanas, entonces reinicia, para dar el valor de la siguiente quincena
		float quincena_total = 0; //el acumulado de todo lo que se cortó en la quincena
		ConceptoDevengoDAO nuevo_devengo = new ConceptoDevengoDAO(); // la idea de esto es para que cada empleado tengo su propio dao
		
		for (File ruta_archivo : archivos) {
			boolean primeraLinea = true; // Para indicar si es la primera línea del archivo
			try {
				// Crear instancia de Scanner para leer el archivo
				Scanner scanner = new Scanner(ruta_archivo);

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
					int ficha = Integer.parseInt(campos[0]);
					String fechaCorte = campos[1];
					//String haciendaSuerte = campos[2]; //considero que no es relevante (por ahora)
					float toneladaCorte = Float.parseFloat(campos[3]);
					int tipoCana = Integer.parseInt(campos[4]);
					char diaCorte = campos[5].charAt(0);

					TarifaCana cana_evaluar = new TarifaCana(tipoCana, diaCorte);
					float corte_toneladas =  cana_evaluar.getTarifa() * (toneladaCorte/1000);
					quincena_total += corte_toneladas;

					quincena_counter++;
					

					
					if(quincena_counter == 12) {//
						ConceptoDevengo tarifa_individual= new ConceptoDevengo(ficha, fechaCorte, quincena_total);
						nuevo_devengo.crear(tarifa_individual);
						quincena_counter = 0;
						System.out.println(id_empleado);
						
					}

				}
				// Cerrar el scanner después de terminar de leer el archivo
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
		return nuevo_devengo;
	}
	
	public void prestacioneSociales(int id_empleado, int meses_transcurridos) {
		if(meses_transcurridos == 6) {
			ConceptoDevengoDAO devengos_empleado = seleccionarDAO(id_empleado);
			double sumatoria_devengos_base = sumatoria(devengos_empleado);
			ConceptoDevengo prestaciones_sociales = new ConceptoDevengo(id_empleado, "PRESTACIONES SOCIALES", sumatoria_devengos_base);
			devengos_empleado.crear(prestaciones_sociales);
		}
		else if (meses_transcurridos > 6) {
			int semestres = (int) Math.floor(meses_transcurridos/6);
			
			ConceptoDevengoDAO devengos_empleado = seleccionarDAO(id_empleado);
			double sumatoria_devengos_base = sumatoria(devengos_empleado)/semestres;
			
			for(int i = 0; i < semestres; i++) {
				ConceptoDevengo prestaciones_sociales = new ConceptoDevengo(id_empleado, "PRESTACIONES SOCIALES", sumatoria_devengos_base);
				devengos_empleado.crear(prestaciones_sociales);
			}
		}
	}
	
	//ejemplo método sumatoria
    public double sumatoria(ConceptoDevengoDAO sacarDevengos) {
            float sumatoria_devengos = 0;
            List<ConceptoDevengo> devengo_analizar = sacarDevengos.obtenerTodos();
            for(ConceptoDevengo devengos_analizar : devengo_analizar) {
                    double devengo_sumar = devengos_analizar.getValorDevengo();
                    sumatoria_devengos += devengo_sumar;
            }
            return sumatoria_devengos;
    }

	public static void reverseFileArray(File[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			// Intercambiar los elementos del inicio y el final
			File temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			// Avanzar hacia el centro del array
			start++;
			end--;
		}
	}

}
