package modelo;

public class ConceptoDeduccion extends Entidad {
    private int codigo;
    private String nombre;

    public ConceptoDeduccion(int codigo, String nombre) {
        super(codigo, nombre);
    }

    public ConceptoDeduccion() {
        super();
    }

    public double calcularDeduccionAutomatica(double sumatoriaDevengos) {
        double porcentajeDeduccion = 0.04; // 4% for both health and pension deductions
        return sumatoriaDevengos * porcentajeDeduccion;
    }

    public double calcularDeduccionPorValor(double sumatoriaDevengos, double valorDeduccion) {
        double salarioMinimoVigente = 1000.0; // Example value for the current minimum wage
        double deduccion;

        if (sumatoriaDevengos < salarioMinimoVigente) {
            deduccion = salarioMinimoVigente; // Deduction based on the minimum wage
        } else {
            deduccion = valorDeduccion; // Deduction based on a specific value
        }

        return deduccion;
    }
}