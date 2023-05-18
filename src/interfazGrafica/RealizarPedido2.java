package interfazGrafica;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

		JButton btnNewButton = new JButton("Producto 1");
		btnNewButton.setBounds(113, 117, 114, 75);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Producto 1");
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

		JButton btnNewButton_1 = new JButton("Producto 2");
		btnNewButton_1.setBounds(253, 117, 114, 75);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Producto 2");
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Producto 3");
		btnNewButton_2.setBounds(397, 117, 114, 75);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Producto 3");
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("Producto 4");
		btnNewButton_4.setBounds(183, 213, 114, 75);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Producto 4");
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Producto 5");
		btnNewButton_5.setBounds(324, 213, 114, 75);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad("Producto 5");
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
				 
				dialog.dispose(); // Cerrar la ventana secundaria
				 // Crear y mostrar el JFrame "Final"
			    JFrame finalFrame = new JFrame("Final");
			    finalFrame.setVisible(true);
			    
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
