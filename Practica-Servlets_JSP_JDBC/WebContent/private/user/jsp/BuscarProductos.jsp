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
<title>HACER PEDIDO</title>
<script src="js/buscarProductos.js" type="text/javascript"></script>
<link rel="StyleSheet" href="CSS/buscaPro.css" TYPE="text/css">
</head>
<body  background="image/regPedido.png">

	<script>
    window.onload=function() {
 
		let elementos=document.getElementById("productoSeleccionado");
		
		for(let i=0;i<elementos.length;i++){
			elementos[i].addEventListener("click",obtenerValores);
		}
    }
 	
   
    </script>
    
    
    



	 <div class="cuadrado">
	 	<% 
	 	Usuario usuario = (Usuario)request.getAttribute("usuario");
	 	Empresa empresa = (Empresa)request.getAttribute("empresa");
	 	%>
	 	
		<h1>Buscar Productos de la Empresa <%=empresa.getNombre()%> </h1>
		
		 <form action="" class="nuevaCompra" id="formularioRealizarPedido" method="POST" >
		
			<label style="margin-right: 50px;"  id="nomProducto" for="nomProducto">Ingresar Nombre Producto</label>
			<input type="text" id="nomPro" name="nomPro" value="" placeholder="Nombre producto ..."/>
			<input type="button" id="buscarPro" name="buscarPro" value="Buscar" onclick="buscarProducto(<%=empresa.getCodigo_empresa()%>);" />            
	        
	        <div class="separador"> </div>
	        <div id="informacion"><b>Busqueda de productos</b></div>
	        <div class="separador"> </div>
	        <br>
	        <br>
	        
	        <div id="ProductoSeleccionado"><b>Información del Producto</b></div>
	        
	        
	        
	        <label for="idPro" style="margin-right: 50px;"  id="idPro">Codigo del Producto:</label>
            <input class="sepBot" type="text" id="codPro" name="codPro" value="PENDIENTE" readonly />
            <br>
	        <br>
	        <label for="nomPr" id="nomPr"  style="margin-right: 50px;" >Nombre del Producto:</label>
            <input class="sepBot" type="text" id="nombreProducto" name="nombreProducto" value="..." readonly />
            <br>
            <br>
	        <label for="precioPr" id="precioPr"  style="margin-right: 50px;"  >Precio del Producto:</label>
            <input class="sepBot" type="text" id="precioPr" name="precioPr" value="" readonly />
            <br>
	       	<br>
       		<label for="estadoPed" id="estadoPed" style="margin-right: 50px;" >Estado:</label>
            <input class="sepBot" type="text" id="estadoPedido" name="estadoPedido" value="PENDIENTE" readonly />
            <br>
            <br>
            <label for="pedido" id="pedido" style="margin-right: 50px;" > Cantidad:  </label>
            <input type="number" id="cantidadPro" name="cantidadPro" value="" placeholder="Cantidad de producto..." />
            <input class="sepBot" type="button" id="calcularTotalPro" name="calcularTotalPro" value="CalcularTotal " onclick="calcularTotal()" />
            <br>
            <br>
            <label for="totalped" id="totalped" style="margin-right: 50px;" >Total:   </label>
            <input class="sepBot" type="number" id="mostrarTotalPed" name="mostrarTotalPed" value=99 readonly/>
            <br>
            <input class="boton" type="submit" id="guardarNuevoReq" name="guardarNuevoReq" value="Guadar Requerimiento" />
		</form>
        
	</div>
	
</body>
</html>