package controlador;

import java.util.List;
import modelo.Empleado;
import dao.EmpleadoDAO;

public class EmpleadoControlador {

    private EmpleadoDAO empleadoDAO;

    public EmpleadoControlador() {
        empleadoDAO = new EmpleadoDAO();
    }

}
