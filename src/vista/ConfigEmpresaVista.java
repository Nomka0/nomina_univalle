package vista;

import modelo.ConfigEmpresa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfigEmpresaVista extends JFrame {

    private JPanel contentPane;
    private JTextField txtNIT;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtRepresentanteLegal;
    private JTextField txtCorreoContacto;
    private JTextField txtArl;
    private JTextField txtCajaCompensacion;
    private JTextField txtSalarioMinimo;
    private JTextField txtAuxilioTransporte;
    private JTable table;
    private JButton btnGuardar;
    private JButton btnListar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnVolver;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConfigEmpresaVista frame = new ConfigEmpresaVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ConfigEmpresaVista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 760, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNIT = new JLabel("NIT:");
        lblNIT.setBounds(10, 10, 100, 20);
        contentPane.add(lblNIT);

        txtNIT = new JTextField();
        txtNIT.setBounds(120, 10, 200, 20);
        contentPane.add(txtNIT);
        txtNIT.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 40, 100, 20);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 40, 200, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(10, 70, 100, 20);
        contentPane.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(120, 70, 200, 20);
        contentPane.add(txtTelefono);
        txtTelefono.setColumns(10);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(10, 100, 100, 20);
        contentPane.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(120, 100, 200, 20);
        contentPane.add(txtDireccion);
        txtDireccion.setColumns(10);

        JLabel lblRepresentanteLegal = new JLabel("Representante Legal:");
        lblRepresentanteLegal.setBounds(10, 130, 150, 20);
        contentPane.add(lblRepresentanteLegal);

        txtRepresentanteLegal = new JTextField();
        txtRepresentanteLegal.setBounds(170, 130, 150, 20);
        contentPane.add(txtRepresentanteLegal);
        txtRepresentanteLegal.setColumns(10);

        JLabel lblCorreoContacto = new JLabel("Correo de Contacto:");
        lblCorreoContacto.setBounds(10, 160, 150, 20);
        contentPane.add(lblCorreoContacto);

        txtCorreoContacto = new JTextField();
        txtCorreoContacto.setBounds(170, 160, 150, 20);
        contentPane.add(txtCorreoContacto);
        txtCorreoContacto.setColumns(10);

        JLabel lblArl = new JLabel("ARL:");
        lblArl.setBounds(10, 190, 100, 20);
        contentPane.add(lblArl);

        txtArl = new JTextField();
        txtArl.setBounds(120, 190, 200, 20);
        contentPane.add(txtArl);
        txtArl.setColumns(10);

        JLabel lblCajaCompensacion = new JLabel("Caja de Compensación:");
        lblCajaCompensacion.setBounds(10, 220, 150, 20);
        contentPane.add(lblCajaCompensacion);

        txtCajaCompensacion = new JTextField();
        txtCajaCompensacion.setBounds(170, 220, 150, 20);
        contentPane.add(txtCajaCompensacion);
        txtCajaCompensacion.setColumns(10);

        JLabel lblSalarioMinimo = new JLabel("Salario Mínimo:");
        lblSalarioMinimo.setBounds(10, 250, 150, 20);
        contentPane.add(lblSalarioMinimo);

        txtSalarioMinimo = new JTextField();
        txtSalarioMinimo.setBounds(170, 250, 150, 20);
        contentPane.add(txtSalarioMinimo);
        txtSalarioMinimo.setColumns(10);

        JLabel lblAuxilioTransporte = new JLabel("Auxilio de Transporte:");
        lblAuxilioTransporte.setBounds(10, 280, 150, 20);
        contentPane.add(lblAuxilioTransporte);

        txtAuxilioTransporte = new JTextField();
        txtAuxilioTransporte.setBounds(170, 280, 150, 20);
        contentPane.add(txtAuxilioTransporte);
        txtAuxilioTransporte.setColumns(10);

        // JButton btnGuardar = new JButton("Guardar");
        btnGuardar = new JButton("Guardar");

        btnGuardar.setBounds(10, 530, 100, 30);
        contentPane.add(btnGuardar);

        // JButton btnListar = new JButton("Listar");
        btnListar = new JButton("Listar");

        btnListar.setBounds(120, 530, 100, 30);
        contentPane.add(btnListar);

        // JButton btnEditar = new JButton("Editar");
        btnEditar = new JButton("Editar");

        btnEditar.setBounds(230, 530, 100, 30);
        contentPane.add(btnEditar);

        // JButton btnEliminar = new JButton("Eliminar");
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(340, 530, 100, 30);
        contentPane.add(btnEliminar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(450, 530, 100, 30);
        contentPane.add(btnVolver);

        // Tabla
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 320, 760, 200);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "NIT", "Nombre", "Teléfono", "Dirección", "Representante Legal", "Correo de Contacto",
                        "ARL", "Caja de Compensación", "Salario Mínimo", "Auxilio de Transporte"
                }));
        scrollPane.setViewportView(table);

    }

    public String getNIT() {
        return txtNIT.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getTelefono() {
        return txtTelefono.getText();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }

    public String getRepresentanteLegal() {
        return txtRepresentanteLegal.getText();
    }

    public String getCorreoContacto() {
        return txtCorreoContacto.getText();
    }

    public String getARL() {
        return txtArl.getText();
    }

    public String getCajaCompensacion() {
        return txtCajaCompensacion.getText();
    }

    public String getSalarioMinimo() {
        return txtSalarioMinimo.getText();
    }

    public String getAuxilioTransporte() {
        return txtAuxilioTransporte.getText();
    }

    public void limpiarCampos() {
        txtNIT.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtRepresentanteLegal.setText("");
        txtCorreoContacto.setText("");
        txtArl.setText("");
        txtCajaCompensacion.setText("");
        txtSalarioMinimo.setText("");
        txtAuxilioTransporte.setText("");
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) table.getModel();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void agregarGuardarListener(ActionListener listener) {
        btnGuardar.addActionListener(listener);
    }

    public void agregarListarListener(ActionListener listener) {
        btnListar.addActionListener(listener);

    }

    public void agregarEditarListener(ActionListener listener) {
        btnEditar.addActionListener(listener);
    }

    public void agregarEliminarListener(ActionListener listener) {
        btnEliminar.addActionListener(listener);
    }

    public void agregarVolverListener(ActionListener listener) {
        btnVolver.addActionListener(listener);
}
}
