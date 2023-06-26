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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public EmpleadoVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerDetalles = new JButton("Ver detalles");
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Agregar la lógica para ver los detalles del empleado seleccionado
				// Puede abrir un formulario o una ventana con la información detallada
			}
		});
		btnVerDetalles.setBounds(580, 10, 120, 30);
		contentPane.add(btnVerDetalles);
		
		JButton btnEditarEmpleado = new JButton("Editar empleado");
		btnEditarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Agregar la lógica para editar la información del empleado seleccionado
				 // Puede abrir un formulario o una ventana para editar los campos
			}
		});
		btnEditarEmpleado.setBounds(580, 50, 120, 30);
		contentPane.add(btnEditarEmpleado);
		
		JButton btnEliminarEmpleado = new JButton("Eliminar empleado");
		btnEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Agregar la lógica para eliminar al empleado seleccionado de la lista
			}
		});
		btnEliminarEmpleado.setBounds(580, 90, 120, 30);
		contentPane.add(btnEliminarEmpleado);
		
		JButton btnOpcionesAdicionales = new JButton("Opciones adicionales");
		btnOpcionesAdicionales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Agregar la lógica para mostrar las opciones adicionales relacionadas con empleados
				// Puede abrir una ventana con opciones como reportes, historial de cambios, etc.
			}
		});
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