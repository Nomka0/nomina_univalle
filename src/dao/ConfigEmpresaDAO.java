package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.ConfigEmpresa;

public class ConfigEmpresaDAO implements DAO<ConfigEmpresa> {

	private List<ConfigEmpresa> configuraciones_list;
	
	public ConfigEmpresaDAO() {
		this.configuraciones_list = new ArrayList<>();
	}
	
	@Override
	public void crear(ConfigEmpresa config_empresa) {
		// TODO Auto-generated method stub
		configuraciones_list.add(config_empresa);
	}
	
	@Override
	public void crearVarios(List<ConfigEmpresa> configuraciones_list_nuevos) {
		// TODO Auto-generated method stub
		configuraciones_list = configuraciones_list_nuevos;
	}

	@Override
	public ConfigEmpresa obtener(int index) {
		// TODO Auto-generated method stub
		return configuraciones_list.get(index);
	}

	@Override
	public List<ConfigEmpresa> obtenerTodos() {
		// TODO Auto-generated method stub
		return configuraciones_list;
	}

	@Override
	public void actualizar(int index, ConfigEmpresa config_empresa_act) {
		// TODO Auto-generated method stub
		configuraciones_list.set(index, config_empresa_act);
	}
	
    @Override
    public void eliminar(int index) {
        configuraciones_list.remove(index);
    }
}
