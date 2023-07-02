package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.ConceptoDeduccionDAO;
import modelo.ConceptoDeduccion;

import java.util.Arrays;
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

    public int[] getEmpleadosDir() {
        File directorio = new File(carpeta);
        File[] archivos = directorio.listFiles();

        if (directorio.isDirectory()) {
            Arrays.asList(archivos).sort((a, b) -> b.getName().compareTo(a.getName()));

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
            ConceptoDeduccionDAO dao_test = empleadosDAOS.get(directorio);
            ConceptoDeduccion ultimo_dao = dao_test.obtener(dao_test.obtenerTodos().size() - 1);
            String tipo_deduccion = ultimo_dao.getNombre();
            System.out.println("Total de deducciones: " + dao_test.obtenerTodos());
            System.out.println("Última deducción: " + tipo_deduccion);
        }
        System.out.println("Empleados y deducciones: " + empleadosDAOS);
    }

    public void agregarRegistro(int id_empleado, String nombre, double monto) {
        ConceptoDeduccionDAO dao_empleado = seleccionarDAO(id_empleado);
        dao_empleado.agregar(new ConceptoDeduccion(nombre, monto));
    }

    public void eliminarRegistro(int id_empleado, int index) {
        ConceptoDeduccionDAO dao_empleado = seleccionarDAO(id_empleado);
        dao_empleado.eliminar(index);
    }

    public void guardarCambios(int id_empleado) {
        ConceptoDeduccionDAO dao_empleado = seleccionarDAO(id_empleado);
        escribirArchivo(dao_empleado, id_empleado);
    }

    public ConceptoDeduccionDAO leerArchivo(int id_empleado) {
        ConceptoDeduccionDAO dao_empleado = new ConceptoDeduccionDAO();

        File archivo = new File(carpeta + id_empleado + "/deducciones.csv");
        if (archivo.exists()) {
            try {
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    String[] campos = linea.split(",");

                    if (campos.length == 2) {
                        String nombre = campos[0];
                        double monto = Double.parseDouble(campos[1]);

                        dao_empleado.agregar(new ConceptoDeduccion(nombre, monto));
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return dao_empleado;
    }

    public void escribirArchivo(ConceptoDeduccionDAO dao_empleado, int id_empleado) {
        try {
            FileWriter fileWriter = new FileWriter(carpeta + id_empleado + "/deducciones.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            List<ConceptoDeduccion> deducciones = dao_empleado.obtenerTodos();
            for (ConceptoDeduccion deduccion : deducciones) {
                printWriter.println(deduccion.getNombre() + "," + deduccion.getMonto());
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reverseFileArray(File[] files) {
        int i = 0;
        int j = files.length - 1;
        File tmp;

        while (j > i) {
            tmp = files[j];
            files[j] = files[i];
            files[i] = tmp;
            j--;
            i++;
        }
    }
}
