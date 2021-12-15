package model;

public class Tipo {
	
	private Integer id;
	private String nombre = "";
	
	public Tipo(Integer id, String tipo) {
		this.id = id;
		this.nombre = tipo;
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
	

}
