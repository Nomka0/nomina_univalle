package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class BotonesClase {
    private JFrame frame;
    private JPanel panel;
    public JButton epsButton;
    public JButton arlButton;
    public JButton empresaButton;
    public JButton cajaCompensacionButton;
    public JButton fondoPensionButton;
    public JButton empleadoButton;
    private JLabel titleLabel;
    
    public BotonesClase() {
        frame = new JFrame();
        frame.setTitle("Nómina Sureños");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        
        titleLabel = createLabel("NÓMINA SUREÑOS");
        epsButton = createButton("EPS");
        arlButton = createButton("ARL");
        empresaButton = createButton("Empresa");
        cajaCompensacionButton = createButton("Caja de Compensación");
        fondoPensionButton = createButton("Fondo de Pensión");
        empleadoButton = createButton("Empleado");
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 2, 10, 10));
        buttonsPanel.add(epsButton);
        buttonsPanel.add(arlButton);
        buttonsPanel.add(empresaButton);
        buttonsPanel.add(cajaCompensacionButton);
        buttonsPanel.add(fondoPensionButton);
        buttonsPanel.add(empleadoButton);
        
        panel.add(titleLabel);
        panel.add(buttonsPanel);
        
        frame.getContentPane().add(panel);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
    
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(new Color(51, 153, 255));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
    
    public static void main(String[] args) {
        new BotonesClase();
    }



    public void setVisible(boolean b) {
    }

    public void dispose() {
    }

    public JButton getEpsButton() {
        return epsButton;
    }

    public JButton getArlButton() {
        return arlButton;
    }

    public JButton getEmpresaButton() {
        return empresaButton;
    }

    public JButton getCajaCompensacionButton() {
        return cajaCompensacionButton;
    }

    public JButton getFondoPensionButton() {
        return fondoPensionButton;
    }

    public JButton getEmpleadoButton() {
        return empleadoButton;
    }
}





