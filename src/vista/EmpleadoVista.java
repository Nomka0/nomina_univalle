
package vista;
import modelo.Empleado;

import modelo.Empleado;
import controlador.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmpleadoVista extends JFrame {

    
    
    private JPanel contentPane;
    private JTable tablaEmpleados;
    private JButton btnGuardarEmpleado;
    private JButton btnEditarEmpleado;
    private JButton btnEliminarEmpleado;
    private JButton btnListarEmpleados;
    private JButton btnVerDetalles;
    private JButton btnOpcionesAdicionales;
   
    JLabel lblApellidos;
    JLabel lblFechaIngreso;
    JLabel lblFechaRetiro;
    JLabel lblCodigo;
    JLabel lblNombres;
    
    private JTextField txtCodigo;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtFechaIngreso;
    private JTextField txtFechaRetiro;
    private JTextField txtTipoTrabajador;
    private JComboBox<String> comboBoxEstamento;
    private Object[][] dataEmpleados;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmpleadoVista frame = new EmpleadoVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public EmpleadoVista() {
                setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 660);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        btnEditarEmpleado = new JButton("Editar eps");
        btnEditarEmpleado.setBounds(715, 197, 151, 44);
        contentPane.add(btnEditarEmpleado);
        
        btnEliminarEmpleado = new JButton("Eliminar eps");
        btnEliminarEmpleado.setBounds(715, 275, 151, 44);
        contentPane.add(btnEliminarEmpleado);
        
        // Otros componentes
        
     // Otros componentes
        lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 10, 100, 20);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(20, 30, 174, 20);
        contentPane.add(txtCodigo);
        txtCodigo.setColumns(10);

        lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(223, 10, 100, 20);
        contentPane.add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setBounds(223, 30, 174, 20);
        contentPane.add(txtNombres);
        txtNombres.setColumns(10);

        lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(429, 10, 100, 20);
        contentPane.add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(429, 30, 185, 20);
        contentPane.add(txtApellidos);
        txtApellidos.setColumns(10);

        lblFechaIngreso = new JLabel("EPS:");
        lblFechaIngreso.setBounds(19, 62, 123, 20);
        contentPane.add(lblFechaIngreso);

        txtFechaIngreso = new JTextField();
        txtFechaIngreso.setBounds(19, 82, 175, 20);
        contentPane.add(txtFechaIngreso);
        txtFechaIngreso.setColumns(10);

        lblFechaRetiro = new JLabel("FPP:");
        lblFechaRetiro.setBounds(223, 62, 106, 20);
        contentPane.add(lblFechaRetiro);

        txtFechaRetiro = new JTextField();
        txtFechaRetiro.setBounds(223, 82, 174, 20);
        contentPane.add(txtFechaRetiro);
        txtFechaRetiro.setColumns(10);

        JLabel  lblTipoTrabajador= new JLabel("Direccion: ");
        lblTipoTrabajador.setBounds(429, 62, 120, 20);
        contentPane.add(lblTipoTrabajador);
        
        txtTipoTrabajador = new JTextField();
        txtTipoTrabajador.setBounds(429, 82, 185, 20);
        contentPane.add(txtTipoTrabajador);
        txtTipoTrabajador.setColumns(10);
        

        // JTable para mostrar la lista de epss
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Fecha de Ingreso");
        model.addColumn("Fecha de Retiro");
        model.addColumn("Tipo de Trabajador");

        tablaEmpleados = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        scrollPane.setBounds(12, 114, 691, 430);
        contentPane.add(scrollPane);
        
        //botones y componentes adicionales
        btnGuardarEmpleado = new JButton("Guardar");
        btnGuardarEmpleado.setBounds(726, 29, 130, 55);
        contentPane.add(btnGuardarEmpleado);
        
        btnListarEmpleados = new JButton("Listar epss");
        btnListarEmpleados.setBounds(715, 348, 151, 44);
        contentPane.add(btnListarEmpleados);

        btnVerDetalles = new JButton("Ver detalles");
        btnVerDetalles.setBounds(142, 556, 161, 30);
        contentPane.add(btnVerDetalles);
        
        btnOpcionesAdicionales = new JButton("Opciones adicionales");
        btnOpcionesAdicionales.setBounds(424, 558, 161, 30);
        contentPane.add(btnOpcionesAdicionales);

        // Agregar listeners a los botones
        ButtonClickListener listener = new ButtonClickListener();

        btnGuardarEmpleado.addActionListener(listener);
        btnEditarEmpleado.addActionListener(listener);
        btnEliminarEmpleado.addActionListener(listener);
        btnListarEmpleados.addActionListener(listener);
        btnVerDetalles.addActionListener(listener);
        btnOpcionesAdicionales.addActionListener(listener);
        




    }

    // Clase interna para manejar los eventos de los botones
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnGuardarEmpleado) {
            int codigo = getCodigo();
            String nombres = getNombres();
            String apellidos = getApellidos();
            String fechaIngreso = getFechaIngreso();
            String fechaRetiro = getFechaRetiro();
            String tipoTrabajador = getTipoTrabajador();
            
            // Crear un nuevo objeto Empleado con los datos ingresados
        Empleado empleado = new Empleado(codigo, nombres, apellidos, fechaIngreso, fechaRetiro, tipoTrabajador);
     

        // Agregar el nuevo empleado a la tabla
        DefaultTableModel model = (DefaultTableModel) tablaEmpleados.getModel();
        model.addRow(new Object[]{codigo, nombres, apellidos, fechaIngreso, fechaRetiro, tipoTrabajador});

        // Limpiar los campos de entrada
        setCamposVacios();

        // Guardar los datos en un archivo de texto
        String datosEmpleado = empleado.toString();  // Obtener una representación de texto de los datos del empleado
        String rutaArchivo = "src/backup/empleado.txt";  // Ruta del archivo de texto
        try {
            // Crear el archivo de texto y escribir los datos del empleado en él
            FileWriter fileWriter = new FileWriter(rutaArchivo, true);  // El segundo parámetro "true" indica que se añadirán los datos al archivo existente
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(datosEmpleado);
            printWriter.close();
            System.out.println("Los datos se han guardado en el archivo de texto correctamente.");
        } catch (IOException ex) {
            System.out.println("Error al guardar los datos en el archivo de texto: " + ex.getMessage());
        }
    }
