<%@page import="ec.ups.edu.modelo.Empresa"%>
<%@page import="ec.ups.edu.dao.Empresa_DAO"%>
<%@page import="ec.ups.edu.dao.DAOFactory"%>
<%@page import="ec.ups.edu.modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="StyleSheet" href="CSS/cssSesionUsuario.css" TYPE="text/css">
    <script src="js/listaProductosPublicos.js" type="text/javascript"></script>
	<title>SesionUsuario</title>
</head>
<body>
	<%
		HttpSession login = request.getSession();
		
		
		Usuario us = (Usuario)request.getAttribute("usuario");
		Empresa_DAO emp = DAOFactory.getFactory().getEmpresa_DAO();
		Empresa e = emp.empresa_de_un__usuario(us);
		
	%>
	
	
	<div class="encabezado">

                <div class="encabezado1">
                    <a href="index.html" title="Ir a la Pagina principal"> <img src="imagenes/LogoPidelo.png" width="200px" height="175px" alt="Logo"> </a>
                </div>

                <div class="encabezado2">

                    <div id="menu" class="menu">
                        <h1>Bienvedio <% out.println(us.getNombre()); %>  </h1>
                        <h2>Requermientos de compra</h2>
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

            <div class="registrarUsuCom">
                <h2> Registrar Requerimieto</h2>


                <form class="nuevaCompra" id="formularioModificarPedido" method="POST" >
                    
                    
                    <H3>Buscar Producto</H3>
                    <label id="nomProducto" for="nomProducto">Ingresar Nombre Producto</label>
                    <input type="text" id="nomPro" name="nomPro" value="" placeholder="Nombre producto ..." />
                    <input type="button" id="buscarPro" name="buscarPro" value="Buscar" onclick="buscarPro()" />
                    
                    <br>
                    <p name="mostrarProducto"> AQUI RECIBO EL PRODUCTO</p>
                    <br>
                    <label for="estadoPed" id="estadoPed">Estado:</label>
                    <input class="sepBot" type="text" id="estadoPedido" name="estadoPedido" value="PENDIENTE" readonly />
                    <br>
                    <label for="pedido" id="pedido"> Cantidad:  </label>
                    <input type="number" id="cantidadPro" name="cantidadPro" value="" placeholder="Cantidad de producto..." />
                    <input class="sepBot" type="button" id="calcularTotalPro" name="calcularTotalPro" value="CalcularTotal " onclick="calcularTotal()" />
                    <br>
                    <label for="totalped" id="totalped">Total:   </label>
                    <input class="sepBot" type="number" id="mostrarTotalPed" name="mostrarTotalPed" value=99 readonly/>
                    <br>
                    <input class="boton" type="submit" id="guardarNuevoReq" name="guardarNuevoReq" value="Guadar Requerimiento" />
                </form>

            </div>



            <div class="buscarUsuCom">
                <h2>Buscar Requerimiento</h2>

                <!--AJAX-->
                <section class="listarUsuCom">
                    <h3>listar Requermientos</h3>
                    <form id="Formulario01" onsubmit="return buscarRequerimiento()" style="display: inline;">
                        <input type="text" id="requerimiento" name="requerimiento" value="" onkeyup="return buscarRequerimiento()" onblur="buscarRequerimiento()">
                        <input type="button" id="buscarReq" name="buscarReq" value="Buscar" onclick="buscarRequerimiento()">
                    </form>

                </section>

                <section class="eliminarUsuCom">
                    <h3>Eliminar Requerimiento </h3>
                    <p id="eliPedido" name="eliPedido">AQUI ESTA EL PRODUCTO ELEGIDO</p>
                    <input type="button" id="buscarReq" name="buscarReq" value="eliminar" onclick="eliminarPed()" />
                </section>

            </div>

            <div class="modificarUsuCom">

                <section class="modCom">
                    <h2>Modificar Requerimiento</h2>
                    <br>

                    <br>

                    <form id="formularioModificarPedido" method="POST" action=" ">
                        <label for="idpedido" id="idpedido" name="idpedido">Indent Pedido</label>
                        <input class="sepBot" type="text" id="idTextpedido" name="idTextpedido" value="id pedido" readonly/>
                        <br>
                        <label for="nomPro" id="nomPro" name="nomPro">Nombre Producto</label>
                        <input class="sepBot" type="text" id="nomTextPro" name="nomTextPro" value="aqui va el nombre" readonly />
                        <br>
                        <label for="estadoPedido" id="estadoPedido" name="estadoPedido">Estado Producto</label>
                        <input class="sepBot" type="text" id="estadoTextPed" name="estadoTextPed" value="aqui va estado" readonly />
                        <br>
                        <br>
                        <label for="totalPedido" id="totalPedido" name="totalPedido">Cantidad Pedido</label>
                        <input class="sepBot" type="number" id="numCantidadPed" name="numCantidadPed" value="100" readonly />
                        <br>
                        <label for="cantidadPedido" id="cantidadPedido" name="cantidadPedido">Cantidad Pedido</label>
                        <input class="sepBot" type="number" id="numCantidadPed" name="numCantidadPed" value="" />
                        <br>
                        <input class="boton" type="submit" id="requerModificado" name="requerimientoModificado" value="Guardar Modificacion" />
                    </form>
                </section>
            </div>


        </div>

</body>
</html>