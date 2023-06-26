package dao;
import modelo.Empleado;
import java.util.List;

public interface EmpleadoDAO {
	
	void crearEmpleado(Empleado empleado);
	
	Empleado obtenerEmpleado(int index);
	
	List<Empleado> obtenerTodosLosEmpleados();
	
	void actualizarEmpleado(int index, Empleado alergiaAct);
	
	void eliminarEmpleado(int index);
}
