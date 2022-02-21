package models;

public class Arbol {
	private Nodo raiz;

	public Arbol(Nodo raiz) {
		this.raiz = raiz;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void preOrden(Nodo nodo) {
		nodo.preOrden(nodo);
	}

	public void postOrden(Nodo nodo) {
		nodo.postOrden(nodo);
	}

	public Nodo buscaNodo(String busco) {
		return raiz.buscaNodo(busco, raiz);
	}

	public int nivelNodo(String busco) {
		return raiz.nivelNodo(busco, raiz, 0);
	}

	public String path(String valor) {
		return raiz.path(valor, raiz);
	}
	
	public void mostrarArbol() {
		raiz.mostrarArbol(raiz, "");
	}
}
