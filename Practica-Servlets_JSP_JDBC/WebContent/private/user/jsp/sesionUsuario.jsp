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
    <script src="./js/listaProductosPublicos.js" type="text/javascript"></script>
    <script src="./js/buscarProductos.js" type="text/javascript"></script>
	<title>SesionUsuario</title>
</head>
<body background="image/sesionUsu.png">

	<%
		HttpSession login = request.getSession();
		Empresa empresa = null;
		Usuario us = null;
		if (login.getAttribute("usuario") != null){
			String autentificacion = login.getAttribute("usuario").toString();
			if (autentificacion.equals("usuario") == false){
				session.invalidate();
			    response.sendRedirect("publico/index.html");
			    return;
			}else{
				
				try{
					us = (Usuario)request.getAttribute("usuario");
					empresa = (Empresa)request.getAttribute("emp");
				}catch(NullPointerException e){
					response.sendRedirect("publico/index.html");
				}
				
				
			}
		}else{
			response.sendRedirect("publico/index.html");
		}
		
		
		
        
	%>
		<header>
	
			<div class="encabezado">

                <div class="encabezado1">
                    <a href="publico/index.html" title="Ir a la Pagina principal"> <img src="image/Logo2.png" width="200px" height="175px" alt="Logo"> </a>
                </div>

                <div class="encabezado2">

                    <div id="menu" class="menu">
                        <h1 style="background-color: cadetblue;">Bienvenido <% 
					                        try{
                        						if (us != null) {
                            						out.println(us.getNombre()); 
                            					}	
                        					}catch(NullPointerException e){
                        						response.sendRedirect("publico/index.html");
                        					}
                        						
                        					
                        					%>  
                        </h1>
                        <h2>Requermientos de compra para la empresa <% 
               					try{
               						if (us != null) {
                   						out.println(empresa.getNombre()); 
                   					}	
               					}catch(NullPointerException e){
               						response.sendRedirect("publico/index.html");
               					}			
               					
                        	%>  
                        
                        </h2>
                        
                    </div>


                </div>

                <div class="encabezado3">
                    <div class="ingreUsuEncabezado3">
                        <a href="publico/index.html"> <img src="https://image.flaticon.com/icons/png/512/64/64572.png" width="50px" height="50px" alt="Acceder a la cuenta"></a>
                        <h5>Salir</h5>
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