
package controlador;
import dao.DevengosHacenBaseDAO;

public class DevengosHacenBaseControlador {
    private DevengosHacenBaseDAO devengosHacenBaseDAO;
    private double salarioMinimo;

    public DevengosHacenBaseControlador(double salarioMinimo) {
        devengosHacenBaseDAO = new DevengosHacenBaseDAO();
        this.salarioMinimo = salarioMinimo;
    }
    

    public double calcularDeduccionSalud(double salud, double devengosBase) {
        return devengosHacenBaseDAO.calcularDeduccionSalud(salud, devengosBase);
    }

    public double calcularDeduccionFondoPension(double fondoPension, double devengosBase) {
        return devengosHacenBaseDAO.calcularDeduccionFondoPension(fondoPension, devengosBase);
    }
 
        public double calcularDeduccionPrestamo(double prestamoEmpleado, double devengosBase) {
        return devengosHacenBaseDAO.calcularDeduccionPrestamo(prestamoEmpleado, devengosBase);
    }

    public double calcularCesantias(double devengosBase) {
        return devengosHacenBaseDAO.calcularCesantias(devengosBase);
    }

    public double calcularInteresCesantias(double devengosBase) {
        return devengosHacenBaseDAO.calcularInteresCesantias(devengosBase);
    }

    public double calcularPrimas(double devengosBase) {
        return devengosHacenBaseDAO.calcularPrimas(devengosBase);
    }

    public double calcularVacaciones(double devengosBase) {
        return devengosHacenBaseDAO.calcularVacaciones(devengosBase);
    }
}
