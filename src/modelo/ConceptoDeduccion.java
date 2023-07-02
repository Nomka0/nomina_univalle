package modelo;

public class ConceptoDeduccion extends Entidad {
    int codigo;
    String nombre;
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
}
