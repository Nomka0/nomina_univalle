package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.CajaCompensacion;

public class CajaCompensacionDAO implements DAO<CajaCompensacion> {

	private List<CajaCompensacion> cajas_comp_list;
	
	public CajaCompensacionDAO() {
		this.cajas_comp_list = new ArrayList<>();
	}
	
	@Override
	public void crear(CajaCompensacion caja_comp) {
		// TODO Auto-generated method stub
		cajas_comp_list.add(caja_comp);
	}
	
	@Override
	public void crearVarios(List<CajaCompensacion> cajas_comp_list_nuevos) {
		// TODO Auto-generated method stub
		cajas_comp_list = cajas_comp_list_nuevos;
	}

	@Override
	public CajaCompensacion obtener(int index) {
		// TODO Auto-generated method stub
		return cajas_comp_list.get(index);
	}

	@Override
	public List<CajaCompensacion> obtenerTodos() {
		// TODO Auto-generated method stub
		return cajas_comp_list;
	}

	@Override
	public void actualizar(int index, CajaCompensacion caja_comp_act) {
		// TODO Auto-generated method stub
		cajas_comp_list.set(index, caja_comp_act);
	}
	
    @Override
    public void eliminar(int index) {
        cajas_comp_list.remove(index);
    }
}
