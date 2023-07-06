package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.EmpleadoDAO;
import modelo.Empleado;
import vista.EmpleadoVista;

public class EmpleadoVistaControlador {
	
	private EmpleadoVista ventana;
	private EmpleadoControlador empleado;
	private Empleado empleadoNuevo;
	private int contadorDatos;
	private EmpleadoDAO empleadosDAO;
	private String tiposalario;
	private String tipotrabajador;
	private String estado;
	
	
	public EmpleadoVistaControlador(EmpleadoVista ventana, EmpleadoControlador empleado) {
		this.ventana = ventana;
		this.empleado = empleado;
		contadorDatos = 0;
		tiposalario = "Acumulado";
		tipotrabajador = "Socio";
		estado = "Si";
		
		datosPersistentes();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        ventana.addBtnGuardarEmpleadoListener(new GuardarListener());
        ventana.addBtnListarEmpleadosListener(new ListarListener());
        ventana.addComboBoxListener(new ComboBoxListener());
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
		long cuenta = ventana.getCuenta();
		
		empleadoNuevo = new Empleado(ID, nombre, apellido, direccion, eps, fpp, fechaingreso,estado, tipotrabajador, tiposalario, cuenta);
		
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
				
		System.out.println(ID);
		empleado.crearEmpleado(ID, nombre, apellido, direccion, eps, fpp, fechaingreso,estado, tipotrabajador, tiposalario, cuenta);
		System.out.print(empleado.getDAO().obtener(empleado.getDAO().obtenerTodos().size()-1).getActivo()); 
	}
	
	class ListarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Listar eps")) {
            	System.out.print(estado); 
            	

            }
            
        }
    }
	
	   public void datosPersistentes() {
		   	empleadosDAO = empleado.getDAO();
	        for (Empleado empleado : empleadosDAO.obtenerTodos()) {
	            ventana.addDatosTabla(empleado);
	        }
	    }
	
	   class ComboBoxListener implements ActionListener {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            tiposalario = (String) ventana.getComboBoxSalario().getSelectedItem();
	            tipotrabajador = (String) ventana.getComboBoxTrabajador().getSelectedItem();
	            estado = (String) ventana.getComboBoxActivo().getSelectedItem();
	        }
	    }
	public void listarDatos() {
		
		
		
	}
}