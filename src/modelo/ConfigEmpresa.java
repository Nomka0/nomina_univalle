package modelo;

import java.util.Vector;

public class ConfigEmpresa {
    private String nit;
    private String nombre;
    private String telefono;
    private String direccion;
    private String representanteLegal;
    private String correoContacto;
    private String arl;
    private String cajaCompensacion;
    private String salarioMinimo;
    private String auxilioTransporte;

    public ConfigEmpresa(String nit, String nombre, String telefono, String direccion, String representanteLegal,
                         String correoContacto, String arl, String cajaCompensacion, String salarioMinimo,
                         String auxilioTransporte) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.representanteLegal = representanteLegal;
        this.correoContacto = correoContacto;
        this.arl = arl;
        this.cajaCompensacion = cajaCompensacion;
        this.salarioMinimo = salarioMinimo;
        this.auxilioTransporte = auxilioTransporte;
    }

    public String getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public String getArl() {
        return arl;
    }

    public String getCajaCompensacion() {
        return cajaCompensacion;
    }

    public String getSalarioMinimo() {
        return salarioMinimo;
    }

    public String getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public String[] toArray() {
    String[] array = new String[10];
    array[0] = this.nit;
    array[1] = this.nombre;
    array[2] = this.telefono;
    array[3] = this.direccion;
    array[4] = this.representanteLegal;
    array[5] = this.correoContacto;
    array[6] = this.arl;
    array[7] = this.cajaCompensacion;
    array[8] = this.salarioMinimo;
    array[9] = this.auxilioTransporte;
    return array;
}

}
