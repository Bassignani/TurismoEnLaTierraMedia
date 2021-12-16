package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;

import utils.Crypt;

public class Usuario {
	
	private Integer id;
	private String nombre = "";
	private double presupuesto;
	private double montoTotal;
	private double tiempoDisponible;
	private Boolean admin;
	private Boolean active;
	private String hashPassword;
	private String path_img;
	private double tiempoTotal;
	private Tipo tipoDeAtraccion;
	private HashMap<String, String> errors;
	LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();

	public Usuario(Integer id, String nombre, double presupuesto, double tiempoDisponible, Tipo tipoDeAtraccion, 
				LinkedList<Vendible> vendiblesComprados, Boolean admin, Boolean active, String hashPassword, String path_img) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.vendiblesComprados = vendiblesComprados;
		this.admin = admin;
		this.active = active;
		this.hashPassword = hashPassword;
		this.path_img = path_img;
	}

	public Integer getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {

		return BigDecimal.valueOf(presupuesto).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public double getTiempoTotal() {
		return tiempoTotal;
	}

//	public Tipo getTipoDeAtraccion() {
//		return tipoDeAtraccion;
//	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", tipoDeAtraccion=" + this.getTipo().getNombre() + ", path="+ path_img +"]\n";
	}

	public boolean puedeComprar(Vendible v) {
		return (v.getCosto() <= this.getPresupuesto() && v.getDuracion() <= this.getTiempoDisponible()
				&& v.hayCupo() == true && yaLoCompro(v) == false);
	}

	public void comprarVendible(Vendible vendible) {
		this.presupuesto -= vendible.getCosto();
		this.montoTotal += vendible.getCosto();
		this.tiempoDisponible -= vendible.getDuracion();
		this.tiempoTotal += vendible.getDuracion();
		vendible.comprar();
		vendiblesComprados.add(vendible);
	}

	
	public boolean yaLoCompro(Vendible v) {
//		for(Vendible comprado : vendiblesComprados) {
//			if(comprado.esOContiene(v) || v.esOContiene(comprado)) {
//				return true;
//			}
//		}
//		return false;
	    boolean compro = false;
        if (v.esPromo()) {
            for (Vendible vendible : v.getAtracciones() ) {
                if (vendiblesComprados.contains(vendible)) {
                    compro = true;
                    break;
                }
                for(Vendible vendibleComp : vendiblesComprados) {
                    if(vendibleComp.esPromo()) {
                        if (vendibleComp.getAtracciones().contains(vendible)) {
                            compro = true;
                            break;
                        }
                    }
                }
            }
        }else {
            for (Vendible vendible : vendiblesComprados) {
                if (vendible.esPromo()) {
                    if (vendible.getAtracciones().contains(v)) {
                        compro = true;
                        break;
                    }
                }else if (vendible.equals(v) ) {
                    compro = true;
                }
            }
        }
        return compro;
	}

	public LinkedList<Vendible> getVendiblesComprados() {
		return vendiblesComprados;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	public boolean checkPassword(String password) {
		return Crypt.match(password, this.hashPassword);
	}
	
	public String Img() {
		return this.path_img;
	}
	
	public boolean esNull() {
		return false;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (presupuesto < 0) {
			errors.put("Presupuesto", "No debe ser negativo");
		}
		if (tiempoDisponible < 0) {
			errors.put("Tiempo", "No debe ser negativo");
		}
	}
	
	public void setPassword(String password) {
		this.hashPassword = Crypt.hash(password);
	}

	public Tipo getTipo() {
		return tipoDeAtraccion;
	}
	
	public String getPassword() {
		return hashPassword;
	}
	
	public String getPathImg() {
		return path_img;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setPath_img(String path_img) {
		this.path_img = path_img;
	}

	public void setTipoDeAtraccion(Tipo tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}


}
