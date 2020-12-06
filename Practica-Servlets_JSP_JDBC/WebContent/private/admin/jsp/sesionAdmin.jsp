<%@page import="java.util.ArrayList"%>
<%@page import="ec.ups.edu.modelo.Producto"%>
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
    <script src="./js/funAdmin.js" type="text/javascript"></script>
	<title>SesionUsuario</title>
</head>
<body>

		<%
			HttpSession login = request.getSession();
			Administrador adm = null;
			if (login.getAttribute("admin") != null){
				String autentificacion = login.getAttribute("admin").toString();
				if (autentificacion.equals("admin") == false){
					session.invalidate();
				    response.sendRedirect("index.html");
				    return;
				}else{
					adm = (Administrador)request.getAttribute("admin");
					Empresa_DAO emp = DAOFactory.getFactory().getEmpresa_DAO();
					Empresa e = emp.empresa_de_un_admin(adm);
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
                    	 <h1>Bienvenido de nuevo <%  
					                    	 try{
					     						if (adm != null) {
					     							out.println(adm.getNombre());
					         					}	
					     					}catch(NullPointerException e){
					     						response.sendRedirect("index.html");
					     					}
                    	 				%>  
                    	 </h1>
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


       <div class="cuadrado">
         
         
         <nav>
         	
         		 <li style="border-bottom-style: inset;">
          			 <% String url = "/Practica-Servlets_JSP_JDBC/EnvioDatos?idUsuario=" + us.getCodigo_usu() +"&idEmp="+empresa.getCodigo_empresa()+"&pagina=BuscarProductos.jsp";%>
           			 <a href="<%=url%>"><h2>Registrar Pedido</h2></a>
            	</li>
             	<li style="border-bottom-style: inset;">
             		 <% String url2 = "/Practica-Servlets_JSP_JDBC/EnvioDatos?idUsuario=" + us.getCodigo_usu() +"&idEmp="+empresa.getCodigo_empresa()+"&pagina=modificarPedido.jsp";%>
             		<a href="<%=url2%>"><h2>Modificar Pedido</h2></a>
              	</li>
              	<li style="border-bottom-style: inset;"> 
              		<% String url3 = "/Practica-Servlets_JSP_JDBC/EnvioDatos?idUsuario=" + us.getCodigo_usu() +"&idEmp="+empresa.getCodigo_empresa()+"&pagina=listarPedido.jsp";%>
             		<a href="<%=url3%>"><h2>Listar Pedido</h2></a>
              	</li>
              
          </nav>

       </div>
		
</body>
</html>