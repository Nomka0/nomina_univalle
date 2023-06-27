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
	public int getFichaEmpleado() {
		return ficha_empleado;
	}
	public void setFichaEmpleado(int ficha_empleado) {
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
	public String getFechaNacimiento() {
		return fecha_nacimiento;
	}
	public void setFechaNacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getFechaIngreso() {
		return fecha_ingreso;
	}
	public void setFechaIngreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public String getFechaRetiro() {
		return fecha_retiro;
	}
	public void setFechaRetiro(String fecha_retiro) {
		this.fecha_retiro = fecha_retiro;
	}
	public boolean getTipoTrabajador() {
		return tipo_trabajador;
	}
	public void setTipoTrabajador(boolean tipo_trabajador) {
		this.tipo_trabajador = tipo_trabajador;
	}
	public boolean getTipoSalario() {
		return tipo_salario;
	}
	public void setTipoSalario(boolean tipo_salario) {
		this.tipo_salario = tipo_salario;
	}
	public long getCuentaBancaria() {
		return cuenta_bancaria;
	}
	public void setCuentaBancaria(long cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}
}
