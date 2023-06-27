package dao;

import java.util.List;

public interface GenericDAO<T> {
    
	void crear(T entidad);
    
    T obtener(int index);
    
    List<T> obtenerTodos();
    
    void actualizar(int index, T entidad);
    
    void eliminar(int index);
}
