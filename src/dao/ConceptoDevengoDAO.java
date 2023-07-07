package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.ConceptoDevengo;

public class ConceptoDevengoDAO implements DAO<ConceptoDevengo> {

	private List<ConceptoDevengo> devengos_list;
	
	public ConceptoDevengoDAO() {
		this.devengos_list = new ArrayList<>();
	}
	
	@Override
	public void crear(ConceptoDevengo concepto_devengo) {
		// TODO Auto-generated method stub
		devengos_list.add(concepto_devengo);
	}
	
	@Override
	public void crearVarios(List<ConceptoDevengo> devengos_list_nuevos) {
		// TODO Auto-generated method stub
		devengos_list = devengos_list_nuevos;
	}

	@Override
	public ConceptoDevengo obtener(int index) {
		// TODO Auto-generated method stub
		return devengos_list.get(index);
	}

	@Override
	public List<ConceptoDevengo> obtenerTodos() {
		// TODO Auto-generated method stub
		return devengos_list;
	}

	@Override
	public void actualizar(int index, ConceptoDevengo concepto_devengo_act) {
		// TODO Auto-generated method stub
		devengos_list.set(index, concepto_devengo_act);
	}
	
    @Override
    public void eliminar(int index) {
        devengos_list.remove(index);
    }
}