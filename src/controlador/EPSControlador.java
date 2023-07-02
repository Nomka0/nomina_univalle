package controlador;

import java.util.List;
import modelo.EPS;
import dao.EPSDAO;

public class EPSControlador {

    private EPSDAO epsDAO;

    public EPSControlador() {
        this.epsDAO = new EPSDAO();
    }

    public void crearEPS(EPS eps) {
        epsDAO.crear(eps);
    }

    public void crearVariasEPS(List<EPS> epsListNuevos) {
        epsDAO.crearVarios(epsListNuevos);
    }

    public EPS obtenerEPS(int index) {
        return epsDAO.obtener(index);
    }

    public List<EPS> obtenerTodasLasEPS() {
        return epsDAO.obtenerTodos();
    }

    public void actualizarEPS(int index, EPS epsActualizada) {
        epsDAO.actualizar(index, epsActualizada);
    }

    public void eliminarEPS(int index) {
        epsDAO.eliminar(index);
    }
}