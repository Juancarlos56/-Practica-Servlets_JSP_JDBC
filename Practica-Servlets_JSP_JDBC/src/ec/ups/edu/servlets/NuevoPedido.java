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
		ArrayList<Pedido> pedido = DAOFactory.getFactory().getPedido_DAO().findArrayList();
		
		String t = "<table class='tg' id='tablaBuscar' style='width:95%'>"+
				"<tr>"+
					"<th class='tg-46ru'>Codigo</th>"+
				    "<th class='tg-46ru'>Nombre</th>"+
				    "<th class='tg-46ru'>Precio</th>"+
				    "<th class='tg-46ru'>Iva</th>"+
				    "<th class='tg-46ru'>Descripcion</th>"+
				    "<th class='tg-46ru'>Imagen</th>"+
				"</tr>";
				
		if(pedido !=null){
			
			for (int i=0;i<pedido.size();i++){
				Pedido ped=pedido.get(i);
			<tr>
						<td><%=producto.getCodigo_pro()%></td>
						<td><%=producto.getNombre()%></td>
					    <td><%=producto.getPrecio()%></td>
					    <td><%=producto.getIva()%></td>
					    <td><%=producto.getDescripcion()%></td>
					    <td><img src='<%=producto.getUrl_imagen()%>' width='200px' height='175px'></td>
					    <td><input type='button' id='productoSeleccionado' name='productoSeleccionado' value='Seleccionar' onclick="mostrarProductos(<%=producto.getCodigo_pro()%>,'<%=producto.getNombre()%>',<%=producto.getPrecio()%>)"></td>
				</tr>			 
		   	<% }
		}
		
	}

}
