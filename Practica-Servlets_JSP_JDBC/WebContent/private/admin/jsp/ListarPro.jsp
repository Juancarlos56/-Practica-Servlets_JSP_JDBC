<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <section class="listarAdminPro">
                    <h3>Listar Productos</h3>
                    <form id="FormulariolistarPro" onsubmit="return buscarPro()" style="display: inline;">
                        <input type="text" id="buscaPro" name="buscaPro" value="" onkeyup="return buscarPro()" onblur="buscarPro()">
                        <input type="button" id="buscarProd" name="buscarProd" value="Buscar Producto" onclick="buscarPro()">
                    </form>
                </section>

                <section class="eliminarAdminPro">
                    <h3>Eliminar Producto </h3>
                    <p id="eliPro" name="eliPro">AQUI ESTA EL PRODUCTO ELEGIDO</p>
                    <input type="button" id="buscarPro" name="buscarPro" value="eliminar" onclick="eliminarPed()" />
                </section>


</body>
</html>