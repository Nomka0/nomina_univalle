package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import dao.ConceptoDeduccionDAO;
import dao.ConceptoDevengoDAO;
import modelo.ConceptoDeduccion;
import modelo.ConceptoDevengo;
import modelo.Empleado;
import modelo.TarifaCana;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class DeduccionControlador {
    private String carpeta;
    private File[] archivos = {};
    private Map<Integer, ConceptoDeduccionDAO> empleadosDAOS;
    private ConceptoDevengoControlador devengo_controlador; 
    
    public DeduccionControlador() {
        carpeta = "CSVs/empleados/";
        empleadosDAOS = new HashMap<>();
        devengo_controlador = new ConceptoDevengoControlador();
        devengo_controlador.leerSubArchivos();
        devengo_controlador.crearArchivosCSV();
    }

    public Map<Integer, ConceptoDeduccionDAO> getMapDeduccionesDAO() {
        return empleadosDAOS;
    }

    public ConceptoDeduccionDAO seleccionarDAO(int ID) {
        return empleadosDAOS.get(ID);
    }

    public void listarArchivos(int id_empleado) {
        File directorio = new File(carpeta + id_empleado + "/deducciones");
        if (directorio.isDirectory()) {
            archivos = directorio.listFiles();
            reverseFileArray(archivos);
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

    public void leerSubArchivos() {
    int[] directorios_empleados = getEmpleadosDir();

    for (int directorio : directorios_empleados) {
        empleadosDAOS.put(directorio, leerArchivo(directorio));
        ConceptoDeduccionDAO dao_test = empleadosDAOS.get(directorio);
        List<ConceptoDeduccion> deducciones = dao_test.obtenerTodos();
        if (!deducciones.isEmpty()) {
            ConceptoDeduccion ultima_deduccion = deducciones.get(deducciones.size() - 1);
            String tipo_deduccion = ultima_deduccion.getTipoDeduccion();
            System.out.println("Total de deducciones: " + deducciones);
            System.out.println("Última deducción: " + tipo_deduccion);
        } else {
            System.out.println("No se encontraron deducciones para el empleado: " + directorio);
        }
    }

    System.out.println("Empleados y deducciones: " + empleadosDAOS);
    }

    public ConceptoDeduccionDAO leerArchivo(int id_empleado) {
        //listarArchivos(id_empleado);
        ConceptoDeduccionDAO nuevo_deduccion = new ConceptoDeduccionDAO();

        for (File ruta_archivo : archivos) {
            boolean primeraLinea = true;

            try {
                Scanner scanner = new Scanner(ruta_archivo);

                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();

                    if (primeraLinea) {
                        primeraLinea = false;
                        continue;
                    }

                    String[] campos = linea.split(",");

                    int ficha = Integer.parseInt(campos[0]);
                    String fechaCorte = campos[1];
                    String concepto = campos[2];
                    String tipoDeduccion = campos[3];
                    double valorDeduccion = Float.parseFloat(campos[4]);
                    
                    ConceptoDeduccion deduccion = new ConceptoDeduccion(ficha, fechaCorte, concepto , tipoDeduccion, valorDeduccion);
                    nuevo_deduccion.crear(deduccion);
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return nuevo_deduccion;
    }

    public int[] getEmpleadosDir() {
        File directorio = new File(carpeta);
        File[] archivos = directorio.listFiles();

        if (directorio.isDirectory()) {
            Arrays.asList(archivos).sort((a, b) -> b.getName().compareTo(a.getName()));
            int[] directorios_empleados = new int[archivos.length];
            int index = 0;
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    directorios_empleados[index] = Integer.parseInt(archivo.getName());
                    index++;
                }
            }
            return directorios_empleados;
        } else {
            System.out.println("La ruta especificada no es una carpeta válida.");
            return new int[0];
        }
    }


    public void crearArchivosCSV() {
        for (Map.Entry<Integer, ConceptoDeduccionDAO> entry : empleadosDAOS.entrySet()) {
            int id_empleado = entry.getKey();
            ConceptoDeduccionDAO dao = entry.getValue();
            List<ConceptoDeduccion> deducciones = dao.obtenerTodos();

            String nombreArchivo = carpeta + id_empleado + "/deducciones.csv";
            try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
                // Escribir encabezados en el archivo CSV
                writer.println("Ficha,FechaCorte,Concepto,TipoDeduccion,ValorDeduccion");

                // Escribir los datos de deducciones en el archivo CSV
                for (ConceptoDeduccion deduccion : deducciones) {
                    writer.println(deduccion.getFicha() + "," + deduccion.getFechaCorte() + "," + deduccion.getNombre() +"," + deduccion.getTipoDeduccion() + "," + deduccion.getValorDeduccion());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void crearDeduccionesAuto() {
    	int[] directorios = getEmpleadosDir();
    	Random random = new Random();
    	
    	for(int directorio : directorios) {
    		int numeroAleatorio1 = random.nextInt(9000) + 1000;
    		int numeroAleatorio2 = random.nextInt(9000) + 1000;
    		ConceptoDevengoDAO devengo = devengo_controlador.getMapDevengosDAO().get(directorio);
    		double sumatoriaDevengos = devengo_controlador.sumatoria(devengo);
    		ConceptoDevengo ultimo_devengo = devengo.obtener(devengo.obtenerTodos().size()-1);
    		Date fecha = ultimo_devengo.getFecha();
    		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");

    		String transformar_fecha = formatoFecha.format(fecha);

    		
    		crearDeduccionAuto(directorio,numeroAleatorio1,transformar_fecha,"Pago de salud","Automatica",sumatoriaDevengos);
    		crearDeduccionAuto(directorio,numeroAleatorio2,transformar_fecha,"Fondo de Pensión","Automatica",sumatoriaDevengos);
    	}
    	
    }
    
    public void prestamo(int id, double valor_prestar) {
    	//int[] directorios = getEmpleadosDir();
    	ConceptoDeduccionDAO dao = seleccionarDAO(id);
    	Random random = new Random();
    	int numeroAleatorio = random.nextInt(9000) + 1000;
		ConceptoDeduccion ultimo_devengo = dao.obtener(dao.obtenerTodos().size()-1);
		String fecha = ultimo_devengo.getFechaCorte();
    	
    	ConceptoDeduccion deduccion_prestamo = new ConceptoDeduccion(numeroAleatorio,fecha,"PRESTAMO","POR VALOR", valor_prestar);
    	dao.crear(deduccion_prestamo);
    }

    public void crearDeduccionAuto(int id_empleado, int ficha, String fechaCorte, String concepto,String tipoDeduccion, double sumatoriaDevengos) {
        ConceptoDeduccionDAO deduccionDAO = seleccionarDAO(id_empleado);
       
        ConceptoDeduccion deduccion = new ConceptoDeduccion(ficha, fechaCorte, concepto ,tipoDeduccion, sumatoriaDevengos);
        deduccion.calcularValorAuto(sumatoriaDevengos);
        deduccionDAO.crear(deduccion);
        crearArchivo(id_empleado, deduccionDAO);
    }

    public void eliminarDeduccion(int id_empleado, int ficha) {
        ConceptoDeduccionDAO deduccionDAO = seleccionarDAO(id_empleado);
        deduccionDAO.eliminar(ficha);
        crearArchivo(id_empleado, deduccionDAO);
    }

    public void actualizarDeduccion(int id_empleado, int ficha, String fechaCorte, String concepto , String tipoDeduccion, double sumatoriaDevengos) {
        ConceptoDeduccionDAO deduccionDAO = seleccionarDAO(id_empleado);
        
        ConceptoDeduccion deduccion = new ConceptoDeduccion(ficha, fechaCorte, concepto,tipoDeduccion, sumatoriaDevengos);
        deduccion.calcularValorAuto(sumatoriaDevengos);
        
        deduccionDAO.actualizar(ficha, deduccion);
        crearArchivo(id_empleado, deduccionDAO);
    }

    public void crearArchivo(int id_empleado, ConceptoDeduccionDAO deduccionDAO) {
        String carpetaEmpleado = carpeta + id_empleado;
        File directorio = new File(carpetaEmpleado);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        String nombreArchivo = carpetaEmpleado + "/deducciones.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados en el archivo CSV
            writer.println("Ficha,FechaCorte,Concepto,TipoDeduccion,ValorDeduccion");

            // Escribir los datos de deducciones en el archivo CSV
            List<ConceptoDeduccion> deducciones = deduccionDAO.obtenerTodos();
            for (ConceptoDeduccion deduccion : deducciones) {
                writer.println(deduccion.getFicha() + "," + deduccion.getFechaCorte() + "," + deduccion.getNombre() +"," + deduccion.getTipoDeduccion() + "," + deduccion.getValorDeduccion());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void reverseFileArray(File[] files) {
        int left = 0;
        int right = files.length - 1;

        while (left < right) {
            File temp = files[left];
            files[left] = files[right];
            files[right] = temp;
            left++;
            right--;
        }
    }
    
}