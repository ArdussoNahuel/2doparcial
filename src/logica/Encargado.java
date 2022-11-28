package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Encargado {

	private int id;
	private String nombre;
	private boolean vendiendo;
	
	
	public Encargado(int id, String nombre, boolean vendiendo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vendiendo = vendiendo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isVendiendo() {
		return vendiendo;
	}
	public void setVendiendo(boolean vendiendo) {
		this.vendiendo = vendiendo;
	}
	@Override
	public String toString() {
		return "Encargado [id=" + id + ", nombre=" + nombre + "]";
	}
	
	public Cafe vender (LinkedList<Cafe> menu) {
		String []aux= new String[menu.size()+1];
		aux[0]="Volver al menu";
		for (int i=0;i<menu.size();i++) {
			aux[i+1]=menu.get(i).toString();
		}
		String opcion = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,"Elija un café" // Mensaje de la ventana
				,"agregar venta" // Titulo de la ventana
				,JOptionPane.QUESTION_MESSAGE // Icono
				,null //null para icono defecto de la ventana
				,aux // el objeto
				,aux[0] // posicion del que va aparecer seleccionado
				);
		for (Cafe cafe : menu) {
			if (cafe.toString().equals(opcion)) {
				return cafe;
			}
		}
		
		return null;
	}
	
	public void agregarVenta (Cafe cafe, LinkedList<Socio> socios, LinkedList<Venta> ventas) {
		if (cafe!=null) {
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad"));
			while (cantidad <1) {
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("La cantidad debe ser 1 o más"));
			}
			String []aux= new String[socios.size()];
			for (int i=0;i<socios.size();i++) {
				aux[i]=socios.get(i).toString();
			}
			String opcion = (String) JOptionPane.showInputDialog(
					null // para que se muestre centrado
					,"Elija un cliente" // Mensaje de la ventana
					,"Agregar venta" // Titulo de la ventana
					,JOptionPane.QUESTION_MESSAGE // Icono
					,null //null para icono defecto de la ventana
					,aux // el objeto
					,aux[0] // posicion del que va aparecer seleccionado
					);
			for (Socio socio : socios) {
				if (socio.toString().equals(opcion)) {
					ventas.add(new Venta(ventas.size(),cafe,cantidad,socio.getTarjeta()));
				}
			}
		}
		
	}
	
	public String mostrarVentas (LinkedList<Venta> ventas) {
		String aux ="";
		for (Venta venta : ventas) {
			aux+=venta.toString();
		}
		return aux;
	}
	
	
	
	
	
}
























