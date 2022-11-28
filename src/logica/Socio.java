package logica;

public class Socio {
	private int tarjeta;
	private String nombre;
	
	public Socio(int tarjeta, String nombre) {
		super();
		this.tarjeta = tarjeta;
		this.nombre = nombre;
	}
	public int getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		String aux;
		if (this.getTarjeta()==0) {
			return nombre;
		} else {
			return nombre+" [Tarjeta: " + tarjeta +"]";
		}
		
	}
	
}
