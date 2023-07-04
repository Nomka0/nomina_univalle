package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Empleado;
import vista.EmpleadoVista;

public class EmpleadoVistaControlador {
	
	private EmpleadoVista ventana;
	private EmpleadoControlador empleado;
	private Empleado empleadoNuevo;
	private int contadorDatos;
	
	
	public EmpleadoVistaControlador(EmpleadoVista ventana, EmpleadoControlador empleado) {
		this.ventana = ventana;
		this.empleado = empleado;
		contadorDatos = 0;
		
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
		
		empleadoNuevo = new Empleado(ID, nombre, apellido, direccion, eps, fpp, fechaingreso, activo, tipotrabajador, tiposalario, cuenta);
		
		System.out.print(empleadoNuevo.getId()); 
		
		/*empleadoNuevo.setId(ID);
		empleadoNuevo.setNombre(nombre);
		empleadoNuevo.setApellido(apellido);
		empleadoNuevo.setDireccion(direccion);
		empleadoNuevo.setEps(eps);
		empleadoNuevo.setFpp(fpp);
		empleadoNuevo.setTipoTrabajador(tipotrabajador);
		empleadoNuevo.setTipoSalario(tiposalario);
		empleadoNuevo.setCuentaBancaria(cuenta);
		empleadoNuevo.setActivo(false);
		empleadoNuevo.setFechaIngreso(fechaingreso);
		empleadoNuevo.setFechaRetiro(tiposalario);*/
		
		ventana.addDatosTablaEmpleados(empleadoNuevo);
		
		System.out.println(ID);
		empleado.crearEmpleado(ID, nombre, apellido, direccion, eps, fpp, fechaingreso, activo, tipotrabajador, tiposalario, cuenta);
		
	}
	
	class ListarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Listar eps")) {
            	System.out.print(empleadoNuevo.getNombre()); 

            }
            
        }
    }
	
	public void listarDatos() {
		
		
		
	}
}