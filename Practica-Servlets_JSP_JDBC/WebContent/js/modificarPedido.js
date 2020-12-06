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

