package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.FondoPension;

public class FondoPensionDAO implements DAO<FondoPension> {

	private List<FondoPension> eps_list;
	
	public FondoPensionDAO() {
		this.eps_list = new ArrayList<>();
	}
	
	@Override
	public void crear(FondoPension eps) {
		// TODO Auto-generated method stub
		eps_list.add(eps);
	}
	
	@Override
	public void crearVarios(List<FondoPension> eps_list_nuevos) {
		// TODO Auto-generated method stub
		eps_list = eps_list_nuevos;
	}

	@Override
	public FondoPension obtener(int index) {
		// TODO Auto-generated method stub
		return eps_list.get(index);
	}

	@Override
	public List<FondoPension> obtenerTodos() {
		// TODO Auto-generated method stub
		return eps_list;
	}

	@Override
	public void actualizar(int index, FondoPension epsAct) {
		// TODO Auto-generated method stub
		eps_list.set(index, epsAct);
	}
	
    @Override
    public void eliminar(int index) {
        eps_list.remove(index);
    }
}
