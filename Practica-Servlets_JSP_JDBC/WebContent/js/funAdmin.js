/**
 * 
 */
 
 function crearProducto() {
	
	var categoria = document.getElementById("categoria").value;
	var nombrePro = document.getElementById("nombrePro").value;
	var precioPro = document.getElementById("precioPro").value;
	var iva = document.getElementById("iva").value;
	var estadoProducto = document.getElementById("estadoProducto").value;
	var urlImagen = document.getElementById("urlImagen").value;
	var descriPro = document.getElementById("descriPro").value;
	
	
	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
	xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            document.getElementById("informacion2").innerHTML = this.responseText;
        }
    };
    
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/NuevoPro?categoria="+categoria+"&nombrePro="+nombrePro
	+"&precioPro="+precioPro+"&iva="+iva+"&estadoProducto="+estadoProducto+"&urlImagen="+urlImagen
	+"&descriPro="+descriPro, true);
	xmlhttp.send();
		
}


function modProducto() {
	
	var codPro = document.getElementById("codPro").value;
	var nomPro = document.getElementById("MODnombreProd").value;
	var precioPro = document.getElementById("MODprecioPro").value;
	var iva = document.getElementById("MODiva").value;
	var estPro = document.getElementById("MODestadoProducto").value;
	var urlPro = document.getElementById("MODurlImagen").value;
	var descriPro = document.getElementById("MODdescriPro").value;
	
	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
	xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            document.getElementById("informacion2").innerHTML = this.responseText;
        }
    };
    
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/modPro?codPro="+codPro+"&nomPro="+nomPro+"&precioPro="+precioPro+"&iva="+iva+"&estPro="+estPro+"&urlPro="+urlPro+"&descriPro="+descriPro, true);
	xmlhttp.send();
		
}





function eliminarProducto (){
	var codPro = document.getElementById("codPro").value;
	
	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
	xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            document.getElementById("informacion2").innerHTML = this.responseText;
        }
    };
    
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/EliminarPro?codPro="+codPro, true);
	xmlhttp.send();
		

}


function listarProAdmin(idEmp, idAdmin) {
	
	console.log("Estamos al final admin listar pro idAdmin:"+idAdmin+" idEmp: "+idEmp);
	
   	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            document.getElementById("informacion").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/listarProdAdmi?idAdmin=" + idAdmin +"&idEmp="+idEmp, true);
    xmlhttp.send();
    return false;
}



function listarPedido(idEmp, idAdmin) {
	
	console.log("Estamos al final idAdmin:"+idAdmin+" idEmp: "+idEmp);
	
   	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            document.getElementById("informacion").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/listarPedidoAdmin?idAdmin=" + idAdmin +"&idEmp="+idEmp, true);
    xmlhttp.send();
    return false;
}


function listarPedidoParaAprobacion(idEmp, idAdmin) {
	
	console.log("Estamos al final idUsuario:"+idAdmin+" idEmp: "+idEmp);
	
   	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            document.getElementById("informacion").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/mostrarPedidosParaAprobacion?idAdmin=" + idAdmin +"&idEmp="+idEmp, true);
    xmlhttp.send();
    return false;
}

function mostrarPedidoPro(codPro, nomPro, PrecioPro, iva, estado, descripcion, url) {
    console.log("ivaaaaaa: "+iva);

	
	document.getElementById("codPro").value = codPro;
	document.getElementById("MODnombreProd").value = nomPro;
	document.getElementById("MODprecioPro").value = PrecioPro;
	document.getElementById("MODiva").value = iva;
	document.getElementById("MODestadoProducto").value = estado;
	document.getElementById("MODurlImagen").value = url;
	document.getElementById("MODdescriPro").value = descripcion;
	
		
}

function buscarProducto(idEmp) {
	
    var nomPro = document.getElementById("nomPro").value;
	console.log("Joder si estamos aquiiii ...Estamos al final nomPro:"+nomPro+" idEmp: "+idEmp);
	
    if (nomPro == "") {
        document.getElementById("informacion").innerHTML = "";
    } else {
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue");
                document.getElementById("informacion").innerHTML = this.responseText;
            }
        };
        console.log("Estamos al final nomPro:"+nomPro+" idEmp: "+idEmp);
        xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/BuscarProductoAdm?nomPro=" + nomPro +"&idEmp="+idEmp, true);
	    xmlhttp.send();
    }
    return false;
}


	


function mostrarPedido(idPedido,estado) {
	
	console.log("Este es el pedido seleccionado: "+idPedido);
	
	if(estado != ""){
		
		
		if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
	    } else {
	        // code for IE6, IE5
	        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	    
		xmlhttp.onreadystatechange = function() {
	        if (this.readyState == 4 && this.status == 200) {
	            //alert("llegue");
	            document.getElementById("informacion2").innerHTML = this.responseText;
	        }
	    };


		if(estado == "Aprobado"){
			xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/aceptarPed?idPedido="+idPedido+"&estado="+estado, true);
			xmlhttp.send();
		}
		
		if(estado == "Rechazado"){	
			xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/aceptarPed?idPedido="+idPedido+"&estado="+estado, true);
			xmlhttp.send();
		}
		
	    
		
		
	}
		
}

