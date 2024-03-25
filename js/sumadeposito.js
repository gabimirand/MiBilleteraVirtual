/* Validar e ingresar monto */ 

document.addEventListener('submit', function(Event) {
 Event.preventDefault();

var monto = document.getElementById('montodeposito').value;


if (monto >0 ) {
    alert('¿Estás seguro del depósito?');
    window.location.href = "menu.html";
} else {
    alert('El monto mínimo para depositar es $1');
}}); 

