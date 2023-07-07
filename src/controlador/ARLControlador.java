package controlador;

import dao.ARLDAO;
import modelo.ARL;
import vista.ARLVista;

import java.util.List;

public class ARLControlador {
    private ARLVista vista;

    public void setVista(ARLVista vista) {
        this.vista = vista;
    }
    public void setControlador(ARLVista vista) {
    this.vista = vista;
}

    
    public ARLControlador(ARLVista vista) {
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void guardarARL(String nombre, String codigo) {
        ARL arl = new ARL(nombre, codigo);
        vista.agregarFila(new Object[]{arl.getNombre(), arl.getCodigo()});
        ARLDAO.guardarARL(arl);
    }

    public List<ARL> listarARL() {
        return ARLDAO.listarARL();
    }

    public void editarARL(String nombre, String codigo, int rowIndex) {
        List<ARL> arlList = listarARL();

        if (rowIndex >= 0 && rowIndex < arlList.size()) {
            ARL arl = arlList.get(rowIndex);
            arl.setNombre(nombre);
            arl.setCodigo(codigo);
            ARLDAO.actualizarARL(arl);
            vista.actualizarFila(rowIndex, new Object[]{arl.getNombre(), arl.getCodigo()});
        }
    }

    public void eliminarARL(int rowIndex) {
        List<ARL> arlList = listarARL();

        if (rowIndex >= 0 && rowIndex < arlList.size()) {
            ARL arl = arlList.get(rowIndex);
            ARLDAO.eliminarARL(arl);
            vista.eliminarFila(rowIndex);
        }
    }
}
