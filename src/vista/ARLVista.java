package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ARLVista extends JFrame {

    private JPanel contentPane;
    private JTextField txtNombreARL;
    private JTextField txtCodigoARL;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ARLVista frame = new ARLVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ARLVista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 10, 60, 20);
        contentPane.add(lblNombre);

        txtNombreARL = new JTextField();
        txtNombreARL.setBounds(80, 10, 150, 20);
        contentPane.add(txtNombreARL);
        txtNombreARL.setColumns(10);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 40, 60, 20);
        contentPane.add(lblCodigo);

        txtCodigoARL = new JTextField();
        txtCodigoARL.setBounds(80, 40, 150, 20);
        contentPane.add(txtCodigoARL);
        txtCodigoARL.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 230, 100, 30);
        contentPane.add(btnGuardar);
        
        
        
        
    }

}
