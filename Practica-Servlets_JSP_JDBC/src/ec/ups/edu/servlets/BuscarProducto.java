package ec.ups.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.modelo.Empresa;
import ec.ups.edu.modelo.Producto;

/**
 * Servlet implementation class BuscarProducto
 */
@WebServlet("/BuscarProducto")
public class BuscarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String nomPro = request.getParameter("nomPro");
		int idEmpresa = Integer.parseInt(request.getParameter("idEmp"));
		Empresa empresa = DAOFactory.getFactory().getEmpresa_DAO().read(idEmpresa);
		
		System.out.println("Este es el nombre: "+nomPro+" esta es la empresa: "+idEmpresa);
		System.out.println("Esta es la empresa "+empresa.getNombre());
		
		
		ArrayList<Producto> pro = DAOFactory.getFactory().getEmpresa_DAO().productosEmpresa(nomPro, idEmpresa);
		
		String url = "/private/user/jsp/mostrarProductos.jsp";
		request.setAttribute("productos", pro);
		request.setAttribute("empresaBusca", empresa);
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("Busqueda de producto pasado");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
