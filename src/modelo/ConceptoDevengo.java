package modelo;

public class ConceptoDevengo extends Entidad{
	int codigo;
	String nombre;
	boolean hace_base;
	
	public ConceptoDevengo(int codigo, String nombre, boolean hace_base) {
		super(codigo, nombre);
		hace_base = false;
	}
	
	public ConceptoDevengo() {
		super();
	}
	
	public boolean getHaceBase() {
		return hace_base;
	}
	
	public 
	
	public void setHaceBase(boolean hace_base) {
		this.hace_base = hace_base;
	}
}


