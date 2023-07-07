package controlador;

import vista.*;
import modelo.*;
import dao.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu implements ActionListener {

    private BotonesClase vistaActual;
    private EmpleadoVista EmpleadoVista;
    private CajaCompensacionVista CajaCompensacionVista;
    private ConfigEmpresaVista ConfigEmpresaVista;
    private ConfigEmpresa ConfigEmpresa;
    private CajaCompensacion CajaCompensacion;
    private Empleado Empleado;
    private EmpleadoDAO EmpleadoDAO;
    private CajaCompensacionDAO CajaCompensacionDAO;
    private ConfigEmpresaDAO ConfigEmpresaDAO;
    private ARL ARL;
    private ARLDAO ARLDAO;
    private ARLVista ARLVista;
    private EPS EPS;
    private EPSDAO EPSDAO;
    private EPSVista EPSVista;
    private EPSControlador EPSControlador;
    private FondoPension FondoPension;
    private FondoPensionDAO FondoPensionDAO;
    private FondoPensionVista FondoPensionVista;
    private FondoPensionControlador FondoPensionControlador;

    


    public Menu(BotonesClase vistaActual) {
        this.vistaActual = vistaActual;
        this.vistaActual.empleadoButton.addActionListener(this);
        this.vistaActual.cajaCompensacionButton.addActionListener(this);
        this.vistaActual.empresaButton.addActionListener(this);
        this.vistaActual.arlButton.addActionListener(this);
        this.vistaActual.epsButton.addActionListener(this);
        this.vistaActual.fondoPensionButton.addActionListener(this);

        this.EmpleadoVista = new EmpleadoVista();
        this.CajaCompensacionVista = new CajaCompensacionVista();
        this.ConfigEmpresaVista = new ConfigEmpresaVista();
        this.ARLVista = new ARLVista();
        this.EPSVista = new EPSVista();
        this.FondoPensionVista = new FondoPensionVista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaActual.empleadoButton) {
            EmpleadoControlador controlador = new EmpleadoControlador(EmpleadoVista);
            EmpleadoVista.setVisible(true);
            vistaActual.setVisible(false);
        }
        if (e.getSource() == vistaActual.cajaCompensacionButton) {
            CajaCompensacionController controlador = new CajaCompensacionController(CajaCompensacionVista);
            CajaCompensacionVista.setVisible(true);
            vistaActual.setVisible(false);
        }
         if (e.getSource() == vistaActual.empresaButton) {
           ConfigEmpresaControlador controlador = new ConfigEmpresaControlador(ConfigEmpresaVista);
            ConfigEmpresaVista.setVisible(true);
            vistaActual.setVisible(false);
        }

        if (e.getSource() == vistaActual.arlButton) {
            ARLControlador controlador = new ARLControlador(ARLVista);
            ARLVista.setVisible(true);
            vistaActual.setVisible(false);
        }

        if (e.getSource() == vistaActual.epsButton) {
            EPSControlador controlador = new EPSControlador(EPSVista);
            EPSVista.setVisible(true);
            vistaActual.setVisible(false);
        }

        if (e.getSource() == vistaActual.fondoPensionButton) {
            FondoPensionControlador controlador = new FondoPensionControlador(FondoPensionVista);
            FondoPensionVista.setVisible(true);
            vistaActual.setVisible(false);
        }
    }
}
