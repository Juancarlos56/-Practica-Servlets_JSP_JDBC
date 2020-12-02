package ec.ups.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.ups.edu.dao.Administrador_DAO;
import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.Empresa_DAO;
import ec.ups.edu.dao.Usuario_DAO;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class InicioSesion
 */

@WebServlet("/iniciar")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String url = null;
				HttpSession session = request.getSession(true);
			
				String us =   request.getParameter("correo");
				String pw =   request.getParameter("contrasena");
				
				Usuario_DAO usarioLogin = DAOFactory.getFactory().getUsuario_DAO();
				
				Usuario usuario = usarioLogin.control_logeo(pw, us);
				
				if (usuario == null) {
					response.sendRedirect("index.html");
				}else {
					
					String rol = usuario.getRol();
				

					switch (rol) {
					case "usuario":
						
						request.setAttribute("usuario", usuario);
						request.getRequestDispatcher("sesionUsuario.jsp").forward(request, response);
						break;
					
					case "admin":
						request.setAttribute("admin", usuario);
						request.getRequestDispatcher("sesionUsuario.jsp").forward(request, response);
						
						break;
					default:
						break;
					}
						

				}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = null;
		HttpSession session = request.getSession(true);
	
		String us =   request.getParameter("correo");
		String pw =   request.getParameter("contrasena");
		
		Usuario_DAO usarioLogin = DAOFactory.getFactory().getUsuario_DAO();
		
		Usuario usuario = usarioLogin.control_logeo(pw, us);
		
		if (usuario == null) {
			response.sendRedirect("index.html");
		}else {
			
			String rol = usuario.getRol();
		

			switch (rol) {
			case "usuario":
				
				session.setAttribute("loginUsuario", "correctoUsuario");
				request.setAttribute("usuario", usuario);
				response.sendRedirect("sesionUsuario.jsp");
				break;
			
			case "admin":
				session.setAttribute("login", "correctoAdmin");
				request.setAttribute("admin", usuario);
				response.sendRedirect("sesionAdmin.jsp"); 
				
				break;
			default:
				break;
			}
				

		}
	}

}
