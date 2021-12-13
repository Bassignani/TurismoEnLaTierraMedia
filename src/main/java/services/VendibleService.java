package services;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import model.Vendible;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class VendibleService {
	
	public  LinkedList<Vendible> listar() {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			LinkedList<Atraccion> atracciones = atraccionDAO.buscarTodos();
			LinkedList<Promocion> promociones = promocionDAO.buscarTodos(atracciones);
			LinkedList<Vendible> vendibles = new LinkedList<Vendible>();
			
			vendibles.addAll(promociones);
			vendibles.addAll(atracciones);	
			return vendibles;
		}
	}

