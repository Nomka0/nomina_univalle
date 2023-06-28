package controlador;

import java.util.List;
import modelo.Empleado;
import dao.EmpleadoDAO;

public class EmpleadoControlador {

    private EmpleadoDAO empleadoDAO;

    public EmpleadoControlador() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public void crearEmpleado(Empleado empleado) {
        empleadoDAO.crear(empleado);
    }

    public void crearVariosEmpleados(List<Empleado> empleadosNuevos) {
        empleadoDAO.crearVarios(empleadosNuevos);
    }

    public Empleado obtenerEmpleado(int index) {
        return empleadoDAO.obtener(index);
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoDAO.obtenerTodos();
    }

    public void actualizarEmpleado(int index, Empleado empleadoActualizado) {
        empleadoDAO.actualizar(index, empleadoActualizado);
    }

    public void eliminarEmpleado(int index) {
        empleadoDAO.eliminar(index);
    }
}
