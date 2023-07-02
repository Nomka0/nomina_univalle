package controlador;

import java.util.List;
import modelo.FondoPension;
import dao.FondoPensionDAO;

public class FondoPensionControlador {

    private FondoPensionDAO fondoPensionDAO;

    public FondoPensionControlador() {
        this.fondoPensionDAO = new FondoPensionDAO();
    }

    public void crearFondoPension(FondoPension fondoPension) {
        fondoPensionDAO.crear(fondoPension);
    }

    public void crearVariosFondosPension(List<FondoPension> fondosPensionNuevos) {
        fondoPensionDAO.crearVarios(fondosPensionNuevos);
    }

    public FondoPension obtenerFondoPension(int index) {
        return fondoPensionDAO.obtener(index);
    }

    public List<FondoPension> obtenerTodosLosFondosPension() {
        return fondoPensionDAO.obtenerTodos();
    }

    public void actualizarFondoPension(int index, FondoPension fondoPensionActualizado) {
        fondoPensionDAO.actualizar(index, fondoPensionActualizado);
    }

    public void eliminarFondoPension(int index) {
        fondoPensionDAO.eliminar(index);
    }
}
