package modelo;

public class ConfigEmpresa {
	ARL arl;
	CajaCompensacion caja_comp;

	int NIT;
	String nombre;
	long telefono;
	String direccion;
	String rep_legal;
	String correo;
	public static final int SMLV = 1160000; //salario minimo legal vigente
	public static final int AUX_TRANSPORTE = 140600;
	int codigo_arl;
	int codigo_compensacion;
	
	public ConfigEmpresa(int NIT, String nombre, long telefono, String direccion, String rep_legal, String correo,
			int codigo_arl, int codigo_compensacion) {
		arl = new ARL(codigo_arl,"Sura");
		caja_comp = new CajaCompensacion(codigo_compensacion, "Cafam");
		
		this.NIT = NIT;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.rep_legal = rep_legal;
		this.correo = correo;
		codigo_arl = arl.getCodigo();
		codigo_compensacion = caja_comp.getCodigo();
		}
	
	public ConfigEmpresa() {}

	public ARL getArl() {
		return arl;
	}

	public void setArl(ARL arl) {
		this.arl = arl;
	}

	public CajaCompensacion getCaja_comp() {
		return caja_comp;
	}

	public void setCaja_comp(CajaCompensacion caja_comp) {
		this.caja_comp = caja_comp;
	}

	public int getNIT() {
		return NIT;
	}

	public void setNIT(int nIT) {
		NIT = nIT;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRep_legal() {
		return rep_legal;
	}

	public void setRep_legal(String rep_legal) {
		this.rep_legal = rep_legal;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getCodigo_arl() {
		return codigo_arl;
	}

	public void setCodigo_arl(int codigo_arl) {
		this.codigo_arl = codigo_arl;
	}

	public int getCodigo_compensacion() {
		return codigo_compensacion;
	}

	public void setCodigo_compensacion(int codigo_compensacion) {
		this.codigo_compensacion = codigo_compensacion;
	}
	
}

/*
NIT
• Razón social o Nombre
• Teléfono
• Dirección
• Representante Legal
• Correo de Contacto
• ARL (Código)
• Caja de Compensación (Código)
• Salario Mínimo Legal Vigente
• Auxilio de Transporte
*/