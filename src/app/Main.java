package app;
import modelo.TarifaCana;
import modelo.ConceptoDevengo;
import dao.ConceptoDevengoDAO;

//testeando para archivos de corte de caña...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//TarifaCana tarifa = new TarifaCana(); 
		//tarifa.getTarifa(1, 'F');

		//testeando...
		//entonces supongo que lo que podemos hacer es por cada quincena crear dos archivos
		//aquí estoy en devengos
		//testeando para archivo de corte de caña...
		String rutaArchivo = "corte_cana1.csv";
		
		try {
			// Crear instancia de Scanner para leer el archivo
			Scanner scanner = new Scanner(new File(rutaArchivo));

			// Iterar sobre las líneas del archivo
			while (scanner.hasNextLine()) {
				// Leer la línea actual
				String linea = scanner.nextLine();

				// Dividir la línea en campos utilizando la coma como delimitador
				String[] campos = linea.split(",");

				// Acceder a los datos de cada campo
				String ficha = campos[0];
				String fechaCorte = campos[1];
				String haciendaSuerte = campos[2];
				String toneladaCorte = campos[3];
				String tipoCana = campos[4];
				String diaCorte = campos[5];
				// Imprimir los datos o realizar las operaciones deseadas
				System.out.println("Ficha: " + ficha);
				System.out.println("Fecha de Corte: " + fechaCorte);
				System.out.println("Hacienda Suerte: " + haciendaSuerte);
				System.out.println("Tonelada de Corte: " + toneladaCorte);
				System.out.println("Tipo de Caña: " + tipoCana);
				System.out.println("Día de Corte: " + diaCorte);
				System.out.println("------------------------------------");
			}
			// Cerrar el scanner después de terminar de leer el archivo
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ConceptoDevengoDAO dao_devengos = new ConceptoDevengoDAO();
		ConceptoDevengo corte_cana = new ConceptoDevengo(124,"PRIMER PAGO SEMANAL","20230629");
		corte_cana.corteCana(1, 'F');

		dao_devengos.crear(corte_cana);

		ConceptoDevengo uno_mas = dao_devengos.obtener(0);

		String nombre_del_devengo = uno_mas.getNombre();

		System.out.println("Este es el valor (pesos) del devengo creado: " + uno_mas.getValorDevengo());

		System.out.println("Este es el devengo creado: " + nombre_del_devengo);
	}


}