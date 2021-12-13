package model;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(Integer id, Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones,
			double precio, Boolean active, String path_img, String description) {
		this.id = id;
		this.tipo = tipo;
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;
		this.precio = precio;
		this.active = active;
		this.path_img = path_img;
		this.description = description;
	}

	@Override
	public double calcularDescuento() {

		return this.getPrecio();

	}

}
