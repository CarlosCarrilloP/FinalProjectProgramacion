package interfazGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CrearCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CrearCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Direccion
		textField_4 = new JTextField();
		textField_4.setBounds(345, 219, 200, 44);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero=textField_2.getText();
				 if (validarTelefono(numero)) {
					 String datos = obtenerDatosDelFormulario();
					 guardarDatosEnArchivo(datos);
					 dispose(); // Cierra la ventana actual 
					 RealizarPedido1 realizarPedido1 = new RealizarPedido1();
					 realizarPedido1.setVisible(true);
				 }else {
					 JOptionPane.showMessageDialog(null, "El número de teléfono no es válido");
				 }
				
			}
		});
		btnNewButton.setBounds(219, 285, 173, 52);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("DIRECCION");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(391, 173, 142, 44);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CREAR CLIENTE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(219, 28, 173, 32);
		contentPane.add(lblNewLabel_3);
		
		//Apellido
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(35, 219, 200, 44);
		contentPane.add(textField_3);
		
		//Telefono
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(345, 99, 200, 44);
		contentPane.add(textField_2);
		
		//Nombre
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(35, 99, 200, 44);
		contentPane.add(textField_1);

		JLabel lblNewLabel_2_1 = new JLabel("NOMBRE");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(99, 59, 142, 44);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("TELEFONO");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(391, 59, 142, 44);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("APELLIDOS");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(88, 173, 142, 44);
		contentPane.add(lblNewLabel_2_3);
	}

	private boolean validarTelefono(String numero) {
		// Expresión regular para verificar el formato del número de teléfono
		String regex = "^[6-9]\\d{8}$";
		return numero.matches(regex);
	}
	private String obtenerDatosDelFormulario() {
	   
	    String nombre = textField_1.getText();
	    String apellidos = textField_3.getText();
	    String direccion = textField_4.getText();
	    String telefono = textField_2.getText();

	    // Puedes combinar los datos en una sola cadena o darle el formato que desees
	    String datos =  nombre + "," + apellidos + "," + telefono + "," + direccion;

	    return datos;
	}

	private void guardarDatosEnArchivo(String datos) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Carlos Carrillo/eclipse-workspace/FinalProjectProgramacion/src/Archivos/Cliente.txt", true));
			writer.write(datos);
			writer.newLine();
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
