/**
 * 
 */

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

    xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/listarPedido?idUsuario=" + idUsuario +"&idEmp="+idEmp, true);
    xmlhttp.send();
    return false;
}






