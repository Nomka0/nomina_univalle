package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.EmpleadoVista;

public class EmpleadoVistaControlador {
	
	private EmpleadoVista ventana;
	private EmpleadoControlador empleado;
	
	
	public EmpleadoVistaControlador(EmpleadoVista ventana, EmpleadoControlador empleado) {
		this.ventana = ventana;
		this.empleado = empleado;
		
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        ventana.addBtnGuardarEmpleadoListener(new GuardarListener());
        ventana.addBtnListarEmpleadosListener(new ListarListener());
        
	}
	
	class GuardarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Guardar")) {
                System.out.println("guardado");
                obtenerDatos();
            }
        }
    }
	
	public void obtenerDatos() {
		int ID = ventana.getCodigo();
		String nombre = ventana.getNombres();
		String apellido = ventana.getApellidos();
		String direccion = ventana.getDireccion();
		int eps = ventana.getEPS();
		int fpp = ventana.getFPP();
		String fechaingreso = ventana.getFechaIngreso();
		String activo = ventana.getEstado();
		String tipotrabajador = ventana.getTipoTrabajador();
		String tiposalario = ventana.getTipoSalario();
		long cuenta = ventana.getCuenta();
		
		System.out.println(ID);
		empleado.crearEmpleado(ID, nombre, apellido, direccion, eps, fpp, fechaingreso, activo, tipotrabajador, tiposalario, cuenta);
		
	}
	
	class ListarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Listar eps")) {
               System.out.print("listado"); 

            }
            
        }
    }
}