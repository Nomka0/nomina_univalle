package modelo;

public class Empleado {
	int id;
	int ficha_empleado;	
	String nombre;
	String apellido;
	String direccion;
	int eps; //código
	int fpp; //fondo de pensión. código
	String fecha_nacimiento;
	String fecha_ingreso;
	String fecha_retiro;
	boolean tipo_trabajador; //true: socio; false: no socio
	boolean tipo_salario; //true: acumulado; false: fijo
	long cuenta_bancaria;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFicha_empleado() {
		return ficha_empleado;
	}
	public void setFicha_empleado(int ficha_empleado) {
		this.ficha_empleado = ficha_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEps() {
		return eps;
	}
	public void setEps(int eps) {
		this.eps = eps;
	}
	public int getFpp() {
		return fpp;
	}
	public void setFpp(int fpp) {
		this.fpp = fpp;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public String getFecha_retiro() {
		return fecha_retiro;
	}
	public void setFecha_retiro(String fecha_retiro) {
		this.fecha_retiro = fecha_retiro;
	}
	public boolean isTipo_trabajador() {
		return tipo_trabajador;
	}
	public void setTipo_trabajador(boolean tipo_trabajador) {
		this.tipo_trabajador = tipo_trabajador;
	}
	public boolean isTipo_salario() {
		return tipo_salario;
	}
	public void setTipo_salario(boolean tipo_salario) {
		this.tipo_salario = tipo_salario;
	}
	public long getCuenta_bancaria() {
		return cuenta_bancaria;
	}
	public void setCuenta_bancaria(long cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}
}
