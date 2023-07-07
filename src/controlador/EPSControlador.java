package controlador;



import dao.EPSDAO;
import modelo.EPS;
import vista.EPSVista;

import java.util.List;

public class EPSControlador {
    private EPSVista vista;
    
        

    public void setVista(EPSVista vista) {
        this.vista = vista;
    }

    public EPSControlador(EPSVista vista) {
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void guardarEPS(String nombre, String codigo) {
        EPS eps = new EPS(nombre, codigo);
        vista.agregarFila(new Object[]{eps.getNombre(), eps.getCodigo()});
        EPSDAO.guardarEPS(eps);
    }

    public List<EPS> listarEPS() {
        return EPSDAO.listarEPS();
    }

    public void editarEPS(String nombre, String codigo, int rowIndex) {
        List<EPS> epsList = listarEPS();

        if (rowIndex >= 0 && rowIndex < epsList.size()) {
            EPS eps = epsList.get(rowIndex);
            eps.setNombre(nombre);
            eps.setCodigo(codigo);
            EPSDAO.actualizarEPS(eps);
            vista.actualizarFila(rowIndex, new Object[]{eps.getNombre(), eps.getCodigo()});
        }
    }

    public void eliminarEPS(int rowIndex) {
        List<EPS> epsList = listarEPS();

        if (rowIndex >= 0 && rowIndex < epsList.size()) {
            EPS eps = epsList.get(rowIndex);
            EPSDAO.eliminarEPS(eps);
            vista.eliminarFila(rowIndex);
        }
    }
}
