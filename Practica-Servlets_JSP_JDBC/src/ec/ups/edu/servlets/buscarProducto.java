package ec.ups.edu.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.modelo.Producto;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class buscarProducto
 */
@WebServlet("/buscarProducto")
public class buscarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url=null;
		
		String idEmpP=request.getParameter("idEmp");
		
		String nomPro=request.getParameter("nomPro");
		
		
		
	
		int idEmp =Integer.parseInt(idEmpP);
		
		System.out.println(nomPro+" y "+idEmpP);
		
		ArrayList<Producto> productos = null;
		
		
		
		List<Producto> list= prodDAO.findE(idEmp);
				request.setAttribute("listaProd", list);
				request.setAttribute("idEmp", ste);
				
				url = "/HTMLs/Invitado/ActualizarTablaInv.jsp";
			}catch(Exception e) {
				url = "/JSPs/error.jsp";
			}
		}else {
			try {
				List<Producto> list= prodDAO.findC(idCat,idEmp);
				request.setAttribute("listaProd", list);
				request.setAttribute("idEmp", ste);
				
				url = "/HTMLs/Invitado/ActualizarTablaInv.jsp";
			}catch(Exception e) {
				url = "/JSPs/error.jsp";
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
