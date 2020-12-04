/**
 * 
 */


function EnviarDatos(idUsuario,idEmpresa,pagina) {   
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
	console.log("Estamos al final idUsuario:"+idUsuario+" idEmp: "+idEmpresa+" pagina "+pagina);
	xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/EnvioDatos?idUsuario=" + idUsuario +"&idEmp="+idEmpresa+"&pagina="+pagina, true);
	xmlhttp.send();
    return false;

}

function buscarProducto(idEmp) {
	
    var nomPro = document.getElementById("nomPro").value;
	console.log("Estamos al final nomPro:"+nomPro+" idEmp: "+idEmp);
	
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
        xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/BuscarProducto?nomPro=" + nomPro +"&idEmp="+idEmp, true);
	    xmlhttp.send();
    }
    return false;
}


 function obtenerValoresTabla(e) {
	
	console.log("Tabla: "+e);
	
    	/*
		var valores="";
		var elementosTD=e.srcElement.parentElement.getElementsByTagName("td");
		for(let i=0;i<elementosTD.length;i++){
			valores+=elementosTD[i].innerHTML+"\n";
		}
		alert(valores);*/
	}


function mostrarProducto(codPro) {
	
	
    var nomPro = document.getElementById("nomPro").value;
	var nomPro = document.getElementById("nomPro").value;
	var nomPro = document.getElementById("nomPro").value;
	var nomPro = document.getElementById("nomPro").value;
	var nomPro = document.getElementById("nomPro").value;
	



	console.log("Estamos al final idEmp: "+codPro);
	
    if (nomPro == "") {
        document.getElementById("informacion").innerHTML = "";
    } else {
		document.getElementById("informacion").innerHTML = this.responseText;
    }
    return false;
}





function buscarPorCorreo() {
    var correo = document.getElementById("correo").value;
    if (correo == "") {
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
        xmlhttp.open("GET", "../../controladores/listarTelefonosCorreo.php?correo=" + correo, true);
        xmlhttp.send();
    }
    return false;
}