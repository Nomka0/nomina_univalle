
package modelo;




public class DevengosHacenBase {
    private double salud;
    private double fondoPension;
    private double prestamoEmpleado;
    private double devengosBase;

    public DevengosHacenBase(double salud, double fondoPension, double prestamoEmpleado, double devengosBase) {
        this.salud = salud;
        this.fondoPension = fondoPension;
        this.prestamoEmpleado = prestamoEmpleado;
        this.devengosBase = devengosBase;
    }

    public double calcularDeduccionSalud() {
        return devengosBase * salud;
    }

    public double calcularDeduccionFondoPension() {
        return devengosBase * fondoPension;
    }


    public double calcularDeduccionPrestamo(double prestamoEmpleado, double devengosBase, double salarioMinimo) {
        double deduccion;
        if (devengosBase < salarioMinimo) {
            deduccion = prestamoEmpleado;
        } else {
            deduccion = prestamoEmpleado * (devengosBase / salarioMinimo);
        }
        return deduccion;
    }


    public double calcularCesantias() {
        return devengosBase * 0.0833;
    }

    public double calcularInteresCesantias() {
        return devengosBase * 0.01;
    }

    public double calcularPrimas() {
        return devengosBase * 0.0833;
    }

    public double calcularVacaciones() {
        return devengosBase * 0.0417;
    }
}
