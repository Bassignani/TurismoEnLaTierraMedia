package model;

import java.util.Comparator;

public class Comparador implements Comparator<Vendible> {
	private Tipo preferenciaUsuario;

	public Comparador(Tipo preferenciaUsuario) {
		this.preferenciaUsuario = preferenciaUsuario;
	}

	@Override
	public int compare(Vendible o1, Vendible o2) {

		if (this.preferenciaUsuario.getNombre().equals(o1.getTipo().getNombre())  && !this.preferenciaUsuario.getNombre().equals(o2.getTipo().getNombre()) ) {
			return -1;
		}
		if (!this.preferenciaUsuario.getNombre().equals(o1.getTipo().getNombre()) && this.preferenciaUsuario.getNombre().equals(o2.getTipo().getNombre()) ) {
			return 1;
		}
		if (o1.esPromo() && !o2.esPromo()) {
			return -1;
		}
		if (!o1.esPromo() && o2.esPromo()) {
			return 1;
		}
		if (o1.getCosto() > o2.getCosto()) {
			return -1;
		}
		if (o1.getCosto() < o2.getCosto()) {
			return 1;
		}
		if (o1.getDuracion() > o2.getDuracion()) {
			return -1;
		}
		if (o1.getDuracion() < o2.getDuracion()) {
			return 1;
		}
		return 0;

	}
}
