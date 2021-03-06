package ec.ups.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.modelo.Administrador;
import ec.ups.edu.modelo.Empresa;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class EnvioDatos2
 */
@WebServlet("/EnvioDatos2")
public class EnvioDatos2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvioDatos2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int idAdmin = Integer.parseInt(request.getParameter("idAdmin"));
		int idEmpresa = Integer.parseInt(request.getParameter("idEmp"));
		String pagina = request.getParameter("pagina");
		
		//ArrayList<Producto> producto = DAOFactory.getFactory().getEmpresa_DAO().productosEmpresa(nombrePro, idEmpresa);
		Administrador adm = DAOFactory.getFactory().getUAdministrador_DAO().read(idAdmin);
		Empresa empresa = DAOFactory.getFactory().getEmpresa_DAO().read(idEmpresa);
		//System.out.println("Producto en Servlet: "+producto.size());
		
		String url = "/private/admin/jsp/"+pagina;
		System.out.println("Pagina: "+url);
		
		request.setAttribute("admin", adm);
		request.setAttribute("empresa", empresa);
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
