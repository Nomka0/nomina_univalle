package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import dao.ConceptoDeduccionDAO;
import modelo.ConceptoDeduccion;

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

    public int[] getEmpleadosDir() {
        File directorio = new File(carpeta);
        File[] archivos = directorio.listFiles();

        if (directorio.isDirectory()) {
            Arrays.sort(archivos, (a, b) -> b.getName().compareTo(a.getName()));

            int[] nombres_subdirectorios = new int[archivos.length];
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].isDirectory()) {
                    try {
                        nombres_subdirectorios[i] = Integer.parseInt(archivos[i].getName());
                        System.out.println("Directorio: " + nombres_subdirectorios[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("El nombre del subdirectorio no es un número válido.");
                    }
                }
            }
            return nombres_subdirectorios;
        } else {
            System.out.println("La ruta no corresponde a un directorio válido.");
            return new int[0];
        }
    }

    public void leerSubArchivos() {
        int[] directorios_empleados = getEmpleadosDir();

        for (int directorio : directorios_empleados) {
            empleadosDAOS.put(directorio, leerArchivo(directorio));
        }
        System.out.println(empleadosDAOS);
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
                    String fecha = campos[1];
                    String concepto = campos[2];
                    float monto = Float.parseFloat(campos[3]);

                    ConceptoDeduccion deduccion = new ConceptoDeduccion(ficha, concepto, fecha, monto);
                    nuevo_deduccion.crear(deduccion);
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return nuevo_deduccion;
    }

    public static void reverseFileArray(File[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            File temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
