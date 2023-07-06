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

    

    public JButton getBtnGuardarEmpleado() {
        return btnGuardarEmpleado;
    }
    
    public JPanel contentPane;
    public JTable tablaEmpleados;
    public JButton btnGuardarEmpleado;
    public JButton btnEditarEmpleado;
    public JButton btnEliminarEmpleado;
    public JButton btnListarEmpleados;
    public JButton btnVerDetalles;
    public JButton btnOpcionesAdicionales;
   
    JLabel lblApellidos;
    JLabel lblFechaIngreso;
    JLabel lblFechaRetiro;
    JLabel lblCodigo;
    JLabel lblNombres;
    
    public JTextField txtCodigo;
    public JTextField txtNombres;
    public JTextField txtApellidos;
    public JTextField txtFechaIngreso;
    public JTextField txtFechaRetiro;
    public JTextField txtTipoTrabajador;
    public JComboBox<String> comboBoxEstamento;
    public Object[][] dataEmpleados;

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

 
        



    }


    public void setCodigo(int codigo) {
    }


    public void setFechaIngreso(String fechaIngreso) {
    }


    public void setFechaRetiro(String fechaRetiro) {
    }


    public void setTipoTrabajador(String direccion) {
    }


    public void setNombres(String nombre) {
    }


    public void setApellidos(String apellido) {
    }
    }