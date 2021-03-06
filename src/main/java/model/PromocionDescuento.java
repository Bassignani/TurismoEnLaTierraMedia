package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class PromocionDescuento extends Promocion {

	public PromocionDescuento(Integer id,Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones,
			double porcentajeDescuento, Boolean active, String path_img, String description) {
		this.id = id;
		this.tipo = tipo;
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;
		this.porcentajeDescuento = porcentajeDescuento;
		this.active = active;
		this.path_img = path_img;
		this.description = description;
	}

	@Override
	public double calcularDescuento() {
		Double total = 0.00;

		for (Atraccion atraccionActual : this.atracciones) {
			total += atraccionActual.getCosto();

		}

		return BigDecimal.valueOf(((total * (1 - this.getPorcentajeDescuento() / 100))))
				.setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

}

