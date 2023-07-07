package vista;

import controlador.EPSControlador;
import modelo.EPS;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EPSVista extends JFrame {

    private JPanel contentPane;
    private JTextField txtNombreEPS;
    private JTextField txtCodigoEPS;
    private JTable table;
    private DefaultTableModel model;
    private EPSControlador controlador;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EPSVista frame = new EPSVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EPSVista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 10, 60, 20);
        contentPane.add(lblNombre);

        txtNombreEPS = new JTextField();
        txtNombreEPS.setBounds(80, 10, 150, 20);
        contentPane.add(txtNombreEPS);
        txtNombreEPS.setColumns(10);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 40, 60, 20);
        contentPane.add(lblCodigo);

        txtCodigoEPS = new JTextField();
        txtCodigoEPS.setBounds(80, 40, 150, 20);
        contentPane.add(txtCodigoEPS);
        txtCodigoEPS.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 230, 100, 30);
        contentPane.add(btnGuardar);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(120, 230, 100, 30);
        contentPane.add(btnListar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(230, 230, 100, 30);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(340, 230, 100, 30);
        contentPane.add(btnEliminar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 420, 140);
        contentPane.add(scrollPane);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(340, 270, 100, 30);
        contentPane.add(btnVolver);

        table = new JTable();
        scrollPane.setViewportView(table);
        model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Código");
        table.setModel(model);

        // Permitir edición de celdas en la tabla
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nombre = (String) table.getValueAt(selectedRow, 0);
                    String codigo = (String) table.getValueAt(selectedRow, 1);
                    txtNombreEPS.setText(nombre);
                    txtCodigoEPS.setText(codigo);
                }
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombreEPS.getText();
                String codigo = txtCodigoEPS.getText();
                controlador.guardarEPS(nombre, codigo);
                txtNombreEPS.setText("");
                txtCodigoEPS.setText("");
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0); // Limpiar la tabla antes de listar los datos
                List<EPS> epsList = controlador.listarEPS();
                for (EPS eps : epsList) {
                    Object[] rowData = {eps.getNombre(), eps.getCodigo()};
                    model.addRow(rowData);
                }
                model.fireTableDataChanged(); // Notificar a la vista que el modelo ha cambiado
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nombre = txtNombreEPS.getText();
                    String codigo = txtCodigoEPS.getText();
                    controlador.editarEPS(nombre, codigo, selectedRow);
                    txtNombreEPS.setText("");
                    txtCodigoEPS.setText("");
                }
            }
        });
                btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    controlador.eliminarEPS(selectedRow);
                    txtNombreEPS.setText("");
                    txtCodigoEPS.setText("");
                }
            }
        });
        
                controlador = new EPSControlador(this);
        controlador.setVista(this);
        
    }

    public void setControlador(EPSControlador controlador) {
        this.controlador = controlador;
    }

    public void agregarFila(Object[] rowData) {
        model.addRow(rowData);
        guardarDatosEnArchivo();
    }

    public void actualizarFila(int rowIndex, Object[] rowData) {
        for (int i = 0; i < rowData.length; i++) {
            model.setValueAt(rowData[i], rowIndex, i);
        }
        guardarDatosEnArchivo();
    }

    public void eliminarFila(int rowIndex) {
        model.removeRow(rowIndex);
        guardarDatosEnArchivo();
    }

    public String getNombreEPS(int rowIndex) {
        return (String) model.getValueAt(rowIndex, 0);
    }

    public String getCodigoEPS(int rowIndex) {
        return (String) model.getValueAt(rowIndex, 1);
    }

    public void guardarDatosEnArchivo() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/backup/eps.txt"));
            for (int i = 0; i < model.getRowCount(); i++) {
                String rowNombre = (String) model.getValueAt(i, 0);
                String rowCodigo = (String) model.getValueAt(i, 1);
                writer.write(rowNombre + "," + rowCodigo);
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}