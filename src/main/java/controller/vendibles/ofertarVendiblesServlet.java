package controller.vendibles;

import java.io.IOException;
import java.util.LinkedList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comparador;
import model.Tipo;
import model.Usuario;
import model.Vendible;
import services.TipoService;
import services.UsuarioService;
import services.VendibleService;

@WebServlet("/vendibles/ofertar.do")
public class ofertarVendiblesServlet extends HttpServlet {

	private static final long serialVersionUID = -7625449297870416229L;
	private TipoService tipoService;
	private UsuarioService usuarioService;
	private VendibleService vendibleService;
	LinkedList<Vendible> vendibles;
	LinkedList<Vendible> vendiblesAOfertar = new LinkedList<Vendible>();
	LinkedList<Tipo> tipos;
	Integer id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
		this.usuarioService = new UsuarioService();
		this.vendibleService = new VendibleService();
		vendibles = vendibleService.listar();
		tipos = tipoService.listar();
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		id = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = usuarioService.busacarPorId(id, vendibles, tipos);
		LinkedList<Vendible> vendibles = vendibleService.listar();
		vendibles.sort(new Comparador(usuario.getTipo()) );		
		for (Vendible v : vendibles) {	   
			if (usuario.puedeComprar(v) ) { //&& yaLoOferto(v)==false
				vendiblesAOfertar.add(v);  
			}	
		}

		req.setAttribute("vendibles", vendiblesAOfertar);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/ofertar.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
//	private boolean yaLoOferto(Vendible v) {
//	boolean oferto = false;
//    if (v.esPromo()) {
//        for (Vendible vendible : v.getAtracciones() ) {
//            if (vendiblesAOfertar.contains(vendible)) {
//            	oferto = true;
//                break;
//            }
//            for(Vendible vendibleComp : vendiblesAOfertar) {
//                if(vendibleComp.esPromo()) {
//                    if (vendibleComp.getAtracciones().contains(vendible)) {
//                    	oferto = true;
//                        break;
//                    }
//                }
//            }
//        }
//    }else {
//        for (Vendible vendible : vendiblesAOfertar) {
//            if (vendible.esPromo()) {
//                if (vendible.getAtracciones().contains(v)) {
//                	oferto = true;
//                    break;
//                }
//            }else if (vendible == v ) {
//            	oferto = true;
//            }
//        }
//    } 
//    return oferto;
//	}
	

	

}
