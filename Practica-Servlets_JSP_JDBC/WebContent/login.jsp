<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Usuario</title>
</head>
<body>

<header>
        <a href="index.html" title="Ir a la Pagina principal"> <img src="imagenes/LogoPidelo.png" alt="Logo" id="leftFloat" width="100px" height="100px"> </a>
    </header>

    <div class="imagenEncabezado">
        <a href="index.html" title="Ir a la Pagina principal"> <img src="imagenes/LogoPidelo.png" alt="Logo" width="250px" height="250px" style="margin-top: 28%;"> </a>

    </div>

    <form id="formulario01" method="post" action="iniciar">

        <label for="correo"> <h2>Correo electr�nico </h2></label>
        <input type="text" id="correo" name="correo" value="" placeholder="Ingrese el correo ..." />
        <br>
        <label for="contrasena"><h2>Constrase�a</h2></label>
        <input type="password" id="contrasena" name="contrasena" value="" placeholder="Ingrese su contrase�a ..." />
        <br>
        <input class="boton" type="submit" id="login" name="login" value="Iniciar Sesi�n" />
        


    </form>
    
</body>
</html>