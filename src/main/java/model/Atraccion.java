package model;

import java.util.HashMap;

public class Atraccion extends Vendible {
	private Integer id;
	private String nombre = "";
	private double costo;
	private double duracion;
	private Tipo tipo;
	private int cupo;
	private Boolean active;
	private String path_img;
	private HashMap<String, String> errors;
	
	public Atraccion(Integer id, String nombre, double costo, double duracion, Tipo tipoDeAtraccion, int cupo, Boolean active, String path_img, String description) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.tipo = tipoDeAtraccion;
		this.cupo = cupo;
		this.active = active;
		this.path_img = path_img;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public double getDuracion() {
		return duracion;
	}

	public int getCupo() {
		return cupo;
	}

	@Override
	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public void comprar() {
		if (this.hayCupo()) {
			this.cupo -= 1;
		}
	}

	@Override
	public boolean hayCupo() {

		return (this.getCupo() != 0);
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", duracion=" + duracion + ", tipoDeAtraccion="
				+ tipo.getNombre() + ", cupo=" + cupo + "]\n";
	}
	
	@Override
	public boolean esOContiene(Vendible v) {
		return this.equals(v);
	} 
	
	public boolean getActive() {
		return active;
	}
	
	public String getPathImg() {
		return path_img;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();
		if (costo < 0) {
			errors.put("Costo", "No debe ser negativo");
		}
		if (cupo < 0) {
			errors.put("Cupo", "No debe ser negativo");
		}
		if (duracion < 0) {
			errors.put("Duracion", "No debe ser negativo");
		}
	}
}
