package controlador;

import java.util.List;
import dao.ConfigEmpresaDAO;
import modelo.ConfigEmpresa;

public class ConfigEmpresaControlador {

    private ConfigEmpresaDAO configEmpresaDAO;

    public ConfigEmpresaControlador() {
        configEmpresaDAO = new ConfigEmpresaDAO();
    }

    public void crearConfiguracion(ConfigEmpresa configEmpresa) {
        configEmpresaDAO.crear(configEmpresa);
    }

    public void crearVariasConfiguraciones(List<ConfigEmpresa> configuracionesNuevas) {
        configEmpresaDAO.crearVarios(configuracionesNuevas);
    }

    public ConfigEmpresa obtenerConfiguracion(int index) {
        return configEmpresaDAO.obtener(index);
    }

    public List<ConfigEmpresa> obtenerTodasLasConfiguraciones() {
        return configEmpresaDAO.obtenerTodos();
    }

    public void actualizarConfiguracion(int index, ConfigEmpresa configEmpresaActualizada) {
        configEmpresaDAO.actualizar(index, configEmpresaActualizada);
    }

    public void eliminarConfiguracion(int index) {
        configEmpresaDAO.eliminar(index);
    }
}
