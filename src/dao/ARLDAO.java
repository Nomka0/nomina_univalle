package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.ARL;

public class ARLDAO implements DAO<ARL> {

	private List<ARL> arl_list;
	
	public ARLDAO() {
		this.arl_list = new ArrayList<>();
	}
	
	@Override
	public void crear(ARL arl) {
		// TODO Auto-generated method stub
		arl_list.add(arl);
	}
	
	@Override
	public void crearVarios(List<ARL> arl_list_nuevos) {
		// TODO Auto-generated method stub
		arl_list = arl_list_nuevos;
	}

	@Override
	public ARL obtener(int index) {
		// TODO Auto-generated method stub
		return arl_list.get(index);
	}

	@Override
	public List<ARL> obtenerTodos() {
		// TODO Auto-generated method stub
		return arl_list;
	}

	@Override
	public void actualizar(int index, ARL arl_act) {
		// TODO Auto-generated method stub
		arl_list.set(index, arl_act);
	}
	
    @Override
    public void eliminar(int index) {
        arl_list.remove(index);
    }
}
