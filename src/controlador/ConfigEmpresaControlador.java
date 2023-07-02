package controlador;

import java.util.List;
import dao.ConfigEmpresaDAO;
import modelo.ConfigEmpresa;

public class ConfigEmpresaControlador {

    private ConfigEmpresaDAO configEmpresaDAO;

    public ConfigEmpresaControlador() {
        configEmpresaDAO = new ConfigEmpresaDAO();
    }

}
