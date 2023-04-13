package carlosPedido;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class ProductoAbstract implements Imprimible, TratamientoFicheros {
	// Atributos
	private String nombre;
	protected static double precio;
	protected LocalDate fecha_caducidad;
	private String estado;

	// Constructor

	public ProductoAbstract(String nombre, double precio, LocalDate fecha_caducidad2, String estado) {
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_caducidad = fecha_caducidad2;
		this.setEstado(estado);
	}

	// Constructor vacio
	public ProductoAbstract() {
		super();
	}

	// Aqui compruebo que no está caducado
	public String getEstado(LocalDate fechaActual) {
		if (this.fecha_caducidad == null) {
			return "NO PERECEDERO";
		}
		if (fechaActual.isAfter(this.fecha_caducidad)) {
			return "CADUCADO";
		} else if (fechaActual.plusDays(5).isAfter(this.fecha_caducidad)) {
			return "OFERTA";
		} else {
			return "EN BUEN ESTADO";
		}
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

	// Método para determinar si el producto está próximo a su fecha de caducidad y
	// debe aplicar un descuento
	public boolean estaEnOferta() {
		LocalDate hoy = LocalDate.now();
		LocalDate caducidad = obtener_caducidad();
		long diasHastaCaducidad = hoy.until(caducidad, ChronoUnit.DAYS);
		if (diasHastaCaducidad < 5) {
			return true;
		} else {
			return false;
		}
	}

	// Método para obtener el precio del producto aplicando un posible descuento por
	// oferta

	public double getPrecioOferta() {
		if (estaEnOferta()) {
			return precio * 0.7; // Aplica un descuento del 30%
		} else {
			return precio;
		}
	}

}
