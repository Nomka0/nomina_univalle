package modelo;

import dao.ConceptoDevengoDAO;
import java.util.List;

public class ConceptoDeduccion extends Entidad {
    private int codigo;
    private String nombre;
    private int ficha;
    private String fechaCorte;
    private String tipoDeduccion;
    private double valorDeduccion;

    public ConceptoDeduccion(int codigo, String nombre, int ficha, String fechaCorte, String tipoDeduccion, double valorDeduccion) {
        super(codigo, nombre);
        this.ficha = ficha;
        this.fechaCorte = fechaCorte;
        this.tipoDeduccion = tipoDeduccion;
        this.valorDeduccion = valorDeduccion;
    }

    public ConceptoDeduccion() {
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

    public int getFicha() {
        return ficha;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

    public String getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public String getTipoDeduccion() {
        return tipoDeduccion;
    }

    public void setTipoDeduccion(String tipoDeduccion) {
        this.tipoDeduccion = tipoDeduccion;
    }

    public double getValorDeduccion() {
        return valorDeduccion;
    }

    public void setValorDeduccion(double valorDeduccion) {
        this.valorDeduccion = valorDeduccion;
    }

    public double calcularValorDeduccion(double sumatoriaDevengos, double salarioMinimo) {
        // Deducción automática de salud y fondo de pensión
        if (sumatoriaDevengos > salarioMinimo) {
            double porcentajeDeduccion = 0.04; // 4% para salud y fondo de pensión
            return sumatoriaDevengos * porcentajeDeduccion;
        } else {
            // Deducción basada en el salario mínimo vigente
            double valorDeduccion = 10000; // Ejemplo: valor de la deducción
            return valorDeduccion;
        }
    }

    public double sumatoria(ConceptoDevengoDAO sacarDevengos) {
        double sumatoriaDevengos = 0;
        List<ConceptoDevengo> devengosAnalizar = sacarDevengos.obtenerTodos();
        for (ConceptoDevengo devengoAnalizar : devengosAnalizar) {
            double devengoSumar = devengoAnalizar.getValorDevengo();
            sumatoriaDevengos += devengoSumar;
        }
        return sumatoriaDevengos;
    }
}
