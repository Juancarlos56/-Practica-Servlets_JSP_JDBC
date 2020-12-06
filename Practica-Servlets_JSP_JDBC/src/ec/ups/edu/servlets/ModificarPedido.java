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
import ec.ups.edu.modelo.Pedido;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class ModificarPedido
 */
@WebServlet("/ModificarPedido")
public class ModificarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.print("ESTOY EN EL SERVLET DE MODIFICAR PEDIDO ");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Empresa empresa = null;
		Usuario usuario = null;

		int usu =  Integer.parseInt(request.getParameter("idUsuario"));
		int emp =  Integer.parseInt(request.getParameter("idEmp"));

		
		ArrayList<Pedido> pedidos = DAOFactory.getFactory().getPedido_DAO().findByUsuarioPedidosCodigo(usu);
		
		for (Pedido pedido : pedidos) {
			pedido.setUsuario(DAOFactory.getFactory().getUsuario_DAO().read(pedido.getCodUsu()));
		}
		
		for (Pedido pedido : pedidos) {
			pedido.setProducto(DAOFactory.getFactory().getProducto_DAO().read(pedido.getCodPro()));
		}
		
		System.out.println(pedidos.size());
		String tablaDatos="";
		String tablaIndex = "<table class='tg' id='tablaBuscar' style='width:95%'>"+
				"<tr>"+
					"<th class='tg-46ru'>Nombre del Producto</th>"+
					"<th class='tg-46ru'>Cantidad Pedida</th>"+
					"<th class='tg-46ru'>Precio por Unidad</th>"+
					"<th class='tg-46ru'>Estado del Pedido</th>"+
					"<th class='tg-46ru'>Total</th>"+
				"</tr>";
		if(pedidos !=null){
			
			for (int i=0;i<pedidos.size();i++){
				Pedido ped=pedidos.get(i);
				
				tablaDatos = tablaDatos + "<tr>"+
						"<td>"+ped.getProducto().getNombre()+"</td>"+
						"<td>"+ped.getCantidad()+"</td>"+
						"<td>"+ped.getProducto().getPrecio()+"</td>"+
						"<td>"+ped.getEstado()+"</td>"+
						"<td>"+ped.getTotal()+"</td>"+
						"<td><input type='button' id='pedidoSe' name='pedidoSe' value='Seleccionar' onclick='mostrarPedido("+ped.getCodigo_pedido()+",\""+ped.getProducto().getNombre()+"\",\""+ped.getEstado()+"\","+ped.getCantidad()+","+ped.getProducto().getPrecio()+","+ped.getTotal()+")'></td>"+
						"</tr>";	
			}
			
			tablaDatos = tablaDatos + "</table> ";
				
		}

		tablaIndex = tablaIndex + tablaDatos;
		out.println(tablaIndex);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
