package modelo;

public class CajaCompensacion extends Entidad{
	int codigo;
	String nombre_caja;
	
	public CajaCompensacion(int codigo, String nombre_caja) {
		super(codigo, nombre_caja);
	}
	
	public CajaCompensacion() {
		super();
	}

}

