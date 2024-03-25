/* Validar e ingresar monto */ 
const deposito = document.getElementById('depositAmount');
const depositar= document.getElementById('depositar');            


document.addEventListener('submit', function(Event) {
 Event.preventDefault();

var deposito = document.getElementById('depositAmount').value;


if (deposito >0 ) {
    alert('¿Estás seguro del depósito?');
    window.location.href = "menu.html";
} else {
    alert('El monto mínimo para depositar es $1');
}}); 


