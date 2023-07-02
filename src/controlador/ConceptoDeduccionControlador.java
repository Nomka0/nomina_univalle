package controlador;

import dao.ConceptoDeduccionDAO;
import java.util.List;
import modelo.ConceptoDeduccion;

public class ConceptoDeduccionControlador {
    private ConceptoDeduccionDAO conceptoDeduccionDAO;

    public ConceptoDeduccionControlador() {
        conceptoDeduccionDAO = new ConceptoDeduccionDAO();
    }

    public void crearConceptoDeduccion(int codigo, String nombre) {
        ConceptoDeduccion conceptoDeduccion = new ConceptoDeduccion(codigo, nombre);
        conceptoDeduccionDAO.crear(conceptoDeduccion);
    }

    public void actualizarConceptoDeduccion(int index, int nuevoCodigo, String nuevoNombre) {
        ConceptoDeduccion conceptoDeduccion = new ConceptoDeduccion(nuevoCodigo, nuevoNombre);
        conceptoDeduccionDAO.actualizar(index, conceptoDeduccion);
    }

    public void eliminarConceptoDeduccion(int index) {
        conceptoDeduccionDAO.eliminar(index);
    }

    public ConceptoDeduccion obtenerConceptoDeduccion(int index) {
        return conceptoDeduccionDAO.obtener(index);
    }

    public List<ConceptoDeduccion> obtenerTodosConceptosDeduccion() {
        return conceptoDeduccionDAO.obtenerTodos();
    }
}