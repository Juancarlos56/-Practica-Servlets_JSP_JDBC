<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
    <link rel="StyleSheet" href="CSS/cssSesionAdmin.css" TYPE="text/css">
    <script src="js/listaProductosPublicos.js" type="text/javascript"></script>
	<title>SesionAdmin</title>

</head>
<body>

	<%
			HttpSession login = request.getSession();
			
			if (login.getAttribute("login") != null){
				String autentificacion = login.getAttribute("login").toString();
				if (autentificacion.equals("correctoAdmin") == false){
					session.invalidate();
				    response.sendRedirect("index.html");
				    return;
				}
			}else{
				response.sendRedirect("index.html");
			}
		
		%>
		
	<header>

            <div class="encabezado">

                <div class="encabezado1">
                    <a href="index.html" title="Ir a la Pagina principal"> <img src="imagenes/LogoPidelo.png" width="200px" height="175px" alt="Logo"> </a>
                </div>

                <div class="encabezado2">

                    <div id="menu" class="menu">
                        <h2>Bienvenido Administrador</h2>
                        <nav>
                            <ol>
                                <li>
                                    <a href="registrarReq.html">
                                        <h2>Registrar</h2>
                                    </a>
                                </li>
                                <li>
                                    <a href="modificarReq.html">
                                        <h2>Modificar</h2>
                                    </a>
                                </li>
                                <li>
                                    <a href="eliminarReq.html">
                                        <h2>Eliminar</h2>
                                    </a>
                                </li>
                                <li>
                                    <a href="buscarReq.html">
                                        <h2>Buscar</h2>
                                    </a>
                                </li>
                                <li>
                                    <a href="listarReq.html">
                                        <h2>Listar</h2>
                                    </a>
                                </li>
                            </ol>
                        </nav>
                    </div>


                </div>

                <div class="encabezado3">
                    <div class="ingreUsuEncabezado3">
                        <a href="iniciarSesion.html"> <img src="https://image.flaticon.com/icons/png/512/64/64572.png" width="50px" height="50px" alt="Acceder a la cuenta"></a>
                        <h5>Acceder</h5>
                    </div>

                    <div class="agreUsuEncabezado3">
                        <a href="crearCuenta.html"><img src="https://image.flaticon.com/icons/png/512/94/94979.png" width="50px" height=50px "" alt="Crear Cuenta"></a>
                        <h5>Crear Cuenta</h5>
                    </div>
                </div>

            </div>

        </header>


        <div class="cuerpo">

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



            <div class="buscarAdminPro">
                <h2>Buscar Producto</h2>

                <!--AJAX-->
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

            </div>

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

        </div>
		
</body>
</html>