<%@page import="ec.ups.edu.modelo.Empresa"%>
<%@page import="ec.ups.edu.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class='tg' id="tablaBuscar"style='width:95%'>
	<tr>
		<th class='tg-46ru'>Codigo</th>
	    <th class='tg-46ru'>Nombre</th>
	    <th class='tg-46ru'>Precio</th>
	    <th class='tg-46ru'>Iva</th>
	    <th class='tg-46ru'>Estado</th>
	    <th class='tg-46ru'>Descripcion</th>
	    <th class='tg-46ru'>Imagen</th>
	</tr>
		
	<% 
		
		String t = "";
		String n = "";
		ArrayList<Producto> pro = (ArrayList<Producto>)request.getAttribute("productosAdmin");
		if(pro !=null){
		
			for (int i=0;i<pro.size();i++){
				Producto producto=pro.get(i);
	%>	
				<tr>
						<td><%=producto.getCodigo_pro()%></td>
						<td><%=producto.getNombre()%></td>
					    <td><%=producto.getPrecio()%></td>
					    <td><%=producto.getIva()%></td>
					    <td><%=producto.getEstado()%></td>
					    <td><%=producto.getDescripcion()%></td>																																				    <td><img src='<%=producto.getUrl_imagen()%>' width='200px' height='175px'></td>
					    <td><input type='button' id='productoSeleccionado' name='productoSeleccionado' 
					    value='Seleccionar' onclick="mostrarPedidoPro(<%=producto.getCodigo_pro()%>,'<%=producto.getNombre()%>',
					    <%=producto.getPrecio()%>,<%=producto.getIva()%>,'<%=producto.getEstado()%>'
					    ,'<%=producto.getDescripcion()%>','<%=producto.getUrl_imagen()%>' )"></td>
				</tr>	
						 
		   	<% }
		}
		%>	
		
					 
</table> 

</body>
</html>