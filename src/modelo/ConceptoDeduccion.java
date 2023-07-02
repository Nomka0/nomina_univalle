package modelo;

import dao.ConceptoDevengoDAO;
import java.util.List;
import modelo.ConceptoDevengo;
import modelo.Entidad;

public class ConceptoDeduccion extends Entidad {
    private int codigo;
    private String nombre;
    private boolean esAutomatico;
    private double valorBase;
    
    public ConceptoDeduccion(int codigo, String nombre, boolean esAutomatico, double valorBase) {
        super(codigo, nombre);
        this.esAutomatico = esAutomatico;
        this.valorBase = valorBase;
    }
    
    public ConceptoDeduccion() {
        super();
    }
    
    public boolean esAutomatico() {
        return esAutomatico;
    }
    
    public void setAutomatico(boolean esAutomatico) {
        this.esAutomatico = esAutomatico;
    }
    
    public double getValorBase() {
        return valorBase;
    }
    
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
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
