package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.FondoPension;

public class FondoPensionDAO implements DAO<FondoPension> {

	private List<FondoPension> pensiones;
	
	public FondoPensionDAO() {
		this.pensiones = new ArrayList<>();
	}
	
	@Override
	public void crear(FondoPension fondo_pension) {
		// TODO Auto-generated method stub
		pensiones.add(fondo_pension);
	}
	
	@Override
	public void crearVarios(List<FondoPension> pensiones_nuevas) {
		// TODO Auto-generated method stub
		pensiones = pensiones_nuevas;
	}

	@Override
	public FondoPension obtener(int index) {
		// TODO Auto-generated method stub
		return pensiones.get(index);
	}

	@Override
	public List<FondoPension> obtenerTodos() {
		// TODO Auto-generated method stub
		return pensiones;
	}

	@Override
	public void actualizar(int index, FondoPension pensiones_act) {
		// TODO Auto-generated method stub
		pensiones.set(index, pensiones_act);
	}
	
    @Override
    public void eliminar(int index) {
        pensiones.remove(index);
    }
}
