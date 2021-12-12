package services;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import model.Vendible;

public class VendibleService {
	
	public LinkedList<Vendible> listar(LinkedList<Atraccion> atracciones, LinkedList<Promocion> promociones) {
		LinkedList<Vendible> vendibles = new LinkedList<Vendible>();
		vendibles.addAll(atracciones);
		vendibles.addAll(promociones);
		return vendibles;
	}
}
