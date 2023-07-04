import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FondoPensionVista extends JFrame {

    private JPanel contentPane;
    private JTextField txtNombreFondoPension;
    private JTextField txtCodigoFondoPension;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FondoPensionVista frame = new FondoPensionVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FondoPensionVista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 10, 60, 20);
        contentPane.add(lblNombre);

        txtNombreFondoPension = new JTextField();
        txtNombreFondoPension.setBounds(80, 10, 150, 20);
        contentPane.add(txtNombreFondoPension);
        txtNombreFondoPension.setColumns(10);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 40, 60, 20);
        contentPane.add(lblCodigo);

        txtCodigoFondoPension = new JTextField();
        txtCodigoFondoPension.setBounds(80, 40, 150, 20);
        contentPane.add(txtCodigoFondoPension);
        txtCodigoFondoPension.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 230, 100, 30);
        contentPane.add(btnGuardar);
    }
}
