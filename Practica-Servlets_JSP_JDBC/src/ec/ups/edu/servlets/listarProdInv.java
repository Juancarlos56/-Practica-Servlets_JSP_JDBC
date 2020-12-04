package ec.ups.edu.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.Producto_DAO;
import ec.ups.edu.dao.Usuario_DAO;
import ec.ups.edu.modelo.Producto;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class istarProdInv
 */
@WebServlet("/istarProdInv")
public class listarProdInv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// para el q hizo
	//private ProductosDao prodDAO;
	//private UsuariosDAO usudao;
    
    
    //public VisualizacionProductosInvitado() {
      //  prodDAO= DAOFactory.getFactory().getProductosDao();
      //  usudao= DAOFactory.getFactory().getUsuariosDAO();
    //}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listarProdInv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String url;
		//String url2=null;
		//try {
			//int idProInv=Integer.parseInt(request.getParameter("idProInv"));
			//List<Producto> list= prodDAO.findE(idProInv);
			
			//Usuario invitado = new Usuario(0, "", "", "", "", 'a', idProInv);
			
			//request.setAttribute("listaProd", list);
			
			
			//request.setAttribute("idProInv", invitado);
			
			url = "mostrarProdInv.jsp";
		//}catch(Exception e) {
			//url = "/JSPs/error.jsp";
		//}
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}
	
}
