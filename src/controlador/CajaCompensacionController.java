package controlador;

import vista.CajaCompensacionVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class CajaCompensacionController {

    private CajaCompensacionVista vista;
    private static final String RUTA_BACKUP = "txt";

    public CajaCompensacionController(CajaCompensacionVista vista) {
        this.vista = vista;
        this.vista.getBtnGuardar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatosEnTabla();
                try {
                    crearArchivoBackup();
                } catch (IOException ex) {
                    Logger.getLogger(CajaCompensacionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.vista.getBtnListar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listarDatos();
                } catch (IOException ex) {
                    Logger.getLogger(CajaCompensacionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.vista.getBtnEditar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarDatos();
            }
        });

        this.vista.getBtnEliminar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarDatos();
            }
        });
    }

    private void guardarDatosEnTabla() {
        String nombre = vista.getTxtNombreCajaCompensacion().getText();
        String codigo = vista.getTxtCodigoCajaCompensacion().getText();
        String fechaNacimiento = vista.getTxtFechaNacimiento().getText();
        String fechaIngreso = vista.getTxtFechaIngreso().getText();
        String fechaRetiro = vista.getTxtFechaRetiro().getText();
        String tipoTrabajador = vista.getTxtTipoTrabajador().getText();
        String tipoSalario = vista.getTxtTipoSalario().getText();
        String numeroCuenta = vista.getTxtNumeroCuenta().getText();

        DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel();
        model.addRow(
                new Object[]{nombre, codigo, fechaNacimiento, fechaIngreso, fechaRetiro, tipoTrabajador, tipoSalario,
                        numeroCuenta});

        vista.getTxtNombreCajaCompensacion().setText("");
        vista.getTxtCodigoCajaCompensacion().setText("");
        vista.getTxtFechaNacimiento().setText("");
        vista.getTxtFechaIngreso().setText("");
        vista.getTxtFechaRetiro().setText("");
        vista.getTxtTipoTrabajador().setText("");
        vista.getTxtTipoSalario().setText("");
        vista.getTxtNumeroCuenta().setText("");
    }

    private void crearArchivoBackup() throws IOException {
        String nombreArchivo = "/cajacompensacion.txt";
        String rutaArchivo = RUTA_BACKUP + nombreArchivo;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel();
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();

            for (int i = 0; i < columnCount; i++) {
                writer.write(model.getColumnName(i));
                if (i < columnCount - 1) {
                    writer.write("\t");
                }
            }
            writer.newLine();

            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    Object value = model.getValueAt(row, col);
                    writer.write(value.toString());
                    if (col < columnCount - 1) {
                        writer.write("\t");
                    }
                }
                writer.newLine();
            }

            System.out.println("Archivo de backup creado exitosamente.");
        }
    }

    private void listarDatos() throws IOException {
        // Implementa la lógica para listar los datos en la vista
            try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_BACKUP + "/cajacompensacion.txt"))) {
            DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel();
            model.setRowCount(0); // Limpiar la tabla antes de listar los datos

            // Leer la primera línea para obtener los nombres de las columnas
            String columnLine = reader.readLine();
            String[] columnNames = columnLine.split("\t");
            model.setColumnIdentifiers(columnNames);

            // Leer las líneas restantes para obtener los datos
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                model.addRow(data);
            }
                }
    }

        private void editarDatos() {
        int selectedRow = vista.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = vista.getTxtNombreCajaCompensacion().getText();
        String codigo = vista.getTxtCodigoCajaCompensacion().getText();
        String fechaNacimiento = vista.getTxtFechaNacimiento().getText();
        String fechaIngreso = vista.getTxtFechaIngreso().getText();
        String fechaRetiro = vista.getTxtFechaRetiro().getText();
        String tipoTrabajador = vista.getTxtTipoTrabajador().getText();
        String tipoSalario = vista.getTxtTipoSalario().getText();
        String numeroCuenta = vista.getTxtNumeroCuenta().getText();

        DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel();
        model.setValueAt(nombre, selectedRow, 0);
        model.setValueAt(codigo, selectedRow, 1);
        model.setValueAt(fechaNacimiento, selectedRow, 2);
        model.setValueAt(fechaIngreso, selectedRow, 3);
        model.setValueAt(fechaRetiro, selectedRow, 4);
        model.setValueAt(tipoTrabajador, selectedRow, 5);
        model.setValueAt(tipoSalario, selectedRow, 6);
        model.setValueAt(numeroCuenta, selectedRow, 7);

        // Actualizar el archivo de backup con los nuevos datos
        actualizarArchivoBackup();
    }
/*
    private void actualizarArchivoBackup() {
        String rutaArchivo = RUTA_BACKUP + "/cajacompensacion.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel();
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();

            // Escribir los encabezados de las columnas en el archivo
            for (int i = 0; i < columnCount; i++) {
                writer.write(model.getColumnName(i));
                if (i < columnCount - 1) {
                    writer.write("\t");
                }
            }
            writer.newLine();

            // Escribir los datos de cada fila en el archivo
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    Object value = model.getValueAt(row, col);
                    writer.write(value.toString());
                    if (col < columnCount - 1) {
                        writer.write("\t");
                    }
                }
                writer.newLine();
            }

            System.out.println("Archivo de backup actualizado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

    

        private void eliminarDatos() {
        int selectedRow = vista.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel();
        model.removeRow(selectedRow);

        // Actualizar el archivo de backup después de eliminar los datos
        actualizarArchivoBackup();
    }

    private void actualizarArchivoBackup() {
        String rutaArchivo = RUTA_BACKUP + "/cajacompensacion.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel();
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();

            // Escribir los encabezados de las columnas en el archivo
            for (int i = 0; i < columnCount; i++) {
                writer.write(model.getColumnName(i));
                if (i < columnCount - 1) {
                    writer.write("\t");
                }
            }
            writer.newLine();

            // Escribir los datos de cada fila en el archivo
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    Object value = model.getValueAt(row, col);
                    writer.write(value.toString());
                    if (col < columnCount - 1) {
                        writer.write("\t");
                    }
                }
                writer.newLine();
            }

            System.out.println("Archivo de backup actualizado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}