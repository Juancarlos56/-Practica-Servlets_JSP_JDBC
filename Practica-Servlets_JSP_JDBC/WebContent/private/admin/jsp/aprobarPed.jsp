<%@page import="ec.ups.edu.modelo.Pedido"%>
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
<title>Aprobar pedidos</title>
<script src="js/listarPedido.js" type="text/javascript"></script>
<script src="js/funAdmin.js" type="text/javascript"></script>
<link rel="StyleSheet" href="CSS/buscaPro.css" TYPE="text/css">
</head>
<body background="image/regPedido.png">
<div class="cuadrado">
	<% 
	 	Usuario usuario = (Usuario)request.getAttribute("usuario");
	 	Empresa empresa = (Empresa)request.getAttribute("empresa");
	 	%>
	 	
		<h1>Aceptar Pedidos para la Empresa <%=empresa.getNombre()%> </h1>
		
		<label id="nomProducto" for="nomProducto" style="margin-right: 50px;" >Listar Pedidos</label>
		<input type="button" id="listarPedidos" name="listarPedidos" value="Listar" onclick="listarPedido(<%=empresa.getCodigo_empresa()%>,<%=usuario.getCodigo_usu() %>);" />            
		 <div class="separador"> </div>
		 <div id="informacion"><b>Lista de Pedidos</b></div>

		<br>
		
		<input class="boton" type="button" id="aceptarPed" name="aceptarPed" value="Aceptar Pedido" onclick="aceptarPed(<%=usuario.getCodigo_usu()%>)"/>
				
				<div class="separador"> </div>
		        <div id="informacion2"><b>Verificacion de aprobacion del pedido</b></div>



</div>


</body>
</html>