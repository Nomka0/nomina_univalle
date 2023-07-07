package controlador;

import dao.FondoPensionDAO;
import modelo.FondoPension;
import vista.FondoPensionVista;

import java.util.List;

public class FondoPensionControlador {
    private FondoPensionVista vista;

    public void setVista(FondoPensionVista vista) {
        this.vista = vista;
    }

    public FondoPensionControlador(FondoPensionVista vista) {
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void guardarFondoPension(String nombre, String codigo) {
        FondoPension fondoPension = new FondoPension(nombre, codigo);
        vista.agregarFila(new Object[]{fondoPension.getNombre(), fondoPension.getCodigo()});
        FondoPensionDAO.guardarFondoPension(fondoPension);
    }

    public List<FondoPension> listarFondoPension() {
        return FondoPensionDAO.listarFondoPension();
    }

    public void editarFondoPension(String nombre, String codigo, int rowIndex) {
        List<FondoPension> fondoPensionList = listarFondoPension();

        if (rowIndex >= 0 && rowIndex < fondoPensionList.size()) {
            FondoPension fondoPension = fondoPensionList.get(rowIndex);
            fondoPension.setNombre(nombre);
            fondoPension.setCodigo(codigo);
            FondoPensionDAO.actualizarFondoPension(fondoPension);
            vista.actualizarFila(rowIndex, new Object[]{fondoPension.getNombre(), fondoPension.getCodigo()});
        }
    }

    public void eliminarFondoPension(int rowIndex) {
        List<FondoPension> fondoPensionList = listarFondoPension();

        if (rowIndex >= 0 && rowIndex < fondoPensionList.size()) {
            FondoPension fondoPension = fondoPensionList.get(rowIndex);
            FondoPensionDAO.eliminarFondoPension(fondoPension);
            vista.eliminarFila(rowIndex);
        }
    }
}
