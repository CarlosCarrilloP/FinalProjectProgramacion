package interfazGrafica;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class RealizarPedido2 extends JFrame {
	private JPanel contentPane;

	public RealizarPedido2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("¿Desea otro producto?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(183, 20, 284, 20);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Refresco Cola");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(69, 117, 158, 75);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Refresco Cola");
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("ELIGE UN 2º PRODUCTO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(214, 71, 297, 20);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_3 = new JButton("Terminar Pedido");
		btnNewButton_3.setBounds(228, 298, 168, 39);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	dispose(); // Cerrar la ventana secundaria
		    	 // Crear y mostrar el JFrame "Final"
				Final Final = new Final();
		        Final.setVisible(true);
		    }
		});

		JButton btnNewButton_1 = new JButton("Refresco Naranja");
		btnNewButton_1.setBounds(237, 117, 159, 75);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Refresco Naranja");
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Agua");
		btnNewButton_2.setBounds(408, 117, 128, 75);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Agua");
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("Zumo de Naranja");
		btnNewButton_4.setBounds(129, 213, 168, 75);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Zumo Naranja");
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Monster Energy");
		btnNewButton_5.setBounds(324, 213, 143, 75);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Monster Energy");
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_5);
	}
	
	public void solicitarCantidad(String producto) {
		JDialog dialog = new JDialog(this, "Cantidad", true);
		dialog.setSize(300, 200);
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
	                    Final Final = new Final();
	    		        Final.setVisible(true);
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
