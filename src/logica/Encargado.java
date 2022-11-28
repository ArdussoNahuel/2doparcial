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
					ventas.add(new Venta(ventas.size()+1,cafe,cantidad,socio.getTarjeta()));
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
	
	public String masVendido (LinkedList<Venta> ventas, LinkedList<Cafe> menu) {
		int []masvendido= {0,0,0,0};
		for (Venta venta : ventas) {
				masvendido[venta.getCafe().getId()-1]+=venta.getCantidad();
		}
		int max=0;
		for (int i=0;i<masvendido.length;i++) {
			if (masvendido[i]>masvendido[max]) {
				max=i;
			}
		}
		return menu.get(max).getNombre()+" con "+masvendido[max];
	}
	
	public double total (LinkedList<Venta> ventas) {
		double total=0;
		for (Venta venta : ventas) {
			if (venta.getTarjetasocio()==0) {
				total+=venta.getCantidad()*venta.getCafe().getPrecio();
			} else {
				total+=venta.getCantidad()*venta.getCafe().getPrecio()*0.85;
			}
		}
		return total;
	}
	
	public String descuento (LinkedList<Venta> ventas) {
		String aux ="";
		for (Venta venta : ventas) {
			if (venta.getTarjetasocio()!=0) {
				aux+=venta.toString();
			}
		}
		return aux;
	}
	
	public void eliminar (LinkedList<Venta> ventas) {
		int borrar=-1;
		String []opciones = new String[ventas.size()+1];
		for (int i=0;i<ventas.size();i++) {
			opciones[i+1]=ventas.get(i).toString();
		}
		opciones[0]="Volver al menu";
		String opcion = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,"Elija una venta para eliminarla" // Mensaje de la ventana
				,"Eliminar venta" // Titulo de la ventana
				,JOptionPane.QUESTION_MESSAGE // Icono
				,null //null para icono defecto de la ventana
				,opciones // el objeto
				,opciones[0] // posicion del que va aparecer seleccionado
				);
		for (Venta venta : ventas) {
			if (venta.toString().equals(opcion)) {
				borrar=venta.getId()-1;
			}
		}
		if (borrar>=0) {
			ventas.remove(borrar);
		}
	}
	
}
























