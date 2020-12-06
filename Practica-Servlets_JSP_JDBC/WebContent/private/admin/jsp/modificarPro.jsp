<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



 <div class="modificarAdminPro">

                <section class="modCom">
                    <h2>Modificar Producto</h2>
                    <br>
                    <label for="MODnombrePro" id="MODnombrePro">Nombre:</label>
                    <input class="sepBot" type="text" id="MODestadoPedido" name="MODestadoPedido" value="" />
                    <br>

                    <label for="MODlabelpreProd" id="MODlabelpreProd"> Precio:</label>
                    <input class="sepBot" type="number" id="MODprecioPro" name="MODprecioPro" value="" />
                    <br>

                    <label for="MODlabeliva" id="MODlabeliva"> IVA %:</label>
                    <input class="sepBot" type="number" id="MODiva" name="MODiva" value="" />
                    <br>

                    <label for="MODestadoPro" id="MODestadoPro">Estado Producto:</label>
                    <input class="sepBot" type="text" id="MODestadoProducto" name="MODestadoProducto" value="ACTIVO" readonly />
                    <br>

                    <label for="MODlabelUrlImagen" id="MODlabelUrlImagen">Url Imagen:</label>
                    <input class="sepBot" type="text" id="MODurlImagen" name="MODurlImagen" value="" />

                    <br>
                    <label for="MODlabelDescriPro" id="MODlabelDescriPro">Descripcion:   </label>
                    <input class="sepBot" type="text" id="MODdescriPro" name="MODdescriPro" value="" />
                    <br>

                    <input class="boton" type="submit" id="modificarPro" name="modificarPro" value="Modificar Producto" />

                </section>

            </div>

</body>
</html>