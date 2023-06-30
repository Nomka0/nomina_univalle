package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import dao.ConceptoDevengoDAO;
import modelo.ConceptoDevengo;

public class ConceptoDevengoControlador {
	ConceptoDevengoDAO devengosDAO;
	List<ConceptoDevengo> devengos;
	String ruta_archivo;
	
	
	public ConceptoDevengoControlador() {
		devengosDAO = new ConceptoDevengoDAO();
		devengos = devengosDAO.obtenerTodos();
		ruta_archivo = "CSVs/corte_cana1.csv";
		
	}
	
	public List<ConceptoDevengo> getDevengoDAO() {
		return devengos; 
	}

	public void leerArchivo() {
        boolean primeraLinea = true; // Para indicar si es la primera línea del archivo
		try {
			// Crear instancia de Scanner para leer el archivo
			Scanner scanner = new Scanner(new File(ruta_archivo));

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
                String haciendaSuerte = campos[2];
                int toneladaCorte = Integer.parseInt(campos[3]);
                int tipoCana = Integer.parseInt(campos[4]);
                char diaCorte = campos[5].charAt(0);
                
                ConceptoDevengo tarifa_individual= new ConceptoDevengo(ficha, fechaCorte, haciendaSuerte, toneladaCorte, tipoCana, diaCorte);
                devengosDAO.crear(tarifa_individual);
			}
			// Cerrar el scanner después de terminar de leer el archivo
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}



}
