package modelo;

public class FondoPension extends Entidad{
	int codigo;
	String nombre;
	
	public FondoPension(int codigo, String nombre) {
		super(codigo, nombre);
	}
	
	public FondoPension() {
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

