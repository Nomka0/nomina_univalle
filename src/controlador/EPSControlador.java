package controlador;

import java.util.List;
import modelo.EPS;
import dao.EPSDAO;

public class EPSControlador {

    private EPSDAO epsDAO;

    public EPSControlador() {
        epsDAO = new EPSDAO();
    }

}