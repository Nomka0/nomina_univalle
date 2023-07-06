package modelo;

public class Empleado {
    int id;
    int ficha_eps;
    String nombre;
    String apellido;
    String direccion;
    int eps; // código
    int fpp; // fondo de pensión. código
    String fecha_nacimiento;
    String fecha_ingreso;
    String fecha_retiro;
    String tipo_trabajador; // true: socio; false: no socio
    boolean tipo_salario; // true: acumulado; false: fijo
    int codigo;
    long cuenta_bancaria;

    public Empleado(int id, int ficha_eps, String nombre, String apellido, String direccion, int eps, int fpp,
            String fecha_nacimiento, String fecha_ingreso, String fecha_retiro, String tipo_trabajador,
            boolean tipo_salario, long cuenta_bancaria) {
        this.id = id;
        this.ficha_eps = ficha_eps;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.eps = eps;
        this.fpp = fpp;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_retiro = fecha_retiro;
        this.tipo_trabajador = tipo_trabajador;
        this.tipo_salario = tipo_salario;
        this.cuenta_bancaria = cuenta_bancaria;
    }

public Empleado(int codigo, String nombres, String apellidos, String fechaIngreso, String fechaRetiro,
    String direccion) {
    this.codigo = codigo;
    this.nombre = nombres;
    this.apellido = apellidos;
    this.fecha_ingreso = fechaIngreso;
    this.fecha_retiro = fechaRetiro;
    this.direccion=direccion;
   // this.tipo_trabajador = tipoTrabajador;

}


    public int getCodigo() {
        return codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFichaEmpleado() {
        return ficha_eps;
    }

    public void setFichaEmpleado(int ficha_eps) {
        this.ficha_eps = ficha_eps;
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

    public String getTipoTrabajador() {
        return tipo_trabajador;
    }

    public void setTipoTrabajador(String tipo_trabajador) {
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

    @Override
    public String toString() {
        return "Código: " + codigo + "\nNombres: " + nombre + "\nApellidos: " + apellido + "\nFecha de Ingreso: "
                + fecha_ingreso + "\nFecha de Retiro: " + fecha_retiro + "\nDireccion: " + direccion;
    }
}
