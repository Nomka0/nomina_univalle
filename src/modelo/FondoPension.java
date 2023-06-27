package modelo;

public class FondoPension extends Entidad {
	int codigo;
	String nombre_pension;
	
	public FondoPension(int codigo, String nombre_pension) {
		super(codigo, nombre_pension);
	}
	
	public FondoPension() {
		super();
	}
}
