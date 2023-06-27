package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDAO implements DAO<Empleado> {

	private List<Empleado> empleados;
	
	public EmpleadoDAO() {
		this.empleados = new ArrayList<>();
	}
	
	@Override
	public void crear(Empleado empleado) {
		// TODO Auto-generated method stub
		empleados.add(empleado);
	}
	
	@Override
	public void crearVarios(List<Empleado> empleados_nuevos) {
		// TODO Auto-generated method stub
		empleados = empleados_nuevos;
	}

	@Override
	public Empleado obtener(int index) {
		// TODO Auto-generated method stub
		return empleados.get(index);
	}

	@Override
	public List<Empleado> obtenerTodos() {
		// TODO Auto-generated method stub
		return empleados;
	}

	@Override
	public void actualizar(int index, Empleado empleado_act) {
		// TODO Auto-generated method stub
		empleados.set(index, empleado_act);
	}
	
    @Override
    public void eliminar(int index) {
        empleados.remove(index);
    }
}
