package modelo;

public class ARL extends Entidad{
	int codigo;
	String nombre_arl;
	
	public ARL(int codigo, String nombre_arl) {
		super(codigo, nombre_arl);
	}
	
	public ARL() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre_arl() {
		return nombre_arl;
	}

	public void setNombre_arl(String nombre_arl) {
		this.nombre_arl = nombre_arl;
	}
}

