<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="StyleSheet" href="../CSS/cssIniciarSesion.css" TYPE="text/css">
<title>Mostrar Producto por Empresa</title>

</head>
<body background="../image/login.png" >

	<header>
        <a href="index.html" title="Ir a la Pagina principal"> <img src="../image/Logo2.png" alt="Logo" id="leftFloat" width="100px" height="100px"> </a>
 	</header>
 	
 	<section class= "cuadrado">

    <form id="formulario01" method="post" action="/Practica-Servlets_JSP_JDBC/iniciar">

        <label for="correo"> <h2>Correo electrónico </h2></label>
        <input type="text" id="correo" name="correo" value="" placeholder="Ingrese el correo ..." />
        <br>
        <label for="contrasena"><h2>Constraseña</h2></label>
        <input type="password" id="contrasena" name="contrasena" value="" placeholder="Ingrese su contraseña ..." />
        <br>
        <input class="boton" type="submit" id="login" name="login" value="Iniciar Sesión" />
    </form>
 	
 	</section>


    
</body>