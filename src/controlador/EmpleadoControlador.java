package controlador;

import modelo.Empleado;
import vista.BotonesClase;
import vista.EmpleadoVista;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class EmpleadoControlador {
    private EmpleadoVista vista;
    private List<Empleado> listaEmpleados;
    private Object[][] dataEmpleados;
    String rutaArchivo = "src/backup/empleado.txt";

    public EmpleadoControlador(EmpleadoVista vista) {
        this.vista = vista;
        this.listaEmpleados = new ArrayList<>();
        ButtonClickListener listener = new ButtonClickListener();
        // Agregar listeners a los botones
        vista.btnGuardarEmpleado.addActionListener(listener);
        vista.btnEditarEmpleado.addActionListener(listener);
        vista.btnEliminarEmpleado.addActionListener(listener);
        vista.btnListarEmpleados.addActionListener(listener);
        vista.btnVerDetalles.addActionListener(listener);
        vista.btnOpcionesAdicionales.addActionListener(listener);
        vista.btnVolver.addActionListener(listener);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // System.out.println("Se ha presionado un botón");
            if (e.getSource() == vista.btnGuardarEmpleado) {
                int codigo = Integer.parseInt(vista.txtCodigo.getText());
                String nombres = vista.txtNombres.getText();
                String apellidos = vista.txtApellidos.getText();
                String fechaIngreso = vista.txtFechaIngreso.getText();
                String fechaRetiro = vista.txtFechaRetiro.getText();
                String direccion = vista.txtTipoTrabajador.getText();
                // System.out.println("Datos del empleado: " + codigo + " " + nombres + " " +
                // apellidos + " " + fechaIngreso + " " + fechaRetiro + " " + direccion);
                // Crear un nuevo objeto Empleado con los datos ingresados
                Empleado empleado = new Empleado(codigo, nombres, apellidos, fechaIngreso, fechaRetiro, direccion);

                // Agregar el nuevo empleado a la lista
                listaEmpleados.add(empleado);

                // Agregar el nuevo empleado a la tabla
                DefaultTableModel model = (DefaultTableModel) vista.tablaEmpleados.getModel();
                model.addRow(getDatosEmpleado(empleado));

                // Limpiar los campos de entrada
                setCamposVacios();

                // Guardar los datos en un archivo de texto
                String datosEmpleado = empleado.toString();
                String rutaArchivo = "src/backup/empleado.txt";
                try {
                    FileWriter fileWriter = new FileWriter(rutaArchivo, true);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.println(datosEmpleado);
                    printWriter.close();
                    System.out.println("Los datos se han guardado en el archivo de texto correctamente.");
                } catch (IOException ex) {
                    System.out.println("Error al guardar los datos en el archivo de texto: " + ex.getMessage());
                }
            } else if (e.getSource() == vista.btnEditarEmpleado) {
                int filaSeleccionada = vista.tablaEmpleados.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    int codigo = Integer.parseInt(vista.txtCodigo.getText());
                    String nombres = vista.txtNombres.getText();
                    String apellidos = vista.txtApellidos.getText();
                    String fechaIngreso = vista.txtFechaIngreso.getText();
                    String fechaRetiro = vista.txtFechaRetiro.getText();
                    String direccion = vista.txtTipoTrabajador.getText();

                    // Actualizar el empleado en la lista
                    Empleado empleado = listaEmpleados.get(filaSeleccionada);
                    empleado.setCodigo(codigo);
                    empleado.setNombre(nombres);
                    empleado.setApellido(apellidos);
                    empleado.setFechaIngreso(fechaIngreso);
                    empleado.setFechaRetiro(fechaRetiro);
                    empleado.setDireccion(direccion);

                    // Actualizar la fila enla tabla
                    DefaultTableModel model = (DefaultTableModel) vista.tablaEmpleados.getModel();
                    model.setValueAt(codigo, filaSeleccionada, 0);
                    model.setValueAt(nombres, filaSeleccionada, 1);
                    model.setValueAt(apellidos, filaSeleccionada, 2);
                    model.setValueAt(fechaIngreso, filaSeleccionada, 3);
                    model.setValueAt(fechaRetiro, filaSeleccionada, 4);
                    model.setValueAt(direccion, filaSeleccionada, 5);

                    setCamposVacios();

                    JOptionPane.showMessageDialog(vista, "Empleado editado correctamente.", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(vista, "Seleccione un empleado de la tabla para editar.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == vista.btnEliminarEmpleado) {
                int filaSeleccionada = vista.tablaEmpleados.getSelectedRow();
                System.out.println("Fila seleccionada: " + filaSeleccionada);
                eliminarUltimasLineasArchivo(rutaArchivo);

                if (filaSeleccionada >= 0) {
                    listaEmpleados.remove(filaSeleccionada);

                    DefaultTableModel model = (DefaultTableModel) vista.tablaEmpleados.getModel();
                    model.removeRow(filaSeleccionada);

                    setCamposVacios();

                    JOptionPane.showMessageDialog(vista, "Empleado eliminado correctamente.", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(vista, "Seleccione un empleado de la tabla para eliminar.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == vista.btnListarEmpleados) {

                cargarDatosDesdeArchivo();

                DefaultTableModel model = (DefaultTableModel) vista.tablaEmpleados.getModel();
                model.setRowCount(0); // Limpiar la tabla
                System.out.println("Cantidad de empleados: " + listaEmpleados.size());
                for (Empleado empleado : listaEmpleados) {
                    model.addRow(new Object[] {
                            empleado.getCodigo(),
                            empleado.getNombre(),
                            empleado.getApellido(),
                            empleado.getFechaIngreso(),
                            empleado.getFechaRetiro(),
                            empleado.getDireccion(),
                    });
                }
            } else if (e.getSource() == vista.btnVerDetalles) {
                int filaSeleccionada = vista.tablaEmpleados.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    Empleado empleado = listaEmpleados.get(filaSeleccionada);

                    vista.setCodigo(empleado.getCodigo());
                    vista.setNombres(empleado.getNombre());
                    vista.setApellidos(empleado.getApellido());
                    vista.setFechaIngreso(empleado.getFechaIngreso());
                    vista.setFechaRetiro(empleado.getFechaRetiro());
                    vista.setTipoTrabajador(empleado.getDireccion());
                } else {
                    JOptionPane.showMessageDialog(vista, "Seleccione un empleado de la tabla para ver los detalles.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == vista.btnVolver) {
                vista.setVisible(false);

            }
        }

        private Object[] getDatosEmpleado(Empleado empleado) {
            Object[] datos = new Object[6];
            datos[0] = empleado.getCodigo();
            datos[1] = empleado.getNombre();
            datos[2] = empleado.getApellido();
            datos[3] = empleado.getFechaIngreso();
            datos[4] = empleado.getFechaRetiro();
            datos[5] = empleado.getDireccion();
            return datos;
        }
    }

    public void setCamposVacios() {
        vista.setCodigo(0);
        vista.setNombres("");
        vista.setApellidos("");
        vista.setFechaIngreso("");
        vista.setFechaRetiro("");
        vista.setTipoTrabajador("");
    }

    private void cargarDatosDesdeArchivo() {
        String rutaArchivo = "src/backup/empleado.txt"; // Ruta del archivo de texto

        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();

                // Ignorar las líneas que no contienen datos de empleado
                if (linea.startsWith("Codigo:")) {
                    String codigoString = linea.split(":")[1].trim();
                    int codigo = Integer.parseInt(codigoString);

                    String nombres = scanner.nextLine().split(":")[1].trim();
                    String apellidos = scanner.nextLine().split(":")[1].trim();
                    String fechaIngreso = scanner.nextLine().split(":")[1].trim();
                    String fechaRetiro = scanner.nextLine().split(":")[1].trim();
                    String direccion = scanner.nextLine().split(":")[1].trim();

                    Empleado empleado = new Empleado(codigo, nombres, apellidos, fechaIngreso, fechaRetiro, direccion);
                    listaEmpleados.add(empleado);
                }
            }

            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo de texto no existe: " + ex.getMessage());
        }

    }

    public void addDatosTablaEmpleados(Empleado eps) {

        // Crear una nueva matriz temporal con una fila adicional
        Object[][] newData = new Object[dataEmpleados.length + 1][];

        // Copiar los elementos existentes de dataEmpleados a newData
        for (int i = 0; i < dataEmpleados.length; i++) {
            newData[i] = dataEmpleados[i];
        }

        // Añadir el nuevo elemento a newData
        newData[newData.length - 1] = getDatosEmpleado(eps);

        // Asignar newData a dataEmpleados
        dataEmpleados = newData;

        // Actualizar el modelo de la tabla de epss
        SwingUtilities.invokeLater(() -> {
            vista.tablaEmpleados.setModel(getModeloTablaEmpleados());
        });
    }

    public Object[] getDatosEmpleado(Empleado empleado) {
        Object[] datos = new Object[6];
        datos[0] = empleado.getCodigo();
        datos[1] = empleado.getNombre();
        datos[2] = empleado.getApellido();
        datos[3] = empleado.getFechaIngreso();
        datos[4] = empleado.getFechaRetiro();
        datos[5] = empleado.getTipoTrabajador();
        return datos;
    }

    public DefaultTableModel getModeloTablaEmpleados() {
        DefaultTableModel modeloTabla = new DefaultTableModel(
                dataEmpleados,
                new String[] {
                        "Codigo", "Nombres", "Apellidos", "Fecha Ingreso", "Fecha Retiro", "Tipo Trabajador"
                });
        return modeloTabla;
    }

    private void eliminarUltimasLineasArchivo(String rutaArchivo) {
        int filaSeleccionada = vista.tablaEmpleados.getSelectedRow();
        filaSeleccionada++; // Aumentar en 1 para que coincida con el número de línea
        System.out.println("Fila seleccionada: " + filaSeleccionada);
        try {
            List<String> lineas = new ArrayList<>();

            // Leer todas las líneas del archivo
            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    lineas.add(linea);
                }
            }

            // Obtener el índice de inicio y fin para eliminar las líneas
            int indiceInicio = (filaSeleccionada - 1) * 6;
            System.out.println("Indice inicio: " + indiceInicio);
            int indiceFin = indiceInicio + 6;

            // Verificar que los índices sean válidos
            if (indiceInicio >= 0 && indiceFin <= lineas.size()) {
                // Eliminar las líneas seleccionadas
                lineas.subList(indiceInicio, indiceFin).clear();

                // Escribir el contenido actualizado en el archivo
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                    for (String linea : lineas) {
                        writer.write(linea);
                        writer.newLine();
                    }
                }

                System.out.println("Se han eliminado las líneas del archivo.");
            } else {
                System.out.println("Los índices de las líneas a eliminar no son válidos.");
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

}
