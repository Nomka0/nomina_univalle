package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EmpleadoVista extends JFrame {

    private JPanel contentPane;
    private JTable table;

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
        setBounds(100, 100, 733, 748);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnVerDetalles = new JButton("Ver detalles");
        btnVerDetalles.setBounds(580, 10, 120, 30);
        contentPane.add(btnVerDetalles);
        
        JButton btnEditarEmpleado = new JButton("Editar empleado");
        btnEditarEmpleado.setBounds(580, 50, 120, 30);
        contentPane.add(btnEditarEmpleado);
        
        JButton btnEliminarEmpleado = new JButton("Eliminar empleado");
        btnEliminarEmpleado.setBounds(580, 90, 120, 30);
        contentPane.add(btnEliminarEmpleado);
        
        JButton btnOpcionesAdicionales = new JButton("Opciones adicionales");
        btnOpcionesAdicionales.setBounds(580, 130, 150, 30);
        contentPane.add(btnOpcionesAdicionales);
        
        // JTable para mostrar la lista de empleados
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Fecha de Ingreso");
        model.addColumn("Fecha de Retiro");
        model.addColumn("Tipo de Trabajador");
        
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 560, 490);
        contentPane.add(scrollPane);
    }
}