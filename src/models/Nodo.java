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

	public Nodo buscaNodo(String busco, Nodo nodo) {
		if (nodo.valor.equals(busco))
			return nodo;
		else
			for (Nodo hijo : nodo.hijos)
				if (buscaNodo(busco, hijo) != null)
					return buscaNodo(busco, hijo);
		return null;
	}

	public int nivelNodo(String busco, Nodo nodo, int n) {
		if (busco.equals(nodo.valor))
			return n;
		else
			for (Nodo hijo : nodo.hijos)
				if (nivelNodo(busco, hijo, ++n) != --n)
					return nivelNodo(busco, hijo, ++n);
		return --n;
	}

	public String path(String valor, Nodo nodo) {
		if (nodo.valor.equals(valor))
			return nodo.valor + "/";
		else
			for (Nodo hijo : nodo.hijos)
				if (path(valor, hijo) != null)
					return nodo.valor + "/" + path(valor, hijo);
		return null;
	}

	public void mostrarArbol(Nodo nodo, String padre) {
		System.out.println(padre + nodo.valor + "/");
		if (nodo.hijos.size() != 0)
			for (Nodo hijo : nodo.hijos) {
				padre += nodo.valor + "/";
				mostrarArbol(hijo, padre);
			}
	}

	@Override
	public String toString() {
		return "valor = " + valor;
	}
}
