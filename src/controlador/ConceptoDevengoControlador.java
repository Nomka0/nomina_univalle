package controlador;

import java.util.List;
import dao.ConceptoDevengoDAO;
import modelo.ConceptoDevengo;

public class ConceptoDevengoControlador {

	private ConceptoDevengoDAO conceptoDevengoDAO;

	public ConceptoDevengoControlador() {
		this.conceptoDevengoDAO = new ConceptoDevengoDAO();
	}

	public void crearConceptoDevengo(ConceptoDevengo conceptoDevengo) {
		conceptoDevengoDAO.crear(conceptoDevengo);
	}

	public void crearVariosConceptosDevengo(List<ConceptoDevengo> conceptosDevengo) {
		conceptoDevengoDAO.crearVarios(conceptosDevengo);
	}

	public ConceptoDevengo obtenerConceptoDevengo(int index) {
		return conceptoDevengoDAO.obtener(index);
	}

	public List<ConceptoDevengo> obtenerTodosConceptosDevengo() {
		return conceptoDevengoDAO.obtenerTodos();
	}

	public void actualizarConceptoDevengo(int index, ConceptoDevengo conceptoDevengo) {
		conceptoDevengoDAO.actualizar(index, conceptoDevengo);
	}

	public void eliminarConceptoDevengo(int index) {
		conceptoDevengoDAO.eliminar(index);
	}
}