package ec.ups.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.modelo.Pedido;
import ec.ups.edu.modelo.Producto;

/**
 * Servlet implementation class modPro
 */
@WebServlet("/modPro")
public class modPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Producto producto=null;
		
		
		int codPro =  Integer.parseInt(request.getParameter("codPro"));
		String nomPro = request.getParameter("nomPro");
		double precioPro =  Double.parseDouble(request.getParameter("precioPro"));
		int iva =  Integer.parseInt(request.getParameter("iva"));
		String estPro =  request.getParameter("estPro");
		String urlPro = request.getParameter("urlPro");
		String descriPro =  request.getParameter("descriPro");
		
		producto = DAOFactory.getFactory().getProducto_DAO().read(codPro);
		producto.setNombre(nomPro);
		producto.setPrecio(precioPro);
		producto.setEstado(estPro);
		producto.setUrl_imagen(urlPro);
		producto.setDescripcion(descriPro);
		
		DAOFactory.getFactory().getProducto_DAO().update(producto);
		out.println("<h3>Se modifico el pedido, click en buscar para ver el cambio</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
