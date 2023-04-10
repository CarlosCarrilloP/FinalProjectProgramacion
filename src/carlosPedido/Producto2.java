package carlosPedido;

import java.time.LocalDate;

public abstract class Producto2 implements Imprimible , TratamientoFicheros {
	// Atributos
	private String nombre;
	protected static double precio;
	protected LocalDate fecha_caducidad;
	private String estado;

	// Constructor

	public Producto2(String nombre, double precio, LocalDate fecha_caducidad2, String estado) {
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_caducidad = fecha_caducidad2;
		this.setEstado(estado);
	}

	public Producto2() {
		super();
	}

	// Get and set de estado
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Metodo abstracto obtener_caducidad

	public abstract LocalDate obtener_caducidad();

	// Metodo abstracto detalles del producto
	public abstract void detalle_producto();

	// Metodo abstracto para comprobar la fecha de caducidad
	public abstract void comprobarFechaCaducidad();

	// Metodo imprimir ticket
	public void imprimir() {

	}

}
