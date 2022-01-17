package model;

public class Tipo {
	
	private Integer id;
	private String nombre = "";
	private Boolean active;
	
	public Tipo(Integer id, String tipo, Boolean active) {
		this.id = id;
		this.nombre = tipo;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String tipo) {
		this.nombre = tipo;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public boolean getActive() {
		return active;
	}
	


}
