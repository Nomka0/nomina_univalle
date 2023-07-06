import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CajaCompensacionVista extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField txtNombreCajaCompensacion;
    private JTextField txtCodigoCajaCompensacion;
    private JButton btnGuardar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CajaCompensacionVista frame = new CajaCompensacionVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CajaCompensacionVista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 230, 100, 30);
        contentPane.add(btnGuardar);

        // Agregar ActionListener al botón "Guardar"
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatosEnTabla();
            }
        });

        // Crear el modelo de tabla
        String[] columnNames = { "Nombre", "Codigo" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 70, 400, 150);
        contentPane.add(scrollPane);
    }

    // Método para guardar los datos en la tabla
    private void guardarDatosEnTabla() {
        String nombre = txtNombreCajaCompensacion.getText();
        String codigo = txtCodigoCajaCompensacion.getText();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[] { nombre, codigo });
        // Limpiar los campos de texto después de guardar
        txtNombreCajaCompensacion.setText("");
        txtCodigoCajaCompensacion.setText("");
    }
}
