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
</head>
<body>

	<script>
    window.onload=function() {
 
		let elementos=document.getElementById("productoSeleccionado");
		
		for(let i=0;i<elementos.length;i++){
			elementos[i].addEventListener("click",obtenerValores);
		}
    }
 	
   
    </script>



	 <div class="cuerpo">
	 	<% 
	 	Usuario usuario = (Usuario)request.getAttribute("usuario");
	 	Empresa empresa = (Empresa)request.getAttribute("empresa");
	 	%>
	 	
		<h1>Buscar Productos de la Empresa <%=empresa.getNombre()%> </h1>
		
		 <form action="" class="nuevaCompra" id="formularioRealizarPedido" method="POST" >
		
			<label id="nomProducto" for="nomProducto">Ingresar Nombre Producto</label>
			<input type="text" id="nomPro" name="nomPro" value="" placeholder="Nombre producto ..."/>
			<input type="button" id="buscarPro" name="buscarPro" value="Buscar" onclick="buscarProducto(<%=empresa.getCodigo_empresa()%>);" />            
	        
	        <div class="separador"> </div>
	        <div id="informacion"><b>Busqueda de productos</b></div>
	        <div class="separador"> </div>
	        <div id="ProductoSeleccionado"><b>Información del Producto</b></div>
	        
	        
	        <label for="idPro" id="idPro">Codigo del Producto:</label>
            <input class="sepBot" type="text" id="codPro" name="codPro" value="PENDIENTE" readonly />
            <br>
	        
	        <label for="nomPr" id="nomPr">Nombre del Producto:</label>
            <input class="sepBot" type="text" id="nombreProducto" name="nombreProducto" value="..." readonly />
            <br>
            
	        <label for="precioPr" id="precioPr">Precio del Producto:</label>
            <input class="sepBot" type="text" id="precioPr" name="precioPr" value="" readonly />
            <br>
	       	
       		<label for="estadoPed" id="estadoPed">Estado:</label>
            <input class="sepBot" type="text" id="estadoPedido" name="estadoPedido" value="PENDIENTE" readonly />
            <br>
            <label for="pedido" id="pedido"> Cantidad:  </label>
            <input type="number" id="cantidadPro" name="cantidadPro" value="" placeholder="Cantidad de producto..." />
            <input class="sepBot" type="button" id="calcularTotalPro" name="calcularTotalPro" value="CalcularTotal " onclick="calcularTotal()" />
            <br>
            <label for="totalped" id="totalped">Total:   </label>
            <input class="sepBot" type="number" id="mostrarTotalPed" name="mostrarTotalPed" value=99 readonly/>
            <br>
            <input class="boton" type="submit" id="guardarNuevoReq" name="guardarNuevoReq" value="Guadar Requerimiento" />
		</form>
        
	</div>
	
</body>
</html>