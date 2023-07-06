package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.EmpleadoControlador;
import controlador.EmpleadoVistaControlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuVista extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVista frame = new MenuVista();
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
	public MenuVista() {
		setTitle("Menú Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JButton btnEmpleado = new JButton("EMPLEADO");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpleadoControlador empleado = new EmpleadoControlador();
				EmpleadoVista ventana = new EmpleadoVista();
				EmpleadoVistaControlador controlador = new EmpleadoVistaControlador(ventana,empleado);
				dispose();
			}
		});
		btnEmpleado.setBounds(10, 26, 122, 49);
		contentPane.add(btnEmpleado);
		
		JButton btnEps = new JButton("EPS");
		btnEps.setBounds(157, 26, 122, 49);
		contentPane.add(btnEps);
		
		JButton btnFondoDePensin = new JButton("FONDO DE PENSIÓN");
		btnFondoDePensin.setBounds(302, 26, 122, 49);
		contentPane.add(btnFondoDePensin);
		
		JButton btnArl = new JButton("ARL");
		btnArl.setBounds(10, 101, 122, 49);
		contentPane.add(btnArl);
		
		JButton btnCajaDeCompensacin = new JButton("CAJA DE COMPENSACIÓN");
		btnCajaDeCompensacin.setBounds(82, 173, 122, 49);
		contentPane.add(btnCajaDeCompensacin);
		
		JButton btnConfiguracinDeEmpresa = new JButton("CONFIG EMPRESA");
		btnConfiguracinDeEmpresa.setBounds(157, 101, 122, 49);
		contentPane.add(btnConfiguracinDeEmpresa);
		
		JButton btnDevengos = new JButton("DEVENGOS");
		btnDevengos.setBounds(225, 173, 122, 49);
		contentPane.add(btnDevengos);
		
		JButton btnDeduccin = new JButton("DEDUCCIÓN");
		btnDeduccin.setBounds(302, 101, 122, 49);
		contentPane.add(btnDeduccin);
		
	}
}