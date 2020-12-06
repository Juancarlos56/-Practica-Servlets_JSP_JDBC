<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <div class="registrarAdminPro">
                <h2> Registrar Producto</h2>

                <h3>Hacer Compra</h3>

                <form class="nuevoPro" id="formularioRegistrarProducto" method="POST" action=" ">

                    <label for="nombrePro" id="nombrePro">Nombre:</label>
                    <input class="sepBot" type="text" id="estadoPedido" name="estadoPedido" value="" />
                    <br>

                    <label for="labelpreProd" id="labelpreProd"> Precio:</label>
                    <input class="sepBot" type="number" id="precioPro" name="precioPro" value="" />
                    <br>

                    <label for="labeliva" id="labeliva"> IVA %:</label>
                    <input class="sepBot" type="number" id="iva" name="iva" value="" />
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

                    <input class="boton" type="submit" id="agregarPro" name="agregarPro" value="Agregar Nuevo Producto" />
                </form>
            </div>



</body>
</html>