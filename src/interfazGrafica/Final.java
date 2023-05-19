package interfazGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Final extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String nombreProducto1;
    public static int cantidadProducto1;
    public static String nombreProducto2;
    public static int cantidadProducto2;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Final finalFrame = new Final(nombreProducto1, cantidadProducto1,nombreProducto2,cantidadProducto2);
                    finalFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	
	public Final() {
		
	}
	/**
	 * Create the frame.
	 */
	public Final(String nombreProducto1, int cantidadProducto1, String nombreProducto2, int cantidadProducto2) {
		
		this.nombreProducto1 = nombreProducto1;
        this.cantidadProducto1 = cantidadProducto1;
        this.nombreProducto2 = nombreProducto2;
        this.cantidadProducto2 = cantidadProducto2;
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 613, 384);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel = new JLabel("¡Gracias por tu pedido!");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel.setBounds(183, 28, 377, 40);
	        contentPane.add(lblNewLabel);

	        JButton btnNewButton = new JButton("Imprimir ticket");
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        btnNewButton.setBounds(106, 187, 136, 40);
	        contentPane.add(btnNewButton);
	        btnNewButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                imprimirTicket();
	            }
	        });
		
	        JButton btnNewButton_1 = new JButton("Cerrar");
	        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        btnNewButton_1.setBounds(340, 187, 136, 40);
	        contentPane.add(btnNewButton_1);
	        btnNewButton_1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });
	    }
	
	

	private void imprimirTicket() {
        StringBuilder resumenPedido = new StringBuilder();
        resumenPedido.append(this.nombreProducto1).append(" --- ").append(this.cantidadProducto1).append("\n");
        resumenPedido.append(this.nombreProducto2).append(" --- ").append(this.cantidadProducto2).append("\n");
        

        JOptionPane.showMessageDialog(null, resumenPedido.toString(), "Resumen del Pedido", JOptionPane.INFORMATION_MESSAGE);
    }

}
