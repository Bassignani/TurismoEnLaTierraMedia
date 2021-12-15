package services;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;
import model.Tipo;
import model.Vendible;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.TipoDAO;
import persistence.commons.DAOFactory;

public class VendibleService {
	
	public  LinkedList<Vendible> listar() {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			TipoDAO tipoDAO = DAOFactory.getTipoDAO();
			LinkedList<Tipo> tipos = tipoDAO.buscarTodos();
			LinkedList<Atraccion> atracciones = atraccionDAO.buscarTodos(tipos);
			LinkedList<Promocion> promociones = promocionDAO.buscarTodos(atracciones, tipos);
			LinkedList<Vendible> vendibles = new LinkedList<Vendible>();
			
			vendibles.addAll(promociones);
			vendibles.addAll(atracciones);	
			return vendibles;
		}
	}

