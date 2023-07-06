package dao;
import java.util.ArrayList;
import java.util.List;
import modelo.ConceptoDeduccion;

public class ConceptoDeduccionDAO implements DAO<ConceptoDeduccion> {

	private List<ConceptoDeduccion> deducciones_list;
	
	public ConceptoDeduccionDAO() {
		this.deducciones_list = new ArrayList<>();
	}
	
	@Override
	public void crear(ConceptoDeduccion concepto_deduccion) {
		// TODO Auto-generated method stub
		deducciones_list.add(concepto_deduccion);
	}
	
	@Override
	public void crearVarios(List<ConceptoDeduccion> deducciones_list_nuevos) {
		// TODO Auto-generated method stub
		deducciones_list = deducciones_list_nuevos;
	}

	@Override
	public ConceptoDeduccion obtener(int index) {
		// TODO Auto-generated method stub
		return deducciones_list.get(index);
	}

	@Override
	public List<ConceptoDeduccion> obtenerTodos() {
		// TODO Auto-generated method stub
		return deducciones_list;
	}

	@Override
	public void actualizar(int index, ConceptoDeduccion concepto_deduccion_act) {
		// TODO Auto-generated method stub
		deducciones_list.set(index, concepto_deduccion_act);
	}
	
    @Override
    public void eliminar(int index) {
        deducciones_list.remove(index);
    }
}
