<%@page import="ec.ups.edu.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<table class='tg' style='width:95%'>
	<tr>
		<th class='tg-46ru'>Codigo</th>
	    <th class='tg-46ru'>Nombre</th>
	    <th class='tg-46ru'>Precio</th>
	    <th class='tg-46ru'>Iva</th>
	    <th class='tg-46ru'>Descripcion</th>
	    <th class='tg-46ru'>Imagen</th>
	</tr>
		
	<% 
		
		String t = "";
		ArrayList<Producto> pro = (ArrayList<Producto>)request.getAttribute("productos");
		if(pro !=null){
		
			for (int i=0;i<pro.size();i++){
				Producto producto=pro.get(i);
				
				t = "<tr id='id"+i+"' ondblclick=obtenerValoresTabla(this.id)>"+
						"<td>"+producto.getCodigo_pro()+"</td>"+
						"<td>"+producto.getNombre()+"</td>"+
					    "<td>"+producto.getPrecio()+"</td>"+
					    "<td>"+producto.getIva()+"</td>"+
					    "<td>"+producto.getDescripcion()+"</td>"+
					    "<td><img src='"+producto.getUrl_imagen()+"' width='200px' height='175px' ></td>"+
					    //"<td><input type='button' id='productoSeleccionado' name='productoSeleccionado' value='Seleccionar'></td>"+
					 "</tr>"+t;
		   }
			
			out.println(t);
		}
		
		%>		 
</table>    
    