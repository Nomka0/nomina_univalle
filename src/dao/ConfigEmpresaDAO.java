package dao;

import modelo.ConfigEmpresa;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigEmpresaDAO {
    private static final String FILE_PATH = "src/backup/ConfigEmpresa.txt";

    public void guardarDatos(ConfigEmpresa empresa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String data = convertirDatosAString(empresa);
            writer.write(data);
            writer.newLine();
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public List<ConfigEmpresa> cargarDatos() {
    List<ConfigEmpresa> empresas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 10) { // Validar que haya 10 campos
                ConfigEmpresa empresa = convertirDatosAModelo(data);
                empresas.add(empresa);
            }
        }
        System.out.println("Datos cargados correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }

    return empresas;
}


public void eliminarDato(ConfigEmpresa empresa) {
    List<ConfigEmpresa> empresas = cargarDatos();
    empresas.remove(empresa);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
        for (ConfigEmpresa e : empresas) {
            String data = convertirDatosAString(e);
            writer.write(data);
            writer.newLine();
        }
        System.out.println("Datos eliminados correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void actualizarArchivo(List<ConfigEmpresa> empresas) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
        for (ConfigEmpresa e : empresas) {
            String data = convertirDatosAString(e);
            writer.write(data);
            writer.newLine();
        }
        System.out.println("Archivo actualizado correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    private String convertirDatosAString(ConfigEmpresa empresa) {
        return empresa.getNit() + "," + empresa.getNombre() + "," + empresa.getTelefono() + "," +
                empresa.getDireccion() + "," + empresa.getRepresentanteLegal() + "," +
                empresa.getCorreoContacto() + "," + empresa.getArl() + "," +
                empresa.getCajaCompensacion() + "," + empresa.getSalarioMinimo() + "," +
                empresa.getAuxilioTransporte();
    }

private ConfigEmpresa convertirDatosAModelo(String[] data) {
    if (data.length < 10) {
        // No hay suficientes elementos en el arreglo
        throw new IllegalArgumentException("Datos incompletos: " + Arrays.toString(data));
    }

    String nit = data[0];
    String nombre = data[1];
    String telefono = data[2];
    String direccion = data[3];
    String representanteLegal = data[4];
    String correoContacto = data[5];
    String arl = data[6];
    String cajaCompensacion = data[7];
    String salarioMinimo = data[8];
    String auxilioTransporte = data[9];

    return new ConfigEmpresa(nit, nombre, telefono, direccion, representanteLegal, correoContacto,
            arl, cajaCompensacion, salarioMinimo, auxilioTransporte);
}




}
