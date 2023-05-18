package interfazGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Final extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;

	public Final(String resumenPedido) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGracias = new JLabel("¡Gracias! Este es el resumen de su pedido:");
		lblGracias.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGracias.setHorizontalAlignment(SwingConstants.CENTER);
		lblGracias.setBounds(10, 10, 577, 20);
		contentPane.add(lblGracias);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setText(resumenPedido);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 40, 577, 240);
		contentPane.add(scrollPane);

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirTicket(resumenPedido);
				dispose(); // Cierra la ventana actual
			}
		});
		btnImprimir.setBounds(136, 295, 137, 30);
		contentPane.add(btnImprimir);

		JButton btnTerminar = new JButton("Terminar Pedido");
		btnTerminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose(); // Cierra la ventana actual
				
			}
		});
		
		btnTerminar.setBounds(310, 295, 137, 30);
		contentPane.add(btnTerminar);
	}

	public void imprimirTicket(String resumenPedido) {
		// Lógica para imprimir el ticket
		System.out.println("Ticket impreso:");
		System.out.println(resumenPedido);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				String resumenPedido = "Producto 1: 2 unidades\n" + "Producto 2: 1 unidad\n" ;
				Final frame = new Final(resumenPedido);
				frame.setVisible(true);
			
			}
		});
	}
}
