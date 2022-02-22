package models;

import java.util.ArrayList;

public class Nodo {
	private String valor;
	private ArrayList<Nodo> hijos;

	public Nodo(String valor) {
		this.valor = valor;
		this.hijos = new ArrayList<>();
	}

	public ArrayList<Nodo> getHijos() {
		return hijos;
	}

	public String getValor() {
		return valor;
	}

	public void addHijo(Nodo hijo) {
		hijos.add(hijo);
	}

	public Nodo preOrden(Nodo nodo) {
		System.out.println(nodo.toString());
		for (Nodo hijo : hijos)
			hijo.preOrden(hijo);
		return nodo;
	}

	public Nodo postOrden(Nodo nodo) {
		for (Nodo hijo : hijos)
			hijo.postOrden(hijo);
		System.out.println(nodo.toString());
		return nodo;
	}

	public Nodo buscaNodo(String busco) {
		if (this.valor.equals(busco))
			return this;
		else
			for (Nodo hijo : this.hijos)
				if (hijo.buscaNodo(busco) != null)
					return hijo.buscaNodo(busco);
		return null;
	}

	public int nivelNodo(String busco, int n) {
		if (busco.equals(this.valor))
			return n;
		else
			for (Nodo hijo : this.hijos)
				if (hijo.nivelNodo(busco, ++n) != --n)
					return hijo.nivelNodo(busco, ++n);
		return --n;
	}

	public String path(String valor) {
		if (this.valor.equals(valor))
			return this.valor + "/";
		else
			for (Nodo hijo : this.hijos)
				if (hijo.path(valor) != null)
					return this.valor + "/" + hijo.path(valor);
		return null;
	}

	public void mostrarArbol(String padre) {
		System.out.println(padre + this.valor + "/");
		if (this.hijos.size() != 0)
			for (Nodo hijo : this.hijos) {
				padre += this.valor + "/";
				hijo.mostrarArbol(padre);
				padre = "";
			}
	}

	public void podar(Nodo nodo) {
		if (this.buscaNodo(nodo.valor) != null)
			this.buscaNodo(nodo.valor).hijos.clear();
	}

	public void cortarPegar(Nodo origen, Nodo destino) {
		if (this.buscaNodo(origen.valor) != null)
			if (this.buscaNodo(destino.valor) != null) {
				String[] rutaOrigen = this.path(origen.valor).split("/");
				this.buscaNodo(destino.valor).hijos.add(this.buscaNodo(origen.valor));
				this.buscaNodo(rutaOrigen[rutaOrigen.length - 2]).hijos.remove(origen);
			}
	}

	@Override
	public String toString() {
		return "valor = " + valor;
	}
}
