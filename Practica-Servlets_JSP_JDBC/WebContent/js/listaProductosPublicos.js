function showMenu(elmnt) {
    document.getElementById(elmnt).style.visibility = "visible";
    console.log("imprimiendo el elemento")

}

//function hideMenu(elmnt) {
//  document.getElementById(elmnt).style.visibility = "hidden";
//console.log(elmnt)
//}

function buscarProductoIndex(idEmp) {
	
	console.log("Estamos al final idEmp: "+idEmp);
	
   
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
    xmlhttp.open("GET", "/Practica-Servlets_JSP_JDBC/MostrarProductosEmpresa?idEmp=" + idEmp, true);
    xmlhttp.send();
    
    return false;
}