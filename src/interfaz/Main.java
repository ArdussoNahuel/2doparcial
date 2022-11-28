package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Cafe> menu = cargarmenu(new LinkedList<Cafe>());
		LinkedList<Socio> socios = cargarsocios(new LinkedList<Socio>());
		LinkedList<Venta> ventas = new LinkedList<Venta>();
		Encargado encargado = new Encargado(0,"Elver Galarga",true);
		
		menu(encargado,menu,socios,ventas);
		JOptionPane.showMessageDialog(null, "Gracias por visitar Cafelito");
	}
	
	
	public static void menu (Encargado encargado,LinkedList<Cafe> menu, LinkedList<Socio> socios, LinkedList<Venta> ventas) {
		String []opciones = {"Agregar venta","Finalizar dia","Disponible cuando finalice el dia","Disponible cuando finalice el dia","Disponible cuando finalice el dia","Disponible cuando finalice el dia"};
		if (!encargado.isVendiendo()) {
			opciones[0]="Salir del programa";
			opciones[1]="Eliminar venta";
			opciones[2]="Mostrar todas las ventas";
			opciones[3]="Mostrar cafe mas vendido";
			opciones[4]="Mostrar recaudacion total";
			opciones[5]="Mostrar ventas con descuento";
		}
		
		String opcion = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,"Elija una opcion" // Mensaje de la ventana
				,"Menu de Cafeteria" // Titulo de la ventana
				,JOptionPane.QUESTION_MESSAGE // Icono
				,null //null para icono defecto de la ventana
				,opciones // el objeto
				,opciones[0] // posicion del que va aparecer seleccionado
				);
		if (opcion==null) {
			
		} else {
			switch (opcion) {
			case "Agregar venta":
				encargado.agregarVenta(encargado.vender(menu), socios, ventas); 
				menu(encargado,menu,socios,ventas);
				break;
			case "Eliminar venta":
				encargado.eliminar(ventas);
				menu(encargado,menu,socios,ventas);
				break;
			case "Disponible cuando finalice el dia":
				JOptionPane.showMessageDialog(null, "Se debe terminar el dia para acceder a esta opcion");
				menu(encargado,menu,socios,ventas);
				break;
			case "Finalizar dia":
				if (ventas.size()>4) {
					encargado.setVendiendo(false);
				} else {
					JOptionPane.showMessageDialog(null, "Debes realizar al menos 5 ventas, no seas vago man");
				}
				menu(encargado,menu,socios,ventas);
				break;
			case "Mostrar todas las ventas":
				//dividor por no se 6 o 5 y crear un array con ese valor de indice max y mostrar de a paginas
				JOptionPane.showMessageDialog(null, encargado.mostrarVentas(ventas));
				menu(encargado,menu,socios,ventas);
				break;
			case "Mostrar cafe mas vendido":
				JOptionPane.showMessageDialog(null, "El Cafe mas vendido hoy fue "+encargado.masVendido(ventas, menu));
				menu(encargado,menu,socios,ventas);
				break;
			case "Mostrar recaudacion total":
				JOptionPane.showMessageDialog(null, "El total recaudado hoy fue $"+encargado.total(ventas));
				menu(encargado,menu,socios,ventas);
				break;
			case "Mostrar ventas con descuento":
				JOptionPane.showMessageDialog(null, encargado.descuento(ventas));
				menu(encargado,menu,socios,ventas);
				break;
			default:
				break;
			}
		}
	}
	
	public static LinkedList<Socio> cargarsocios (LinkedList<Socio> socios){
		String []nombre = {"Sofia","Jorge","Carlos","Federico","Daniel","Maria","Pilar","Martin","Franco","Agustina","Irina","Ezequiel","Camila","Sabrina","Julian","Marcos","Micaela","Gaston","Esteban","Agustin","Lucas","Lorena","Noelia"};
		String []apellido = {"Gonzalez","Fernandez","Rodriguez","Santos","Martinez","Perez","Llanos","Rojas","Gutierrez","Ochoa","Dominguez","Bianchini","Velez","Mendez","Peña","Jimenez","Viñeda","Hernandez","Araujo","Fidalgo","Gomez"};
		socios.add(new Socio(0,"Cliente nuevo/sin tarjeta"));
		for (int i=0; i<20;i++) {
			socios.add(new Socio((int)(Math.random()*899999+100000),nombre[(int) (Math.random()*nombre.length)]+" "+apellido[(int) (Math.random()*apellido.length)]));
		}
		return socios;
	}
	public static LinkedList<Cafe> cargarmenu (LinkedList<Cafe> menu){
		menu.add(new Cafe(1,"Latte",1.5));
		menu.add(new Cafe(2,"Flat White",2.5));
		menu.add(new Cafe(3,"Lagrima",1.3));
		menu.add(new Cafe(4,"Expresso",1));
		return menu;
	}

}
