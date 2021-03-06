package ec.ups.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.modelo.Empresa;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class EnvioDatos
 */
@WebServlet("/EnvioDatos")
public class EnvioDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvioDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		int idEmpresa = Integer.parseInt(request.getParameter("idEmp"));
		String pagina = request.getParameter("pagina");
		
		System.out.println("Este es el idUsu: "+idUsuario+" esta es la empresa: "+idEmpresa);
		Usuario usuario = DAOFactory.getFactory().getUsuario_DAO().read(idUsuario);
		Empresa empresa = DAOFactory.getFactory().getEmpresa_DAO().read(idEmpresa);
		System.out.println("Esto es el objeto usuario: "+usuario.getNombre()+" esta es la empresa "+empresa.getNombre());
		
		
		String url = "/private/user/jsp/"+pagina;
		System.out.println("Pagina: "+url);
		
		request.setAttribute("usuario", usuario);
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
