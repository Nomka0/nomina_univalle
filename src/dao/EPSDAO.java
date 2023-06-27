package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.EPS;

public class EPSDAO implements DAO<EPS> {

	private List<EPS> eps_list;
	
	public EPSDAO() {
		this.eps_list = new ArrayList<>();
	}
	
	@Override
	public void crear(EPS eps) {
		// TODO Auto-generated method stub
		eps_list.add(eps);
	}
	
	@Override
	public void crearVarios(List<EPS> eps_list_nuevos) {
		// TODO Auto-generated method stub
		eps_list = eps_list_nuevos;
	}

	@Override
	public EPS obtener(int index) {
		// TODO Auto-generated method stub
		return eps_list.get(index);
	}

	@Override
	public List<EPS> obtenerTodos() {
		// TODO Auto-generated method stub
		return eps_list;
	}

	@Override
	public void actualizar(int index, EPS epsAct) {
		// TODO Auto-generated method stub
		eps_list.set(index, epsAct);
	}
	
    @Override
    public void eliminar(int index) {
        eps_list.remove(index);
    }
}
