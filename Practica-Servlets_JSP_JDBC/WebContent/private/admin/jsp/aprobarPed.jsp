<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="aprobarReq">

                <section class="listarTodosReq">
                    <h3>Requerimientos</h3>

                    <table id="listaReque" width="120px">
                        <tr>
                            <td><a href="#">Nombre Producto</a></td>
                            <td><a href="#">atributo1</a></td>
                            <td><a href="#">atributo2</a></td>
                            <td><a href="#">Imagen</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">Nombre Producto</a></td>
                            <td><a href="#">atributo1</a></td>
                            <td><a href="#">atributo2</a></td>
                            <td><a href="#">Imagen</a></td>
                        </tr>

                    </table>

                </section>

                <section class="listarPendiente">
                    <h3>Aprobar requerimientos</h3>
                    <input type="button" id="aceptarPendinte" name="aceptarPendiente" value="Aceptar Rendiente" onclick="eliminarPed()" />


                </section>
            </div>


</body>
</html>