else if (e.getSource() == btnVerDetalles) {
    // Lógica para el botón "Ver detalles"
    int filaSeleccionada = tablaEmpleados.getSelectedRow();
    if (filaSeleccionada >= 0) {
        // Obtener los datos de la fila seleccionada
        int codigo = (int) tablaEmpleados.getValueAt(filaSeleccionada, 0);
        String nombres = (String) tablaEmpleados.getValueAt(filaSeleccionada, 1);
        String apellidos = (String) tablaEmpleados.getValueAt(filaSeleccionada, 2);
        String fechaIngreso = (String) tablaEmpleados.getValueAt(filaSeleccionada, 3);
        String fechaRetiro = (String) tablaEmpleados.getValueAt(filaSeleccionada, 4);
        String direccion = (String) tablaEmpleados.getValueAt(filaSeleccionada, 5);



        // Mostrar los detalles del empleado en los campos de texto
        txtCodigo.setText(Integer.toString(codigo));
        txtNombres.setText(nombres);
        txtApellidos.setText(apellidos);
        txtFechaIngreso.setText(fechaIngreso);
        txtFechaRetiro.setText(fechaRetiro);
        txtTipoTrabajador.setText(direccion);
    } else {
        JOptionPane.showMessageDialog(EmpleadoVista.this, "Seleccione una fila para ver los detalles.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    else if (e.getSource() == btnOpcionesAdicionales) {
    // Lógica para el botón "Opciones adicionales"
 
    cargarDatosDesdeArchivo();
    
    DefaultTableModel model = (DefaultTableModel) tablaEmpleados.getModel();
    model.setRowCount(0); // Limpiar la tabla
    
    for (Empleado empleado : listaEmpleados) {
        model.addRow(new Object[]{
            empleado.getCodigo(),
            empleado.getNombre(),
            empleado.getApellido(),
            empleado.getFechaIngreso(),
            empleado.getFechaRetiro(),
            empleado.getDireccion(),
         
        });
    }
}

        }
    }
        public void displayErrorMessage(String errorMessage) {
    JOptionPane.showMessageDialog(this, errorMessage);
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

    
    public JTable getTablaEmpleados() {
        return tablaEmpleados;
    }

    public int getCodigo() {
        return Integer.parseInt(txtCodigo.getText());
    }

    public String getNombres() {
        return txtNombres.getText();
    }

    public String getApellidos() {
        return txtApellidos.getText();
    }

    public String getFechaIngreso() {
        return txtFechaIngreso.getText();
    }

    public String getFechaRetiro() {
        return txtFechaRetiro.getText();
    }


public String getTipoTrabajador() {
    return txtTipoTrabajador.getText();
}

    public void setCodigo(int codigo) {
        txtCodigo.setText(String.valueOf(codigo));
    }

    public void setCodigoVacio() {
        txtCodigo.setText("");
    }

    public void setNombres(String nombres) {
        txtNombres.setText(nombres);
    }

    public void setApellidos(String apellidos) {
        txtApellidos.setText(apellidos);
    }

    public void setFechaIngreso(String fechaIngreso) {
        txtFechaIngreso.setText(fechaIngreso);
    }

    public void setFechaRetiro(String fechaRetiro) {
        txtFechaRetiro.setText(fechaRetiro);
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        txtTipoTrabajador.setText(tipoTrabajador);
    }

    public void setCamposVacios() {
        setCodigoVacio();
        setNombres("");
        setApellidos("");
        setFechaIngreso("");
        setFechaRetiro("");
        setTipoTrabajador("");
    }



    public JComboBox<String> getComboBoxEstamento() {
        return comboBoxEstamento;
    }

    public void setComboBoxEstamento(int index) {
        comboBoxEstamento.setSelectedIndex(index);
    }

    public Object[][] getDatosTablaEmpleados() {
        return dataEmpleados;
    }

    // Toggle para el botón de editar. Si es true, el botón se habilita; sino, se deshabilita.
    public void habilitarEditarEmpleado(boolean toggle) {
        btnEditarEmpleado.setEnabled(toggle);
    }

    public void deshabilitarGuardarEmpleado() {
        btnGuardarEmpleado.setEnabled(false);
    }

    public void habilitarGuardarEmpleado() {
        btnGuardarEmpleado.setEnabled(true);
    }

    public void habilitarEliminarEmpleado(boolean toggle) {
        btnEliminarEmpleado.setEnabled(toggle);
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
            tablaEmpleados.setModel(getModeloTablaEmpleados());
        });
    }

    public void editarElementoTablaEmpleados(int index, Empleado eps) {
        Object[] nuevosDatos = getDatosEmpleado(eps);
        dataEmpleados[index] = nuevosDatos;

        // Actualizar el modelo de la tabla de epss
        SwingUtilities.invokeLater(() -> {
            tablaEmpleados.setModel(getModeloTablaEmpleados());
        });
    }

    public void eliminarFilaEmpleados(int filaEliminar) {
        // Convertir la matriz en una lista de arreglos
        List<Object[]> listaMatriz = new ArrayList<>(Arrays.asList(dataEmpleados));

        // Eliminar la fila especificada
        listaMatriz.remove(filaEliminar);

        // Convertir la lista de arreglos nuevamente en una matriz
        Object[][] nuevaMatriz = new Object[listaMatriz.size()][];
        listaMatriz.toArray(nuevaMatriz);

        dataEmpleados = nuevaMatriz;

        // Actualizar el modelo de la tabla de epss
        SwingUtilities.invokeLater(() -> {
            tablaEmpleados.setModel(getModeloTablaEmpleados());
        });
    }

    /**
     * Función que define los datos de la tabla y los nombres de cada columna.
     * Después se necesitará el modelo en sí, para recuperar los datos
     * correspondientes de cada fila, por eso se creó la función para
     * obtenerlo.
     */
    
    public DefaultTableModel getModeloTablaEmpleados() {
        DefaultTableModel modeloTabla = new DefaultTableModel(
            dataEmpleados,
            new String[] {
                "Código", "Nombres", "Apellidos", "Fecha Ingreso", "Fecha Retiro", "Tipo Trabajador"
            }
        );
        return modeloTabla;
    }
    
    
    
    // Añade el listener para el botón de Guardar Empleado
    public void addBtnGuardarEmpleadoListener(ActionListener listener) {
       btnGuardarEmpleado.addActionListener(listener);

    }

    // Añade el listener para el botón de Editar Empleado
    public void addBtnEditarEmpleadoListener(ActionListener listener) {
        btnEditarEmpleado.addActionListener(listener);
    }

    // Añade el listener para el botón de Listar Empleados
    public void addBtnListarEmpleadosListener(ActionListener listener) {
        btnListarEmpleados.addActionListener(listener);
    }

    // Añade el listener para el botón de Eliminar Empleado
    public void addBtnEliminarEmpleadoListener(ActionListener listener) {
        btnEliminarEmpleado.addActionListener(listener);
    }

    // Añade el listener para el botón de Ver Detalles
    public void addBtnVerDetallesListener(ActionListener listener) {
        
        btnVerDetalles.addActionListener(listener);
        
    }

    // Añade el listener para el botón de Opciones Adicionales
    public void addBtnOpcionesAdicionalesListener(ActionListener listener) {
        btnOpcionesAdicionales.addActionListener(listener);
    }

    // Añade el listener para la tabla de epss
    public void addTablaEmpleadosMouseListener(MouseAdapter listener) {
        tablaEmpleados.addMouseListener(listener);
    }
    
    private List<Empleado> listaEmpleados = new ArrayList<>();
    
private void cargarDatosDesdeArchivo() {
    String rutaArchivo = "src/backup/empleado.txt"; // Ruta del archivo de texto

    try {
        Scanner scanner = new Scanner(new File(rutaArchivo));

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();

            // Ignorar las líneas que no contienen datos de empleado
            if (linea.startsWith("Código:")) {
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




}
