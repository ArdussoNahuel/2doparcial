package logica;

public class Venta {

	private int id;
	private Cafe cafe;
	private int cantidad;
	private int tarjetasocio;
	
	public Venta(int id, Cafe cafe, int cantidad, int tarjetasocio) {
		super();
		this.id = id;
		this.cafe = cafe;
		this.cantidad = cantidad;
		this.tarjetasocio = tarjetasocio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTarjetasocio() {
		return tarjetasocio;
	}

	public void setTarjetasocio(int tarjetasocio) {
		this.tarjetasocio = tarjetasocio;
	}

	@Override
	public String toString() {
		double mult=1;
		if (this.tarjetasocio!=0) {
			mult=0.85;
		}
		return "Venta nro: " + id + " \nResumen: " +cantidad+ " "+ cafe.getNombre() + " - $" + cantidad*cafe.getPrecio()*mult + " \nSocio: " + tarjetasocio+"\n";
	}
	
}
