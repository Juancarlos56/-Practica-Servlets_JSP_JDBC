package ec.ups.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.modelo.Empresa;
import ec.ups.edu.modelo.Pedido;
import ec.ups.edu.modelo.Producto;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class NuevoPedido
 */
@WebServlet("/NuevoPedido")
public class NuevoPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Producto prod = null;
		Usuario us = null;
		
		int usu =  Integer.parseInt(request.getParameter("idUsuario"));
		int pro =  Integer.parseInt(request.getParameter("codPro"));
		int ca =  Integer.parseInt(request.getParameter("cantidad"));
		double tt =  Double.parseDouble(request.getParameter("total"));
		
		Pedido pedidoUsuario = new Pedido(1, "Pendiente", ca, tt);
		us = DAOFactory.getFactory().getUsuario_DAO().read(usu);
		prod = DAOFactory.getFactory().getProducto_DAO().read(pro);
		pedidoUsuario.setUsuario(us);
		pedidoUsuario.setProducto(prod);
		
		DAOFactory.getFactory().getPedido_DAO().create(pedidoUsuario);
		out.println("<h3>El pedido ha sido creado</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Producto prod = null;
		Usuario us = null;
		
		int usu =  Integer.parseInt(request.getParameter("idUsuario"));
		int pro =  Integer.parseInt(request.getParameter("codPro"));
		int ca =  Integer.parseInt(request.getParameter("cantidad"));
		double tt =  Double.parseDouble(request.getParameter("total"));
		
		Pedido pedidoUsuario = new Pedido(1, "Pendiente", ca, tt);
		us = DAOFactory.getFactory().getUsuario_DAO().read(usu);
		prod = DAOFactory.getFactory().getProducto_DAO().read(pro);
		pedidoUsuario.setUsuario(us);
		pedidoUsuario.setProducto(prod);
		
		DAOFactory.getFactory().getPedido_DAO().create(pedidoUsuario);
		out.println("<h3>El pedido ha sido creado</h3>");
	}
		
}
