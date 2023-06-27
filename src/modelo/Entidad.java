package modelo;

public abstract class Entidad {
	protected int codigo;
	protected String nombre;
	
	public Entidad(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public Entidad() {}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
