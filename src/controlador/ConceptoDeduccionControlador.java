import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.ConceptoDeduccionDAO;
import modelo.ConceptoDeduccion;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Date;
import java.util.HashMap;

public class ConceptoDeduccionControlador {
    private String carpeta;
    private File[] archivos = {};
    private Map<Integer, ConceptoDeduccionDAO> empleadosDAOS;

    public ConceptoDeduccionControlador() {
        carpeta = "CSVs/empleados/";
        empleadosDAOS = new HashMap<>();
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
        }

        System.out.println("Empleados y deducciones: " + empleadosDAOS);
    }

    public ConceptoDeduccionDAO leerArchivo(int id_empleado) {
        listarArchivos(id_empleado);
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
                    String tipoDeduccion = campos[2];
                    float valorDeduccion = Float.parseFloat(campos[3]);

                    ConceptoDeduccion deduccion = new ConceptoDeduccion(ficha, fechaCorte, tipoDeduccion, valorDeduccion);
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

    public void crearArchivosCSV() {
    for (Map.Entry<Integer, ConceptoDeduccionDAO> entry : empleadosDAOS.entrySet()) {
        int id_empleado = entry.getKey();
        ConceptoDeduccionDAO dao = entry.getValue();
        List<ConceptoDeduccion> deducciones = dao.obtenerTodos();

        String nombreArchivo = carpeta + id_empleado + "/deducciones.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados en el archivo CSV
            writer.println("Ficha,FechaCorte,TipoDeduccion,ValorDeduccion");

            // Escribir los datos de deducciones en el archivo CSV
            for (ConceptoDeduccion deduccion : deducciones) {
                writer.println(deduccion.getFicha() + "," + deduccion.getFechaCorte() + "," + deduccion.getTipoDeduccion() + "," + deduccion.getValorDeduccion());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    public void crearDeduccion(int id_empleado, int ficha, String fechaCorte, String tipoDeduccion, float sumatoriaDevengos, float salarioMinimo) {
        ConceptoDeduccionDAO deduccionDAO = seleccionarDAO(id_empleado);
        double valorDeduccion;

        if (sumatoriaDevengos > salarioMinimo) {
            double porcentajeDeduccion = 0.04; // 4% para salud y fondo de pensión
            valorDeduccion = sumatoriaDevengos * porcentajeDeduccion;
        } else {
            valorDeduccion = 10000; // Valor de la deducción basado en el salario mínimo vigente
        }

        ConceptoDeduccion deduccion = new ConceptoDeduccion(ficha, fechaCorte, tipoDeduccion, valorDeduccion);
        deduccionDAO.crear(deduccion);
        crearArchivo(id_empleado, deduccionDAO);
    }

    public void eliminarDeduccion(int id_empleado, int ficha) {
        ConceptoDeduccionDAO deduccionDAO = seleccionarDAO(id_empleado);
        deduccionDAO.eliminar(ficha);
        crearArchivo(id_empleado, deduccionDAO);
    }

    public void actualizarDeduccion(int id_empleado, int ficha, String fechaCorte, String tipoDeduccion, float sumatoriaDevengos, float salarioMinimo) {
        ConceptoDeduccionDAO deduccionDAO = seleccionarDAO(id_empleado);
        double valorDeduccion;

        if (sumatoriaDevengos > salarioMinimo) {
            double porcentajeDeduccion = 0.04; // 4% para salud y fondo de pensión
            valorDeduccion = sumatoriaDevengos * porcentajeDeduccion;
        } else {
            valorDeduccion = 10000; // Ejemplo, puede cambiarse 
        }

        ConceptoDeduccion deduccion = new ConceptoDeduccion(ficha, fechaCorte, tipoDeduccion, valorDeduccion);
        deduccionDAO.actualizar(ficha, deduccion);
        crearArchivo(id_empleado, deduccionDAO);
    }
}
