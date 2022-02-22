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
		return raiz.buscaNodo(busco);
	}

	public int nivelNodo(String busco) {
		return raiz.nivelNodo(busco, 0);
	}

	public String path(String valor) {
		return raiz.path(valor);
	}

	public void mostrarArbol() {
		raiz.mostrarArbol("");
	}
	
	public void podar(Nodo nodo) {
		raiz.podar(nodo);
	}
	
	public void cortarPegar(Nodo origen, Nodo destino) {
		raiz.cortarPegar(origen, destino);
	}
}
