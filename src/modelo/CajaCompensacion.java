package modelo;

import java.util.Date;

public class CajaCompensacion {
    public String codigo;
    public String nombre;
    public Date fechaNacimiento;
    public Date fechaIngreso;
    public Date fechaRetiro;
    public String tipoTrabajador;
    public String tipoSalario;
    public String numeroCuentaBancaria;

    // Constructor
    public CajaCompensacion(String codigo, String nombre, Date fechaNacimiento, Date fechaIngreso, Date fechaRetiro,
                            String tipoTrabajador, String tipoSalario, String numeroCuentaBancaria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.tipoTrabajador = tipoTrabajador;
        this.tipoSalario = tipoSalario;
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public String getTipoSalario() {
        return tipoSalario;
    }

    public void setTipoSalario(String tipoSalario) {
        this.tipoSalario = tipoSalario;
    }

    public String getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }
}
