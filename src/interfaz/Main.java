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
		
		for (Venta socio : ventas) {
			System.out.println(socio);
		}
	}
	
	
	public static void menu (Encargado encargado,LinkedList<Cafe> menu, LinkedList<Socio> socios, LinkedList<Venta> ventas) {
		String []opciones = {"Agregar venta","Finalizar día","Disponible cuando finalice el día","Disponible cuando finalice el día","Disponible cuando finalice el día","Disponible cuando finalice el día"};
		if (!encargado.isVendiendo()) {
			opciones[0]="Salir del programa";
			opciones[1]="Iniciar nuevo día";
			opciones[2]="Mostrar todas las ventas";
			opciones[3]="Mostrar cafe más vendido";
			opciones[4]="Mostrar recaudación total";
			opciones[5]="Mostrar ventas con descuento";
		}
		
		String opcion = (String) JOptionPane.showInputDialog(
				null // para que se muestre centrado
				,"Elija una opcion" // Mensaje de la ventana
				,"Menu de Cafetería" // Titulo de la ventana
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

			default:
				break;
			}
		}
	}
	
	public static LinkedList<Socio> cargarsocios (LinkedList<Socio> socios){
		String []nombre = {"Sofia","Jorge","Carlos","Federico","Daniel","Maria","Pilar","Martin","Franco","Agustina","Irina","Ezequiel","Camila","Sabrina"};
		String []apellido = {"Gonzalez","Fernandez","Rodriguez","Martinez","Perez","Llanos","Rojas","Gutierrez","Dominguez","Bianchini","Velez","Mendez"};
		socios.add(new Socio(0,"Cliente nuevo/sin tarjeta"));
		for (int i=0; i<20;i++) {
			socios.add(new Socio((int)(Math.random()*999999+100000),nombre[(int) (Math.random()*nombre.length)]+" "+apellido[(int) (Math.random()*apellido.length)]));
		}
		return socios;
	}
	public static LinkedList<Cafe> cargarmenu (LinkedList<Cafe> menu){
		menu.add(new Cafe(1,"Latte",1.5));
		menu.add(new Cafe(2,"Flat White",2.5));
		menu.add(new Cafe(3,"Lágrima",1.3));
		menu.add(new Cafe(4,"Expresso",1));
		return menu;
	}

}
