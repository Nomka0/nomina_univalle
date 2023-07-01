
package dao;


public class DevengosHacenBaseDAO {
    private double salarioMinimo;

    public DevengosHacenBaseDAO() {
        salarioMinimo = 1000.0; // Establece el valor del salario mínimo según tus necesidades
    }

    public double calcularDeduccionSalud(double salud, double devengosBase) {
        return devengosBase * salud;
    }

    public double calcularDeduccionFondoPension(double fondoPension, double devengosBase) {
        return devengosBase * fondoPension;
    }

    public double calcularDeduccionPrestamo(double prestamoEmpleado, double devengosBase) {
        double deduccion;
        if (devengosBase < salarioMinimo) {
            deduccion = prestamoEmpleado;
        } else {
            deduccion = prestamoEmpleado * (devengosBase / salarioMinimo);
        }
        return deduccion;
    }

    public double calcularCesantias(double devengosBase) {
        return devengosBase * 0.0833;
    }

    public double calcularInteresCesantias(double devengosBase) {
        return devengosBase * 0.01;
    }

    public double calcularPrimas(double devengosBase) {
        return devengosBase * 0.0833;
    }

    public double calcularVacaciones(double devengosBase) {
        return devengosBase * 0.0417;
    }
}
