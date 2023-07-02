package modelo;

import dao.ConceptoDevengoDAO;
import java.util.List;

public class ConceptoDeduccion extends Entidad {
    private int codigo;
    private String nombre;

    public ConceptoDeduccion(int codigo, String nombre) {
        super(codigo, nombre);
        this.codigo = codigo;
        this.nombre = nombre;
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
