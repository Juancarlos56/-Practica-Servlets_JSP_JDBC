/**
 * 
 */
 
 function crearProducto(idUsu) {
	
	var idUsuario = idUsu;		
	console.log("Este es el usuario: "+idUsu);
	
	var nomPro = document.getElementById("nombrePro").value;
	var precioPro = document.getElementById("precioPro").value;
	var iva = document.getElementById("iva").value;
	var estPro = document.getElementById("estadoProducto").value;
	var urlPro = document.getElementById("urlImagen").value;
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
    
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/NuevoPro?idUsuario="+idUsuario+"&nomPro="+nomPro+"&precioPro="+precioPro+"&iva="+iva+"&estPro="+estPro+"&urlPro="+urlPro+"&descriPro="+descriPro, true);
	xmlhttp.send();
		
}


function modProducto(idUsu) {
	
	var idUsuario = idUsu;		
	console.log("Este es el usuario: "+idUsu);
	
	var nomPro = document.getElementById("nombrePro").value;
	var precioPro = document.getElementById("precioPro").value;
	var iva = document.getElementById("iva").value;
	var estPro = document.getElementById("estadoProducto").value;
	var urlPro = document.getElementById("urlImagen").value;
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
    
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/modPro?idUsuario="+idUsuario+"&nomPro="+nomPro+"&precioPro="+precioPro+"&iva="+iva+"&estPro="+estPro+"&urlPro="+urlPro+"&descriPro="+descriPro, true);
	xmlhttp.send();
		
}





function eliminarProducto (idUsu){
	var idUsuario = idUsu;		
	console.log("Este es el usuario: "+idUsu);
	var nomPro = document.getElementById("nombrePro").value;

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
    
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/EliminarPro?idUsuario="+idUsuario+"&nomPro="+nomPro, true);
	xmlhttp.send();
		

}


function aceptarPed(idUsu){
	var idUsuario = idUsu;		
	console.log("Este es el usuario: "+idUsu);
	var nomPro = document.getElementById("nombrePro").value;

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
    
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/aceptarPed?idUsuario="+idUsuario+"&nomPro="+nomPro, true);
	xmlhttp.send();
		

}


function listarProAdmin(idEmp, idUsuario) {
	
	console.log("Estamos al final admin listar pro idUsuario:"+idUsuario+" idEmp: "+idEmp);
	
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

    xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/listarProdAdmin?idUsuario=" + idUsuario +"&idEmp="+idEmp, true);
    xmlhttp.send();
    return false;
}



function listarPedido(idEmp, idUsuario) {
	
	console.log("Estamos al final idUsuario:"+idUsuario+" idEmp: "+idEmp);
	
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

    xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/listarPedidoAdmin?idUsuario=" + idUsuario +"&idEmp="+idEmp, true);
    xmlhttp.send();
    return false;
}




