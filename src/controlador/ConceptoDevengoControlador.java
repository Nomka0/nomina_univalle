package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import dao.ConceptoDevengoDAO;
import modelo.ConceptoDevengo;
import modelo.TarifaCana;

import java.util.Arrays;

public class ConceptoDevengoControlador {
	private ConceptoDevengoDAO devengosDAO;
	private List<ConceptoDevengo> devengos;
	private String ruta_archivo;
	private String carpeta;
	private File[] archivos = {};
	
	
	public ConceptoDevengoControlador() {
		devengosDAO = new ConceptoDevengoDAO();
		devengos = devengosDAO.obtenerTodos();
        carpeta = "CSVs";
		//ruta_archivo = "CSVs/corte_cana1.csv";
	}
	
	public List<ConceptoDevengo> getDevengoDAO() {
		return devengos; 
	}

	public void listarArchivos() {
        File directorio = new File(carpeta);
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
	public void mesesTranscurridos() {
		ConceptoDevengo ultimo = devengosDAO.obtener(devengosDAO.obtenerTodos().size()-1);//obtengo el último, para averiguar la última fehca
		System.out.println(ultimo.getFecha()); 
	}
	
	public void leerArchivo() {
		listarArchivos();
		int quincena_counter = 0; //cuando llegue a 12, significa que habrán pasado 2 semanas, entonces reinicia, para dar el valor de la siguiente quincena
		float quincena_total = 0; //el acumulado de todo lo que se cortó en la quincena
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
		                ConceptoDevengo tarifa_individual= new ConceptoDevengo(ficha,"QUINCENA CORTE DE CAÑA" , fechaCorte, quincena_total);
		                devengosDAO.crear(tarifa_individual);
		                quincena_counter = 0;
	                }
	                
				}
				// Cerrar el scanner después de terminar de leer el archivo
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
		mesesTranscurridos();// ver si retrona correctamente la fecha
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
