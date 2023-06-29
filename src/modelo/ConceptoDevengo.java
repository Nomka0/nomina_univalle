package modelo;

public class ConceptoDevengo extends Entidad{
	int codigo;
	String nombre;
	
	String fecha;
	boolean hace_base;
	 
	
	public ConceptoDevengo(int codigo, String nombre, boolean hace_base, String fecha) {
		super(codigo, nombre);
		this.fecha = fecha;
		hace_base = false;
	}
	
	public ConceptoDevengo() {
		super();
	}
	
	public boolean getHaceBase() {
		return hace_base;
	}
	
	public void setHaceBase(boolean hace_base) {
		this.hace_base = hace_base;
	}
	
	
	
}


