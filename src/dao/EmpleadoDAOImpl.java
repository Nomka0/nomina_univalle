package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDAOImpl implements EmpleadoDAO {

	private List<Empleado> empleados;
	
	public EmpleadoDAOImpl() {
		this.empleados = new ArrayList<>();
	}
	
	public void crearEmpleados(List<Empleado> empleados_nuevos) {
		// TODO Auto-generated method stub
		empleados = empleados_nuevos;
	}
	
	@Override
	public void crearEmpleado(Empleado paciente) {
		// TODO Auto-generated method stub
		empleados.add(paciente);
	}

	@Override
	public Empleado obtenerEmpleado(int index) {
		// TODO Auto-generated method stub
		return empleados.get(index);
	}

	@Override
	public List<Empleado> obtenerTodosLosEmpleados() {
		// TODO Auto-generated method stub
		return empleados;
	}

	@Override
	public void actualizarEmpleado(int index, Empleado pacienteAct) {
		// TODO Auto-generated method stub
		empleados.set(index, pacienteAct);
	}
	
    @Override
    public void eliminarEmpleado(int index) {
        empleados.remove(index);
    }
	

}
