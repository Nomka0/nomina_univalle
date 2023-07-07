package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.CajaCompensacionController;

public class CajaCompensacionVista extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField txtNombreCajaCompensacion;
    private JTextField txtCodigoCajaCompensacion;
    private JTextField txtFechaNacimiento;
    private JTextField txtFechaIngreso;
    private JTextField txtFechaRetiro;
    private JTextField txtTipoTrabajador;
    private JTextField txtTipoSalario;
    private JTextField txtNumeroCuenta;
    private JButton btnGuardar;
    private JButton btnListar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnVolver;

    public static void main(String[] args) {
        CajaCompensacionVista vista = new CajaCompensacionVista();
        CajaCompensacionController controller = new CajaCompensacionController(vista);
        vista.setVisible(true);
    }

    public CajaCompensacionVista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Código para crear los componentes de la interfaz gráfica

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 10, 60, 20);
        contentPane.add(lblNombre);

        txtNombreCajaCompensacion = new JTextField();
        txtNombreCajaCompensacion.setBounds(80, 10, 150, 20);
        contentPane.add(txtNombreCajaCompensacion);
        txtNombreCajaCompensacion.setColumns(10);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 40, 60, 20);
        contentPane.add(lblCodigo);

        txtCodigoCajaCompensacion = new JTextField();
        txtCodigoCajaCompensacion.setBounds(80, 40, 150, 20);
        contentPane.add(txtCodigoCajaCompensacion);
        txtCodigoCajaCompensacion.setColumns(10);

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setBounds(10, 70, 150, 20);
        contentPane.add(lblFechaNacimiento);

        txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setBounds(160, 70, 150, 20);
        contentPane.add(txtFechaNacimiento);
        txtFechaNacimiento.setColumns(10);

        JLabel lblFechaIngreso = new JLabel("Fecha de Ingreso:");
        lblFechaIngreso.setBounds(10, 100, 150, 20);
        contentPane.add(lblFechaIngreso);

        txtFechaIngreso = new JTextField();
        txtFechaIngreso.setBounds(160, 100, 150, 20);
        contentPane.add(txtFechaIngreso);
        txtFechaIngreso.setColumns(10);

        JLabel lblFechaRetiro = new JLabel("Fecha deRetiro:");
        lblFechaRetiro.setBounds(10, 130, 150, 20);
        contentPane.add(lblFechaRetiro);

        txtFechaRetiro = new JTextField();
        txtFechaRetiro.setBounds(160, 130, 150, 20);
        contentPane.add(txtFechaRetiro);
        txtFechaRetiro.setColumns(10);

        JLabel lblTipoTrabajador = new JLabel("Tipo de Trabajador:");
        lblTipoTrabajador.setBounds(10, 160, 150, 20);
        contentPane.add(lblTipoTrabajador);

        txtTipoTrabajador = new JTextField();
        txtTipoTrabajador.setBounds(160, 160, 150, 20);
        contentPane.add(txtTipoTrabajador);
        txtTipoTrabajador.setColumns(10);

        JLabel lblTipoSalario = new JLabel("Tipo de Salario:");
        lblTipoSalario.setBounds(10, 190, 150, 20);
        contentPane.add(lblTipoSalario);

        txtTipoSalario = new JTextField();
        txtTipoSalario.setBounds(160, 190, 150, 20);
        contentPane.add(txtTipoSalario);
        txtTipoSalario.setColumns(10);

        JLabel lblNumeroCuenta = new JLabel("Número de Cuenta:");
        lblNumeroCuenta.setBounds(10, 220, 150, 20);
        contentPane.add(lblNumeroCuenta);

        txtNumeroCuenta = new JTextField();
        txtNumeroCuenta.setBounds(160, 220, 150, 20);
        contentPane.add(txtNumeroCuenta);
        txtNumeroCuenta.setColumns(10);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 270, 100, 30);
        contentPane.add(btnGuardar);

        btnListar = new JButton("Listar");
        btnListar.setBounds(120, 270, 100, 30);
        contentPane.add(btnListar);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(230, 270, 100, 30);
        contentPane.add(btnEditar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(230, 300, 100, 30);
        contentPane.add(btnEliminar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(450, 300, 100, 30);
        contentPane.add(btnVolver);
        
        

        // Crear el modelo de tabla
        String[] columnNames = { "Nombre", "Codigo", "Fecha Nacimiento", "Fecha Ingreso", "Fecha Retiro",
                "Tipo Trabajador", "Tipo de Salario", "#Cuenta" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(350, 10, 420, 290);
        contentPane.add(scrollPane);
    }

    // Métodos getters para obtener los elementos de la interfaz gráfica
    public JTextField getTxtNombreCajaCompensacion() {
        return txtNombreCajaCompensacion;
    }

    public JTextField getTxtCodigoCajaCompensacion() {
        return txtCodigoCajaCompensacion;
    }

    public JTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public JTextField getTxtFechaIngreso() {
        return txtFechaIngreso;
    }

    public JTextField getTxtFechaRetiro() {
        return txtFechaRetiro;
    }

    public JTextField getTxtTipoTrabajador() {
        return txtTipoTrabajador;
    }

    public JTextField getTxtTipoSalario() {
        return txtTipoSalario;
    }

    public JTextField getTxtNumeroCuenta() {
        return txtNumeroCuenta;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTable getTable() {
        return table;
    }
}


