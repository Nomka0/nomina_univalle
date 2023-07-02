package controlador;

import dao.ConceptoDeduccionDAO;
import modelo.ConceptoDeduccion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConceptoDeduccionControlador {
    private String carpeta;
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
        ConceptoDeduccionDAO dao = seleccionarDAO(id_empleado);
        List<String> archivos = dao.getArchivos();

        if (archivos.isEmpty()) {
            System.out.println("No hay archivos para el empleado con ID: " + id_empleado);
        } else {
            System.out.println("Archivos del empleado con ID: " + id_empleado);
            for (String archivo : archivos) {
                System.out.println(archivo);
            }
        }
    }

    public void leerSubArchivos() {
        File carpetaEmpleado = new File(carpeta);
        File[] archivos = carpetaEmpleado.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    leerArchivo(Integer.parseInt(archivo.getName().split("\\.")[0]));
                }
            }
        }
    }

    public ConceptoDeduccionDAO leerArchivo(int id_empleado) {
        ConceptoDeduccionDAO dao = seleccionarDAO(id_empleado);
        String archivoPath = carpeta + id_empleado + ".csv";

        try {
            Scanner scanner = new Scanner(new File(archivoPath));
            List<ConceptoDeduccion> deducciones = dao.getDeducciones();

            deducciones.clear();

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] valores = linea.split(",");

                if (valores.length == 3) {
                    int id = Integer.parseInt(valores[0]);
                    String nombre = valores[1];
                    double monto = Double.parseDouble(valores[2]);

                    ConceptoDeduccion deduccion = new ConceptoDeduccion(id, nombre, monto);
                    deducciones.add(deduccion);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo para el empleado con ID: " + id_empleado);
        }

        return dao;
    }

    public void crearArchivosCSV() {
        File carpetaEmpleados = new File(carpeta);
        if (!carpetaEmpleados.exists()) {
            carpetaEmpleados.mkdirs();
        }

        for (int id_empleado : empleadosDAOS.keySet()) {
            ConceptoDeduccionDAO dao = empleadosDAOS.get(id_empleado);
            String archivoPath = carpeta + id_empleado + ".csv";

            try {
                FileWriter fileWriter = new FileWriter(archivoPath);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                for (ConceptoDeduccion deduccion : dao.getDeducciones()) {
                    printWriter.println(deduccion.getId() + "," + deduccion.getNombre() + "," + deduccion.getMonto());
                }

                printWriter.close();
                System.out.println("Archivo CSV creado para el empleado con ID: " + id_empleado);
            } catch (IOException e) {
                System.out.println("Error al crear el archivo CSV para el empleado con ID: " + id_empleado);
            }
        }
    }

    public void agregarDeduccion(int id_empleado, ConceptoDeduccion deduccion) {
        ConceptoDeduccionDAO dao = seleccionarDAO(id_empleado);
        dao.crear(deduccion);
    }

    public List<ConceptoDeduccion> obtenerDeducciones(int id_empleado) {
        ConceptoDeduccionDAO dao = seleccionarDAO(id_empleado);
        return dao.obtenerTodos();
    }

    public void eliminarDeduccion(int id_empleado, int id_deduccion) {
        ConceptoDeduccionDAO dao = seleccionarDAO(id_empleado);
        dao.eliminar(id_deduccion);
    }

    public void actualizarDeduccion(int id_empleado, ConceptoDeduccion deduccion) {
        ConceptoDeduccionDAO dao = seleccionarDAO(id_empleado);
        dao.actualizar(deduccion);
    }
}
