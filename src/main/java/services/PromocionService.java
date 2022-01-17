package services;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionDescuento;
import model.Tipo;
import persistence.commons.DAOFactory;

public class PromocionService {
	
	
	public LinkedList<Promocion> listar(LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos) {
		return DAOFactory.getPromocionDAO().buscarTodos(atracciones, tipos);
	}
	
	
	public Promocion crearAxB(Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones,
			 String path_img, String description, LinkedList<Tipo> tipos, LinkedList<Atraccion> atraccionesLisadas) {
		Promocion promocion = new PromocionAxB(1, tipo, tipoPromocion, nombrePack, atracciones, true, path_img, description);
		if (promocion.isValid()) {
			DAOFactory.getPromocionDAO().insert(promocion, tipos, atracciones);
		}
		return promocion;
	}
	
	public Promocion crearDescuento(Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones,
			double porcentajeDescuento, String path_img, String description, LinkedList<Tipo> tipos, LinkedList<Atraccion> atraccionesLisadas) {
		Promocion promocion = new PromocionDescuento(1, tipo, tipoPromocion, nombrePack, atracciones, porcentajeDescuento, true, path_img, description);
		if (promocion.isValid()) {
			DAOFactory.getPromocionDAO().insert(promocion, tipos, atracciones);
		}
		return promocion;
	}
	
	public Promocion crearAbsoluta(Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones,
			double precio, String path_img, String description, LinkedList<Tipo> tipos, LinkedList<Atraccion> atraccionesLisadas) {
		Promocion promocion = new PromocionAbsoluta(1, tipo, tipoPromocion, nombrePack, atracciones, precio, true, path_img, description);
		if (promocion.isValid()) {
			DAOFactory.getPromocionDAO().insert(promocion, tipos, atracciones);
		}
		return promocion;
		
	}
	
	public int deactivate(Integer id, LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos) {
		Promocion promocion = DAOFactory.getPromocionDAO().buscarPorId(id, atracciones, tipos);
		return DAOFactory.getPromocionDAO().deactivate(promocion);
	}
	
	
	public int activate(Integer id, LinkedList<Atraccion> atracciones, LinkedList<Tipo> tipos) {
		Promocion promocion = DAOFactory.getPromocionDAO().buscarPorId(id, atracciones, tipos);
		return DAOFactory.getPromocionDAO().activate(promocion);
	}
	
	
	
}
