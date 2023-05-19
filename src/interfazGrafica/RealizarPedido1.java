package interfazGrafica;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class RealizarPedido1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	private List<String> cargarNombresProductos(String rutaArchivo) {
        List<String> nombresProductos = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            for (String linea : lineas) {
                String[] campos = linea.split(",");
                if (campos.length > 0) {
                    nombresProductos.add(campos[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombresProductos;
    }
	
	public RealizarPedido1() {
		List<String> nombresProductos = cargarNombresProductos("C:/Users/Carlos Carrillo/eclipse-workspace/FinalProjectProgramacion/src/Archivos/Producto.txt");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("MENU PRODUCTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(205, 20, 208, 20);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton(nombresProductos.get(0));
		btnNewButton.setBounds(68, 117, 159, 75);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(0));
				dispose(); // Cierra la ventana actual
			
				
			}
		});
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("ELIGE UN PRODUCTO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(214, 71, 297, 20);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_3 = new JButton("Terminar Pedido");
		btnNewButton_3.setBounds(231, 298, 168, 39);
		contentPane.add(btnNewButton_3);

		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      //LOGICA

		        dispose(); // Cierra la ventana actual
		    }
		});


		JButton btnNewButton_1 = new JButton(nombresProductos.get(1));
		btnNewButton_1.setBounds(237, 117, 176, 75);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(1));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(nombresProductos.get(2));
		btnNewButton_2.setBounds(422, 117, 146, 75);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(2));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton(nombresProductos.get(3));
		btnNewButton_4.setBounds(151, 213, 168, 75);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(3));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton(nombresProductos.get(4));
		btnNewButton_5.setBounds(349, 213, 176, 75);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(4));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_5);
	}

	public void solicitarCantidad(String producto) {
	    JDialog dialog = new JDialog(this, "Cantidad", true);
	    dialog.setSize(300, 300);
	    dialog.getContentPane().setLayout(new FlowLayout());

	    JLabel cantidadLabel = new JLabel("Cantidad para " + producto + ":");
	    JTextField cantidadField = new JTextField(10);

	    JButton okButton = new JButton("ENVIAR");
	    okButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String cantidad = cantidadField.getText();
	            try {
	                int cantidadNumerica = Integer.parseInt(cantidad);

	                if (cantidadNumerica >= 1 && cantidadNumerica <= 30) {
	                    JOptionPane.showMessageDialog(null, "Cantidad ingresada para " + producto + ": " + cantidad);
	                    dialog.dispose(); // Cerrar la ventana secundaria
	                    RealizarPedido2 realizarPedido2 = new RealizarPedido2(producto,cantidadNumerica);
	                    realizarPedido2.setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(null, "La cantidad debe estar entre 1 y 30 unidades.", "Error", JOptionPane.ERROR_MESSAGE);
	                    cantidadField.setText(""); // Limpiar el campo de texto
		                cantidadField.requestFocus(); // Colocar el foco en el campo de texto
	                }
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "La cantidad ingresada no es un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
	                // Volver a solicitar la cantidad
	                cantidadField.setText(""); // Limpiar el campo de texto
	                cantidadField.requestFocus(); // Colocar el foco en el campo de texto
	            }
	        }
	    });

	    dialog.getContentPane().add(cantidadLabel);
	    dialog.getContentPane().add(cantidadField);
	    dialog.getContentPane().add(okButton);

	    dialog.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				RealizarPedido1 frame = new RealizarPedido1();
				frame.setVisible(true);
			}
		});
	}
}
