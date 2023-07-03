package modelo;

public class EPS extends Entidad{
	int codigo;
	String nombre;
	
	public EPS(int codigo, String nombre) {
		super(codigo, nombre);
	}
	
	public EPS() {
		super();
	}

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
	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Nombre: " + nombre ;
	}
}

