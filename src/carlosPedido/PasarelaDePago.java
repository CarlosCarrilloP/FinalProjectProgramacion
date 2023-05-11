package carlosPedido;

import java.util.Date;
import java.util.Scanner;

import carlosPedidoException.ImporteInvalidoException;
import carlosPedidoException.NumeroCuentaInvalidoException;
import carlosPedidoException.TarjetaInvalidaException;

public class PasarelaDePago {

	// Atributos
	Double importe; // Limitar a dos decimales.
	String codigoPago;

	// Get and Set

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago() {

		this.codigoPago = this.generarCodigoPago();

	}

	// Constructores
	public PasarelaDePago() {

	}

	public PasarelaDePago(Double importe) {

		this.importe = importe;
		this.codigoPago = this.generarCodigoPago();
	}

	// Metodos

	/*
	 * Añado una excepcion para comprobar el importe en efectivo, si es menor a 0 o
	 * +1000 salta error
	 */

	// Efectivo
	public void efectivoPago(double importe) throws ImporteInvalidoException {
		if (importe < 0 || importe > 1000) {
			throw new ImporteInvalidoException("El importe pagado en efectivo es inválido");
		} else {
			this.importe = importe;
			this.codigoPago = generarCodigoPago();

			System.out.println("Ha elegido efectivo.");
			System.out.printf("El total es de %.2f€.%n", importe);
			System.out.println("Necesitas:");

			float[] denominaciones = { 50, 20, 10, 5, 2, 1, (float) 0.50, (float) 0.20, (float) 0.10, (float) 0.05,
					(float) 0.02, (float) 0.01 };
			String[] billetesMonedas = { "Billetes de 50€", "Billetes de 20€", "Billetes de 10€", "Billetes de 5€",
					"Monedas de 2€", "Monedas de 1€", "Monedas de 0.50€", "Monedas de 0.20€", "Monedas de 0.10€",
					"Monedas de 0.05€", "Monedas de 0.02€", "Monedas de 0.01€" };

			for (int i = 0; i < denominaciones.length; i++) {
				int cantidadDenominacionActual = 0;
				while (importe >= denominaciones[i]) {
					importe -= denominaciones[i];
					cantidadDenominacionActual++;
				}
				if (cantidadDenominacionActual > 0) {
					System.out.println(cantidadDenominacionActual + " " + billetesMonedas[i]);
				}
			}
		}
	}


	// Tarjeta
	/*
	 * Este método implementa el pago con tarjeta, validando el número de tarjeta
	 * según el tipo de tarjeta seleccionado (Visa, Mastercard o American Express) y
	 * mostrando el número de tarjeta separado por grupos de 4 dígitos. Si el número
	 * de tarjeta no cumple con las especificaciones de ninguno de los tipos de
	 * tarjeta, se muestra un mensaje indicando que la tarjeta introducida no es
	 * válida. Si se produce una excepción durante la validación del número de
	 * tarjeta, se lanza la excepción TarjetaInvalidaException
	 */
	public void tarjeta(String numeroTarjeta) throws TarjetaInvalidaException {

		this.importe = 0.0;
		this.codigoPago = this.generarCodigoPago();
		System.out.println("Ha elegido tarjeta");

		System.out.println("Escriba el numero de su tarjeta");
		Scanner sc = new Scanner(System.in);
		String tarjeta = sc.nextLine();
		char var = tarjeta.charAt(0);

		switch (var) {
		case '3':
			System.out.println("La tarjeta es American Express");
			if (var == '3') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 16) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 8);
					String distancia3 = cadenaString.substring(8, 12);
					String distancia4 = cadenaString.substring(12, 16);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3
							+ " " + distancia4);

				} else {
					throw new TarjetaInvalidaException("El número de tarjeta no es válido");
				}
			} else {
				throw new TarjetaInvalidaException("El número de tarjeta no es válido");
			}
			break;

		case '4':
			System.out.println("La tarjeta es Visa");
			if (var == '4') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 16) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 8);
					String distancia3 = cadenaString.substring(8, 12);
					String distancia4 = cadenaString.substring(12, 16);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3
							+ " " + distancia4);
				} else {
					throw new TarjetaInvalidaException("El número de tarjeta no es válido");
				}
			} else {
				throw new TarjetaInvalidaException("El número de tarjeta no es válido");
			}
			break;
		case '5': // Para American Express debe aceptar 15 dígitos y estar separados por 4, 6 y 5
					// dígitos.
			System.out.println("La tarjeta es Mastercard");
			if (var == '5') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 15) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 10);
					String distancia3 = cadenaString.substring(10, 15);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3);

				} else {
					throw new TarjetaInvalidaException("El número de tarjeta ingresado no es válido");
				}
			} else {
				throw new TarjetaInvalidaException("El número de tarjeta ingresado no es válido");
			}
			break;
		default:
			throw new TarjetaInvalidaException("La tarjeta introducida no es valida");

		}

	}

	// Cuenta
	public void cuenta(String numeroCuenta) throws NumeroCuentaInvalidoException {

		this.importe = 0.0;
		this.codigoPago = this.generarCodigoPago();

		// Validar el número de cuenta
		if (numeroCuenta.length() != 10) {
			throw new NumeroCuentaInvalidoException("El número de cuenta debe tener 10 dígitos.");
		}
		try {
			Long.parseLong(numeroCuenta);
		} catch (NumberFormatException e) {
			throw new NumeroCuentaInvalidoException("El número de cuenta debe ser un valor numérico.");
		}
	}

	public String generarCodigoPago() {
		return String.valueOf(new Date().getTime());

	}

}
