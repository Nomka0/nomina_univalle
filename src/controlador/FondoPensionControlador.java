package controlador;

import java.util.List;
import modelo.FondoPension;
import dao.FondoPensionDAO;

public class FondoPensionControlador {

    private FondoPensionDAO fondoPensionDAO;

    public FondoPensionControlador() {
        fondoPensionDAO = new FondoPensionDAO();
    }

}
