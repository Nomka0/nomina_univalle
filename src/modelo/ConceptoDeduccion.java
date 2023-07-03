package modelo;

import dao.ConceptoDevengoDAO;
import java.util.List;

public class ConceptoDeduccion extends Entidad {
    private int ficha;
    private String fechaCorte;
    private String tipoDeduccion;
    private double valorDeduccion;
    public static final int SMLV = 1160000;

    public ConceptoDeduccion(int ficha, String fechaCorte, String concepto, String tipoDeduccion, double valorDeduccion) {
    	super(ficha, concepto);

        this.ficha = ficha;
        this.fechaCorte = fechaCorte;
        this.tipoDeduccion = tipoDeduccion;
        this.valorDeduccion = valorDeduccion;
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

    public void calcularValorAuto(double sumatoriaDevengos) {
        // Deducción automática de salud y fondo de pensión
        if (sumatoriaDevengos > SMLV) {
            double porcentajeDeduccion = 0.04; // 4% para salud y fondo de pensión
            double valor_auto = sumatoriaDevengos * porcentajeDeduccion;
            setValorDeduccion(valor_auto);
        } else {
            // Deducción basada en el salario mínimo vigente
            double valor_auto = SMLV * 0.04;
            setValorDeduccion(valor_auto);
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