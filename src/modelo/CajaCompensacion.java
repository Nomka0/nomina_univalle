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
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre_caja() {
		return nombre_caja;
	}

	public void setNombre_caja(String nombre_caja) {
		this.nombre_caja = nombre_caja;
	}
}

