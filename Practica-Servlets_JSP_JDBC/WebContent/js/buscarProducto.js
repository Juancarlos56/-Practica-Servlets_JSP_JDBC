function opcionBusqueda(valor) {
    if (valor == "Cedula") {
            document.getElementById("Formulario01").style.display = "inline";
            document.getElementById("Formulario02").style.display = "none";
    }

    if (valor == "Correo") {
        document.getElementById("Formulario01").style.display = "none";
        document.getElementById("Formulario02").style.display = "inline";
    }
}

function buscarPro(idEmp, nomPro) {
	
	if(nomPro != ""){
		
		
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
	    xmlhttp.open("GET", "/buscarProducto?nomPro=" + nomPro +"&idEmp="+idEmp, true);
	    xmlhttp.send();
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