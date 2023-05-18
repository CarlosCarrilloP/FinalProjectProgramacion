package interfazGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import carlosPedido.TratamientoFicheros;

public class pantallaInicio2 extends JFrame {
    String ruta = "C:/Users/Carlos Carrillo/eclipse-workspace/FinalProjectProgramacion/src/Archivos/Cliente.txt/";
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pantallaInicio2 frame = new pantallaInicio2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pantallaInicio2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 613, 384);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Continuar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = textField.getText();

                if (validarTelefono(numero)) {
                    if (existeNumero(numero)) {
                        RealizarPedido1 frame = new RealizarPedido1();
                        frame.setVisible(true);
                        JOptionPane.showMessageDialog(null, "El cliente está registrado");
                    } else {
                        CrearCliente frame = new CrearCliente();
                        frame.setVisible(true);
                        JOptionPane.showMessageDialog(null, "El cliente no está registrado");
                    }
                    dispose(); // Cierra la ventana actual
                } else {
                    JOptionPane.showMessageDialog(null, "El número de teléfono no es válido");
                }
            }
        });

        btnNewButton.setBounds(203, 263, 189, 58);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Introduzca su número de teléfono y pulse Continuar");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(84, 23, 421, 141);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(172, 151, 241, 73);
        contentPane.add(textField);
        textField.setColumns(10);
    }

    private boolean existeNumero(String numero) {
        List<String[]> lineas = TratamientoFicheros.fileScannerCliente(ruta);
        for (String[] datos : lineas) {
            if (datos.length >= 3 && datos[2].trim().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    private boolean validarTelefono(String numero) {
        // Expresión regular para verificar el formato del número de teléfono
        String regex = "^[6-9]\\d{8}$";
        return numero.matches(regex);
    }
}
