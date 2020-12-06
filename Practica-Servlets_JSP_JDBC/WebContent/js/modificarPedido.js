/**
 * 
 */

function listarPedido(idEmp, idUsuario) {
	
    var nomPro = document.getElementById("nomPro").value;
	console.log("Estamos al final idUsuario:"+idUsuario+" idEmp: "+idEmp);
	
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
    
        xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/ModificarPedido?idUsuario=" + idUsuario +"&idEmp="+idEmp, true);
	    xmlhttp.send();
    }
    return false;
}


function mostrarPedido(codPedido,proNombre,pedEstado,pedCantidad,proPrecio,total) {
    console.log("Estamos en modificar pedido");
	document.getElementById("idTextpedido").value = codPedido;
	document.getElementById("nomTextPro").value = proNombre;
	document.getElementById("estadoTextPed").value = pedEstado;	
	document.getElementById("numCantidadPed").value = pedCantidad;
	document.getElementById("precioPro").value = proPrecio;
	document.getElementById("total").value = total;	
	
}


function eliminarPedido(idUsu, idPed) {
	
	var idUsuario = idUsu;		
	console.log("Este es el usuario: "+idUsu);
	var codPed = document.getElementById("idTextpedido").value;
	var nombrePed = document.getElementById("nomTextPro").value;
	var estadoPed = document.getElementById("estadoTextPed").value;
	var totalPed = document.getElementById("total").value
	
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
    
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/EliminarPed?idUsuario="+idUsu+"&codPed="+codPed+"&nombrePed="+nombrePed+"&estadoPed="+estadoPed+"&totalPed="+totalPed, true);
	xmlhttp.send();
		
}
