package controlador;

import dao.ConfigEmpresaDAO;
import modelo.ConfigEmpresa;
import vista.ConfigEmpresaVista;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class ConfigEmpresaControlador {
    private ConfigEmpresaVista vista;
    private ConfigEmpresaDAO dao;

    public ConfigEmpresaControlador(ConfigEmpresaVista vista, ConfigEmpresaDAO dao) {
        this.vista = vista;
        this.dao = dao;

        // Agrega los ActionListeners a los botones
        this.vista.agregarGuardarListener(new GuardarListener());
        this.vista.agregarListarListener(new ListarListener());
        this.vista.agregarEditarListener(new EditarListener());
        this.vista.agregarEliminarListener(new EliminarListener());
    }

    private void guardarDatos() {
        String nit = vista.getNIT();
        String nombre = vista.getNombre();
        String telefono = vista.getTelefono();
        String direccion = vista.getDireccion();
        String representanteLegal = vista.getRepresentanteLegal();
        String correoContacto = vista.getCorreoContacto();
        String arl = vista.getARL();
        String cajaCompensacion = vista.getCajaCompensacion();
        String salarioMinimo = vista.getSalarioMinimo();
        String auxilioTransporte = vista.getAuxilioTransporte();
       
           ConfigEmpresa empresa = new ConfigEmpresa(nit, nombre, telefono, direccion, representanteLegal,
            correoContacto, arl, cajaCompensacion, salarioMinimo, auxilioTransporte);

    // Guardar en la base de datos o en memoria
    dao.guardarDatos(empresa);

    // Guardar en el archivo de texto
    try {
        FileWriter fileWriter = new FileWriter("src/backup/ConfigEmpresa.txt", true); // true para agregar al final del archivo
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Escribir los datos en el archivo
        printWriter.println(empresa.toString());

        // Cerrar el flujo de escritura
        printWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    vista.limpiarCampos();
        
    }

    private void cargarDatos() {
        List<ConfigEmpresa> empresas = dao.cargarDatos();
        DefaultTableModel model = vista.getTableModel();
        model.setRowCount(0); // Limpiar la tabla

        for (ConfigEmpresa empresa : empresas) {
            model.addRow(empresa.toArray());
        }
    }
private void editarDato() {
    int selectedRow = vista.getSelectedRow();
    if (selectedRow == -1) {
        vista.mostrarMensaje("Selecciona una fila para editar.");
        return;
    }

    String nit = vista.getNIT();
    String nombre = vista.getNombre();
    String telefono = vista.getTelefono();
    String direccion = vista.getDireccion();
    String representanteLegal = vista.getRepresentanteLegal();
    String correoContacto = vista.getCorreoContacto();
    String arl = vista.getARL();
    String cajaCompensacion = vista.getCajaCompensacion();
    String salarioMinimo = vista.getSalarioMinimo();
    String auxilioTransporte = vista.getAuxilioTransporte();

    ConfigEmpresa empresa = new ConfigEmpresa(nit, nombre, telefono, direccion, representanteLegal,
            correoContacto, arl, cajaCompensacion, salarioMinimo, auxilioTransporte);

    DefaultTableModel model = vista.getTableModel();
    model.setValueAt(nit, selectedRow, 0);
    model.setValueAt(nombre, selectedRow, 1);
    model.setValueAt(telefono, selectedRow, 2);
    model.setValueAt(direccion, selectedRow, 3);
    model.setValueAt(representanteLegal, selectedRow, 4);
    model.setValueAt(correoContacto, selectedRow, 5);
    model.setValueAt(arl, selectedRow, 6);
    model.setValueAt(cajaCompensacion, selectedRow, 7);
    model.setValueAt(salarioMinimo, selectedRow, 8);
    model.setValueAt(auxilioTransporte, selectedRow, 9);

    // Actualizar el archivo de texto
    try {
        FileWriter fileWriter = new FileWriter("src/backup/ConfigEmpresa.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        int rowCount = model.getRowCount();

        // Recorrer la tabla y escribir todas las filas en el archivo
        for (int i = 0; i < rowCount; i++) {
            String row = "";
            for (int j = 0; j < model.getColumnCount(); j++) {
                row += model.getValueAt(i, j) + ",";
            }
            printWriter.println(row);
        }

        // Cerrar el flujo de escritura
        printWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    vista.limpiarCampos();
}

/*
    private void eliminarDato() {
        int selectedRow = vista.getSelectedRow();
        if (selectedRow == -1) {
            vista.mostrarMensaje("Selecciona una fila para eliminar.");
            return;
        }

        DefaultTableModel model = vista.getTableModel();
        String nit = (String) model.getValueAt(selectedRow, 0);
        String nombre = (String) model.getValueAt(selectedRow, 1);
        String telefono = (String) model.getValueAt(selectedRow, 2);
        String direccion = (String) model.getValueAt(selectedRow, 3);
        String representanteLegal = (String) model.getValueAt(selectedRow, 4);
        String correoContacto = (String) model.getValueAt(selectedRow, 5);
        String arl = (String) model.getValueAt(selectedRow, 6);
        String cajaCompensacion = (String) model.getValueAt(selectedRow, 7);
        String salarioMinimo = (String) model.getValueAt(selectedRow, 8);
        String auxilioTransporte = (String) model.getValueAt(selectedRow, 9);
           ConfigEmpresa empresa = new ConfigEmpresa(nit, nombre, telefono, direccion, representanteLegal,
            correoContacto, arl, cajaCompensacion, salarioMinimo, auxilioTransporte);

    // Eliminar de la base de datos o de la memoria
    dao.eliminarDato(empresa);

    // Eliminar del archivo de texto
    try {
        FileWriter fileWriter = new FileWriter("src/backup/ConfigEmpresa.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

       // DefaultTableModel model = vista.getTableModel();
        int rowCount = model.getRowCount();

        // Escribir en el archivo solo las filas que no coinciden con el dato eliminado
        for (int i = 0; i < rowCount; i++) {
            if (i != selectedRow) {
                String row = "";
                for (int j = 0; j < model.getColumnCount(); j++) {
                    row += model.getValueAt(i, j) + ",";
                }
                printWriter.println(row);
            }
        }

        // Cerrar el flujo de escritura
        printWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
       
       
    }*/
private void eliminarDato() {
    int selectedRow = vista.getSelectedRow();
    if (selectedRow == -1) {
        vista.mostrarMensaje("Selecciona una fila para eliminar.");
        return;
    }

    DefaultTableModel model = vista.getTableModel();
    String nit = (String) model.getValueAt(selectedRow, 0);
    String nombre = (String) model.getValueAt(selectedRow, 1);
    String telefono = (String) model.getValueAt(selectedRow, 2);
    String direccion = (String) model.getValueAt(selectedRow, 3);
    String representanteLegal = (String) model.getValueAt(selectedRow, 4);
    String correoContacto = (String) model.getValueAt(selectedRow, 5);
    String arl = (String) model.getValueAt(selectedRow, 6);
    String cajaCompensacion = (String) model.getValueAt(selectedRow, 7);
    String salarioMinimo = (String) model.getValueAt(selectedRow, 8);
    String auxilioTransporte = (String) model.getValueAt(selectedRow, 9);

    ConfigEmpresa empresa = new ConfigEmpresa(nit, nombre, telefono, direccion, representanteLegal,
            correoContacto, arl, cajaCompensacion, salarioMinimo, auxilioTransporte);

    // Eliminar de la base de datos o de la memoria
    dao.eliminarDato(empresa);

    // Eliminar del archivo de texto
    try {
        FileWriter fileWriter = new FileWriter("src/backup/ConfigEmpresa.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        int rowCount = model.getRowCount();

        // Escribir en el archivo solo las filas que no coinciden con el dato eliminado
        for (int i = 0; i < rowCount; i++) {
            if (i != selectedRow) {
                String row = "";
                for (int j = 0; j < model.getColumnCount(); j++) {
                    row += model.getValueAt(i, j) + ",";
                }
                printWriter.println(row);
            }
        }

        // Cerrar el flujo de escritura
        printWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Eliminar la fila de la tabla
    model.removeRow(selectedRow);
}





    // ActionListener para el botón de Guardar
    class GuardarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            guardarDatos();
        }
    }

    // ActionListener para el botón de Listar
    class ListarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cargarDatos();
        }
    }

    // ActionListener para el botón de Editar
    class EditarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            editarDato();
        }
    }

    // ActionListener para el botón de Eliminar
    class EliminarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            eliminarDato();
        }
    }
}
