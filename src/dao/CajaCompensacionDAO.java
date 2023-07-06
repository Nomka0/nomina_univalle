package dao;

import modelo.CajaCompensacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CajaCompensacionDAO {
    private List<CajaCompensacion> cajas;

    public CajaCompensacionDAO() {
        cajas = new ArrayList<>();
    }

    public void agregarCaja(CajaCompensacion caja) {
        cajas.add(caja);
    }

    public void eliminarCaja(CajaCompensacion caja) {
        cajas.remove(caja);
    }

    public List<CajaCompensacion> obtenerCajas() {
        return cajas;
    }

    public CajaCompensacion buscarCajaPorCodigo(int codigo) {
        for (CajaCompensacion caja : cajas) {
            if (caja.getCodigo() == codigo) {
                return caja;
            }
        }
        return null; // Si no se encuentra la caja
    }

    public List<CajaCompensacion> buscarCajasPorFechaIngreso(Date fechaIngreso) {
        List<CajaCompensacion> cajasEncontradas = new ArrayList<>();
        for (CajaCompensacion caja : cajas) {
            if (caja.getFechaIngreso().equals(fechaIngreso)) {
                cajasEncontradas.add(caja);
            }
        }
        return cajasEncontradas;
    }

    // Otros métodos de consulta o actualización de la base de datos podrían ir aquí

    // Ejemplo de uso del DAO
    public static void main(String[] args) {
        CajaCompensacionDAO dao = new CajaCompensacionDAO();

        // Crear una nueva caja
        CajaCompensacion caja1 = new CajaCompensacion(001, "Caja 1", new Date(), new Date(), null, "Tipo 1",
                "Salario 1", "123456789");
        dao.agregarCaja(caja1);

        // Obtener todas las cajas
        List<CajaCompensacion> cajas = dao.obtenerCajas();
        System.out.println("Cajas disponibles:");
        for (CajaCompensacion caja : cajas) {
            System.out.println(caja.getNombre());
        }

        // Buscar una caja por código
        int codigoBuscado = 001;
        CajaCompensacion cajaEncontrada = dao.buscarCajaPorCodigo(codigoBuscado);
        if (cajaEncontrada != null) {
            System.out.println("Caja encontrada: " + cajaEncontrada.getNombre());
        } else {
            System.out.println("Caja no encontrada");
        }
    }
}