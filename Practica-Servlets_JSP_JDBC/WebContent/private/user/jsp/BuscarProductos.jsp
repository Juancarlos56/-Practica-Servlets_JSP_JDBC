<%@page import="ec.ups.edu.dao.DAOFactory"%>
<%@page import="ec.ups.edu.modelo.Usuario"%>
<%@page import="ec.ups.edu.modelo.Empresa"%>
<%@page import="ec.ups.edu.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar Producto</title>
<script src="js/buscarProductos.js" type="text/javascript"></script>
<script>
	
</script>
</head>
<body>

	 <div class="cuerpo">
	 	<% 
	 	Usuario usuario = (Usuario)request.getAttribute("usuario");
	 	Empresa empresa = (Empresa)request.getAttribute("empresa");
	 	%>
	 	
		<h1>Buscar Productos de la Empresa <%=empresa.getNombre()%> </h1>
		
		<div>
			 <form action="" class="nuevaCompra" id="formularioRealizarPedido" method="POST" >
			
				<label id="nomProducto" for="nomProducto">Ingresar Nombre Producto</label>
				<input type="text" id="nomPro" name="nomPro" value="" placeholder="Nombre producto ..." onkeyup="buscarProducto(<%=empresa.getCodigo_empresa()%>);"/>
				<input type="button" id="buscarPro" name="buscarPro" value="Buscar" onclick="buscarProducto(<%=empresa.getCodigo_empresa()%>);" />            
		        <div class="separador"> </div>
		        <div id="informacion"><b>Busqueda de productos</b></div>
		        
		        
		        <div class="separador"> </div>
		        <div id="ProductoSeleccionado"><b>Información del Producto</b></div>
		        
		        
		        <label for="idPro" id="idPro">Codigo del Producto:</label>
	            <input class="sepBot" type="text" id="codPro" name="codPro" value="Codigo del producto..." readonly />
	            <br>
		        
		        <label for="nomPr" id="nomPro">Nombre del Producto:</label>
	            <input class="sepBot" type="text" id="nombreProducto" name="nombreProducto" value="..." readonly />
	            <br>
	            
		        <label for="precioPr" id="precioPro">Precio del Producto:</label>
	            <input class="sepBot" type="text" id="precioPr" name="precioPr" value="" readonly />
	            <br>
		       	
	       		<label for="estadoPed" id="estadoPed">Estado:</label>
	            <input class="sepBot" type="text" id="estadoPedido" name="estadoPedido" value="Pendiente de revisión" readonly />
	            <br>
	            
	            <label for="cantidadLabel" id="cantidadLabel"> Cantidad:  </label>
	            <input type="number" id="cantidadPro" name="cantidadPro" value="" placeholder="Cantidad de producto..."  />
	            <input class="sepBot" type="button" id="calcularTotalPro" name="calcularTotalPro" value="CalcularTotal " onclick="calcularTotal()" />
	            <br>
	            
	            <label for="totalped" id="totalped">Total:   </label>
	            <input class="sepBot" type="number" id="mostrarTotalPed" name="mostrarTotalPed" value=99 readonly/>
	            <br>
	            
	            <input class="boton" type="button" id="guardarNuevoReq" name="guardarNuevoReq" value="Guadar Requerimiento" onclick="realizarPedido(<%=usuario.getCodigo_usu()%>)"/>
				<div class="separador"> </div>
		        <div id="informacion2"><b>Verificacion de creacion del pedido</b></div>
		        
			</form>
		</div>	        
	</div>
	
</body>
</html>