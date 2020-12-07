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
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class listarProdAdmi
 */
@WebServlet("/listarProdAdmi")
public class listarProdAdmi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listarProdAdmi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.print("ESTOY EN EL SERVLET DE Listar PRODUCTO ADMIN ");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Empresa empresa = null;
		Usuario usuario = null;

		int usu =  Integer.parseInt(request.getParameter("idAdmin"));
		int emp =  Integer.parseInt(request.getParameter("idEmp"));

		
		//aqui arreglar 
		
		ArrayList<Producto> producto = DAOFactory.getFactory().getProducto_DAO().findProductosPorEmpresa(emp);
		
		
		//System.out.println(p.size());
		String tablaDatos="";
		String tablaIndex = "<table class='tg' id='tablaBuscar' style='width:95%'>"+
				"<tr>"+
					"<th class='tg-46ru'>Nombre del Producto</th>"+
					"<th class='tg-46ru'>Precio</th>"+
					"<th class='tg-46ru'>Estado Producto</th>"+
					"<th class='tg-46ru'>Url imagen</th>"+
					"<th class='tg-46ru'>Descripcion</th>"+
					"<th class='tg-46ru'>Iva</th>"+
				"</tr>";
		if(producto !=null){
			
			for (int i=0;i<producto.size();i++){
				Producto pro=producto.get(i);
				
				tablaDatos = tablaDatos + "<tr>"+
						"<td>"+pro.getNombre()+"</td>"+
						"<td>"+pro.getPrecio()+"</td>"+
						"<td>"+pro.getEstado() +"</td>"+
						"<td>"+pro.getUrl_imagen()+"</td>"+
						"<td>"+pro.getDescripcion()+"</td>"+
						"<td>"+pro.getIva()+"</td>"+
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
