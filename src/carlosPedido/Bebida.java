package carlosPedido;

import java.time.LocalDate;

public class Bebida extends ProductoAbstract {
	
	
	//Atributos
    private boolean gaseoso;
    private boolean lacteo;
    private int medida;

   
    //Constructor
    public Bebida(String nombre, double precio, LocalDate fecha_caducidad2, String estado, boolean gaseoso,
			boolean lacteo, int medida) {
		super(nombre, precio, fecha_caducidad2, estado);
		this.gaseoso = gaseoso;
		this.lacteo = lacteo;
		this.medida = medida;
	}
    
    
	public boolean isGaseoso() {
        return gaseoso;
    }

    public void setGaseoso(boolean gaseoso) {
        this.gaseoso = gaseoso;
    }

    public boolean isLacteo() {
        return lacteo;
    }

    public void setLacteo(boolean lacteo) {
        this.lacteo = lacteo;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

	@Override
	public LocalDate obtener_caducidad() {
		
		    if (this.lacteo) {
		        return this.fecha_caducidad.plusDays(10);
		    } else {
		        return this.fecha_caducidad.plusDays(20);
		    }
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

