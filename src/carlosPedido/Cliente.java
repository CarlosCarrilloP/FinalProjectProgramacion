package carlosPedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente implements TratamientoFicheros {

	// Atributos

	String nombre;
	String apellidos;
	Date fechaDeAlta;
	String telefono;
	String direccion;
	String historial;

	// Get and Set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		if (fechaDeAlta == null) {
			this.fechaDeAlta = new Date();

		} else {
			this.fechaDeAlta = fechaDeAlta;

		}

	}

	public String getTelefono() {
		return telefono;
	}

	// Metodo setTelefono limita a 9 la longitud del telefono y que empiece por
	// 6,7,8 o 9
	public void setTelefono(String telefono) {
	    try {
	        if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")
	                || telefono.startsWith("9"))) {
	            this.telefono = telefono;
	        } else {
	            throw new Exception("El número de teléfono es inválido");
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	// Constructor vacio

	public Cliente() {
		
	}

	// Constructor
	public Cliente(String nombre, String apellidos, Date fechaDeAlta, String telefono, String direccion,
			String historial) {
		
		this.nombre = nombre.toLowerCase();
		this.apellidos = apellidos.toUpperCase();
		this.fechaDeAlta = fechaDeAlta;

		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")
				|| telefono.startsWith("9"))) {

			this.telefono = telefono;
		} else {
			//System.out.println("FORMATO DE TELEFONO INCORRECTO");
		}

		this.direccion = direccion;
		this.historial = historial;
	}

	
	 /* Metodo: Este metodo es el metodo agregarPedido y realizarPedido, ya que en la
	 * practica, los nombra diferentes, y pide lo mismo.
	 */

	public void realizarPedido(Pedido pedido) {

		this.historial = this.historial + pedido.getCodigoPedido();

	}
	
	public static List<Cliente> leerClientesDesdeArchivo(String rutaArchivo) {
	    List<Cliente> clientes = new ArrayList<>();

	    try {
	        TratamientoFicheros tratamientoFicheros = new Cliente();
	        List<String[]> datosClientes = TratamientoFicheros.fileScannerCliente(rutaArchivo);

	        for (String[] datos : datosClientes) {
	            String nombre = datos[0];
	            String apellido = datos[1];
	            String telefono = datos[2];
	            String direccion = datos[3];
	            Cliente cliente = new Cliente(nombre, apellido, null, telefono, direccion, null);
	            clientes.add(cliente);
	        }
	    } catch (Exception e) {
	        System.out.println("Error al leer el archivo de clientes: " + e.getMessage());
	    }

	    return clientes;
	}




	

}
