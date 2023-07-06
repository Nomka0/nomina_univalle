package vista;

import modelo.Empleado;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
    private Object[][] dataEmpleados = {};

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

        lblFechaIngreso = new JLabel("Fecha de Ingreso:");
        lblFechaIngreso.setBounds(19, 62, 123, 20);
        contentPane.add(lblFechaIngreso);

        txtFechaIngreso = new JTextField();
        txtFechaIngreso.setBounds(19, 82, 175, 20);
        contentPane.add(txtFechaIngreso);
        txtFechaIngreso.setColumns(10);

        lblFechaRetiro = new JLabel("Fecha de Retiro:");
        lblFechaRetiro.setBounds(223, 62, 106, 20);
        contentPane.add(lblFechaRetiro);

        txtFechaRetiro = new JTextField();
        txtFechaRetiro.setBounds(223, 82, 174, 20);
        contentPane.add(txtFechaRetiro);
        txtFechaRetiro.setColumns(10);

        JLabel  lblTipoTrabajador= new JLabel("Tipo de trabajador: ");
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

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public JComboBox<String> getComboBoxEstamento() {
        return comboBoxEstamento;
    }

    public void setComboBoxEstamento(int index) {
        comboBoxEstamento.setSelectedIndex(index);
    }

    public Object[] getDatosEmpleado(Empleado eps) {
        Object[] elemento = { eps.getId(), eps.getNombre(), eps.getApellido(), eps.getFechaIngreso(), eps.getFechaRetiro(), eps.getTipoTrabajador()};
        return elemento;
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

    public void addDatosTabla(Empleado empleado) {
        // Crear una nueva matriz temporal con una fila adicional
        Object[][] newData = new Object[dataEmpleados.length + 1][];

        // Copiar los elementos existentes de dataEmpleados a newData
        for (int i = 0; i < dataEmpleados.length; i++) {
            newData[i] = dataEmpleados[i];
        }

        // Añadir el nuevo elemento a newData
        newData[newData.length - 1] = getDatosEmpleado(empleado);

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
                "Código", "Nombres", "Apellidos", "Fecha Ingreso", "Fecha Retiro", "Tipo Trabajador", "Estamento"
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
}
