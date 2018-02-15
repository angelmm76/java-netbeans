/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Funciones que se ejecutarán al pulsar los distintos botones
function dosetitem(){
    // Tomar datos del input, guardarlos y mostrarlos en tabla
    var producto = document.getElementById("prod").value;
    //var producto = document.getElementById("listaf").value;
    var data = document.getElementById("q").value;
    localStorage.setItem(producto, data);
    document.getElementById("prod").value = "";
    document.getElementById("q").value = "";
    show();
}
function dogetitem() {
    // Tomar producto del input y mostrar su cantidad
    var producto = document.getElementById("prod").value;
    itemp = localStorage.getItem(producto);
    //alert(item);
    if(itemp === null){
        alert("El producto " + producto + " no está en la lista");
    }
    else {
        document.getElementById("q").value = itemp;
        show();
    }
}
function doremoveitem() {
    // Tomar producto del input y eliminarlo de la tabla
   var producto = document.getElementById("prod").value;
   //alert(producto);
   localStorage.removeItem(producto);
   document.getElementById("prod").value = "";
   document.getElementById("q").value = "";
   show();
}
function doclear() {
    // Borrar toda la tabla
    localStorage.clear();
    show();
}
function show() {
    // Mostrar tabla y rellenar opciones del select
    var key = "";
    var selitems = ""; // opciones de select
    // Cabecera de tabla
    var pairs = "<tr class=\"first\"><td><b>Producto</b></td>\n\
        <td><b>Cantidad</b></td></tr>";
    var i = 0;
    // Bucle sobre elementos de la tabla
    for(i = 0; i < localStorage.length; i++){
        key = localStorage.key(i); // clave
        item = localStorage.getItem(key); // valor
        pairs += "<tr><td>" + key + "</td><td>"+ item +"</td></tr>"; // fila
        selitems += "<option value=" + key + ">" + key + "</option>"; // option
    }
    // Si no hay valores guardados mostrar una fila vacía
    if(i === 0){
        pairs += "<tr><td>---</td><td>---</td></tr>";
    }
    // Pasar contenido a la table "pairs" de index.html
    document.getElementById("pairs").innerHTML = pairs;
    // Agregar opciones al select
    document.getElementById("seleccion").innerHTML = selitems;
}
function setfromlist(){
    //alert("hi");
    var produ = document.getElementById("seleccion").value;
    document.getElementById("prod").value = produ;
    document.getElementById("q").value = localStorage.getItem(produ);
}
function load(){
    // Show first product en los inputs
    var produ0 = localStorage.key(0);
    document.getElementById("prod").value = produ0;
    document.getElementById("q").value = 
            localStorage.getItem(produ0); 
    show();
}
function testJS (){
    alert('JS works!');
}
