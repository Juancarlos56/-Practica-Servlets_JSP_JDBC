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
<script src="js/funAdmin.js" type="text/javascript"></script>
<link rel="StyleSheet" href="CSS/buscaPro.css" TYPE="text/css">
<title>Registrar Prod</title>
</head>

<body background="image/regPedido.png">


 <div class="cuadrado">
 
 <% 
	 	Usuario usuario = (Usuario)request.getAttribute("usuario");
	 	Empresa empresa = (Empresa)request.getAttribute("empresa");
	 	%>
	 	
		<h1>Crear Productos en la Empresa <%=empresa.getNombre()%> </h1>
		
    
 
                <h2> Registrar Producto</h2>

                <form class="nuevoPro" id="formularioRegistrarProducto" method="POST" action=" ">

                    <label for="nombreP" id="nombreP">Nombre:</label>
                    <input class="sepBot" type="text" id="nombrePro" name="nombrePro" value="" />
                    <br>

                    <label for="labelpreProd" id="labelpreProd"> Precio:</label>
                    <input class="sepBot" type="number" id="precioPro" name="precioPro" value="" />
                    <br>

                    <label for="labeliva" id="labeliva"> IVA %:</label>
                    <input class="sepBot" type="number" id="iva" name="iva" value="12" readonly="readonly"/>
                    <br>

                    <label for="estadoPro" id="estadoPro">Estado Producto:</label>
                    <input class="sepBot" type="text" id="estadoProducto" name="estadoProducto" value="ACTIVO" readonly />
                    <br>

                    <label for="labelUrlImagen" id="labelUrlImagen">Url Imagen:</label>
                    <input class="sepBot" type="text" id="urlImagen" name="urlImagen" value="" />

                    <br>
                    <label for="labelDescriPro" id="labelDescriPro">Descripcion:   </label>
                    <input class="sepBot" type="text" id="descriPro" name="descriPro" value="" />
                    <br>

                    
                
                	<input class="boton" type="button" id="guardarNuevoPro" name="guardarNuevoPro" value="Guadar Producto" onclick="crearProducto(<%=usuario.getCodigo_usu()%>)"/>
                	<div class="separador"> </div>
		       		<div id="informacion2"><b>Verificacion de crear producto</b></div>
                
                </form>
            </div>



</body>
</html>