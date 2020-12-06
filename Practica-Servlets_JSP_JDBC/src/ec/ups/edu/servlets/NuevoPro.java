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
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class NuevoPro
 */
@WebServlet("/NuevoPro")
public class NuevoPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Producto prod = null;
		Usuario us = null;
		
		int usu =  Integer.parseInt(request.getParameter("idUsuario"));
		

		
		String nombre = request.getParameter("nomPro");
		double precio = Double.parseDouble(request.getParameter("precioPro"));
		int iva = Integer.parseInt(request.getParameter("iva"));
		String estPro = request.getParameter("estPro");
		String url = request.getParameter("urlPro");
		String desc = request.getParameter("descriPro");
		
		Producto p = new Producto(1,nombre, precio, iva, url,desc,estPro);
		
		us = DAOFactory.getFactory().getUsuario_DAO().read(usu);
		
	
		DAOFactory.getFactory().getProducto_DAO().create(p);
		out.println("<h3>Se ha creado un nuevo producto </h3>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
