package carlosPedido;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Producto extends ProductoAbstract implements carlosPedido.TratamientoFicheros {
	// Atributos
	String nombre;
	double precio;
	int cantidad;
	int cantidad1 = 0;
	private int stock;
	private int stock1[] = new int[30];

	// Constructor vacío
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor con parámetros
	public Producto(String nombre, double precio, LocalDate fecha_caducidad2, String estado, int cantidad,
			int cantidad1, int stock, int[] stock1) {
		super(nombre, precio, fecha_caducidad2, estado);
		this.nombre = nombre.toUpperCase();
		;

		this.cantidad = cantidad;
		this.precio = precio;
		this.stock = stock;
		this.stock1 = stock1;
	}

	// Getters y setters para los atributos de la clase
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int setCantidad(int cantidad) {
		return this.cantidad = cantidad;
	}

	// Metodos para el stock

	public int getStock() {
		return this.stock;
	}

	// Rellenar stock
	public void rellenarStock() {

		for (int i = 0; i < stock1.length; i++) {

			stock1[i] = 1;

		}

	}

	public int mostrarStock() {
		// Inicializo la variable a 0 de nuevo porque si no, el valor de cantidad1 es
		// erroneo
		cantidad1 = 0;
		for (int i = 0; i < stock1.length; i++) {

			cantidad1++;

		}

		return cantidad1;
	}

	// Metodo realizar pedido
	public void realizarPedido(int cantidad) {
		cantidad1 = cantidad1 - cantidad;
	}

	public ArrayList<Producto> cargarProductos() {

		// Carga de inventario de productos mediante fichero externo
		ArrayList<String[]> productosList = (ArrayList<String[]>) fileScannerProducto(
				"C:/Users/Carlos Carrillo/eclipse-workspace/FinalProjectProgramacion/src/Archivos/Producto.txt");

		String[] nproducto1 = productosList.get(0);
		String nombreproducto1 = nproducto1[0];
		LocalDate fecha_caducidad1 = LocalDate.parse(nproducto1[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String estado1 = nproducto1[2];
		Double precio1 = Double.parseDouble(nproducto1[3]);
		int cantidad1 = Integer.parseInt(nproducto1[4]);

		Producto producto1 = new Producto(nombreproducto1, precio1, fecha_caducidad1, estado1, cantidad, cantidad1,
				stock, stock1);

		String[] nproducto2 = productosList.get(1);
		String nombreproducto2 = nproducto2[0];
		LocalDate fecha_caducidad2 = LocalDate.parse(nproducto2[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String estado2 = nproducto2[2];
		Double precio2 = Double.parseDouble(nproducto2[3]);
		int cantidad2 = Integer.parseInt(nproducto2[4]);

		Producto producto2 = new Producto(nombreproducto2, precio2, fecha_caducidad2, estado2, cantidad, cantidad2,
				stock, stock1);

		String[] nproducto3 = productosList.get(2);
		String nombreproducto3 = nproducto3[0];
		LocalDate fecha_caducidad3 = LocalDate.parse(nproducto3[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String estado3 = nproducto3[2];
		Double precio3 = Double.parseDouble(nproducto3[3]);
		int cantidad3 = Integer.parseInt(nproducto3[4]);

		Producto producto3 = new Producto(nombreproducto3, precio3, fecha_caducidad3, estado3, cantidad, cantidad3,
				stock, stock1);

		String[] nproducto4 = productosList.get(3);
		String nombreproducto4 = nproducto4[0];
		LocalDate fecha_caducidad4 = LocalDate.parse(nproducto4[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String estado4 = nproducto4[2];
		Double precio4 = Double.parseDouble(nproducto4[3]);
		int cantidad4 = Integer.parseInt(nproducto4[4]);

		Producto producto4 = new Producto(nombreproducto4, precio4, fecha_caducidad4, estado4, cantidad, cantidad4,
				stock, stock1);

		String[] nproducto5 = productosList.get(4);
		String nombreproducto5 = nproducto5[0];
		LocalDate fecha_caducidad5 = LocalDate.parse(nproducto5[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String estado5 = nproducto5[2];
		Double precio5 = Double.parseDouble(nproducto5[3]);
		int cantidad5 = Integer.parseInt(nproducto5[4]);

		Producto producto5 = new Producto(nombreproducto5, precio5, fecha_caducidad5, estado5, cantidad, cantidad5,
				stock, stock1);

		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);

		return productos;

	}

	// Metodo fileScanner para Productos
	public static List<String[]> fileScannerProducto(String archivo) {
		String ruta = archivo;
		File f = new File(ruta);
		System.out.println("La ruta del fichero es: " + f.getAbsolutePath());
		Scanner s;
		List<String[]> productosList = new ArrayList<>();
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				Scanner sl = new Scanner(linea);
				sl.useDelimiter("\\s*,\\s*");
				String[] nproducto1 = new String[5];
				nproducto1[0] = sl.next();
				nproducto1[1] = sl.next();
				nproducto1[2] = sl.next();
				nproducto1[3] = sl.next();
				nproducto1[4] = sl.next();

				productosList.add(nproducto1);
			}
			s.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return productosList;
	}

	@Override
	public LocalDate obtener_caducidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void detalle_producto() {
		// TODO Auto-generated method stub

	}

	@Override
	public void comprobarFechaCaducidad() {
		// TODO Auto-generated method stub

	}

}
