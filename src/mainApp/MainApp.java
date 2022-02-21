package mainApp;

import models.Arbol;
import models.Nodo;

public class MainApp {
	public static void main(String[] args) {
		Nodo n1 = new Nodo("uno"), raiz = new Nodo("origen"), n2 = new Nodo("dos"), n3 = new Nodo("tres"), n4 = new Nodo("cuatro");
		raiz.addHijo(n1);
		raiz.addHijo(n2);
		n1.addHijo(n3);
		n2.addHijo(n4);
		n4.addHijo(new Nodo("Fijo"));
		Arbol ar = new Arbol(raiz);
		ar.preOrden(ar.getRaiz());
		System.out.println();
		ar.postOrden(ar.getRaiz());
		System.out.println();
		System.out.println(ar.buscaNodo("e"));
		System.out.println(ar.nivelNodo("tres"));
		
		System.out.println(ar.path("Fijo")+"\n");
		ar.mostrarArbol();
	}
}
