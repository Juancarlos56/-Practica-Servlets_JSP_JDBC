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
 * Servlet implementation class ActualizarPedido
 */
@WebServlet("/ActualizarPedido")
public class ActualizarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Pedido pedido=null;
		
		int codPedido =  Integer.parseInt(request.getParameter("codPedido"));
		int cantidad =  Integer.parseInt(request.getParameter("cantidad"));
		double total =  Double.parseDouble(request.getParameter("total"));
		
		pedido = DAOFactory.getFactory().getPedido_DAO().read(codPedido);
		pedido.setCantidad(cantidad);
		pedido.setTotal(total);
		
		DAOFactory.getFactory().getPedido_DAO().update(pedido);
		out.println("<h3>Se modifico el pedido, click en listar para ver el cambio</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
