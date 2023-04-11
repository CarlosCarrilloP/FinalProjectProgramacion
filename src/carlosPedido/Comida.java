package carlosPedido;

import java.time.LocalDate;

public class Comida extends ProductoAbstract {
	
	//Atributos
    private boolean perecedero;
    private float calorias;
    private boolean vegano;
    private LocalDate fecha_envase;
    
    //Constructor
    public Comida(String nombre, double precio, LocalDate fecha_caducidad2, String estado, boolean perecedero,
			float calorias, boolean vegano, LocalDate fecha_envase) {
		super(nombre, precio, fecha_caducidad2, estado);
		this.perecedero = perecedero;
		this.calorias = calorias;
		this.vegano = vegano;
		this.fecha_envase = fecha_envase;
	}


    public boolean isPerecedero() {
        return perecedero;
    }

    public void setPerecedero(boolean perecedero) {
        this.perecedero = perecedero;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public LocalDate getFecha_envase() {
        return fecha_envase;
    }

    public void setFecha_envase(LocalDate fecha_envase) {
        this.fecha_envase = fecha_envase;
    }
    
    
//Metodo para comprobar que si es perecedero, le sume 10 dias
	@Override
	public LocalDate obtener_caducidad() {
		 if (perecedero) {
	        return fecha_envase.plusDays(10);
	    } else {
	        return fecha_envase;
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
