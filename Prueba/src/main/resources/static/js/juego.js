var cartas = new Array( 
  {nombre: '1', seleccion: false}, {nombre: '2', seleccion: false}, 
  {nombre: '3', seleccion: false}, {nombre: '4', seleccion: false}, 
  {nombre: '5', seleccion: false}, {nombre: '6', seleccion: false}, 
  {nombre: '7', seleccion: false}, {nombre: '8', seleccion: false}, 
  {nombre: '1', seleccion: false}, {nombre: '2', seleccion: false}, 
  {nombre: '3', seleccion: false}, {nombre: '4', seleccion: false}, 
  {nombre: '5', seleccion: false}, {nombre: '6', seleccion: false}, 
  {nombre: '7', seleccion: false}, {nombre: '8', seleccion: false} );
    
var movimientos = 0;
var jugada1 = "";
var jugada2 = "";
var identificadorJ1 = "";
var identificadorJ2 = "";

var fechaHoraIni = new Date().getTime();

var tiempo;

document.addEventListener("DOMContentLoaded", function(){
    iniciarJuego ();
	tiempo = setInterval(muestraReloj, 1000);
});


function iniciarJuego () {  
  var dato = document.getElementById("juego");
  dato.style.opacity = 1;

  cartas.sort(function() {return Math.random() - 0.5});
  for ( var i = 0 ; i < 16 ; i++ ) {
    var carta = cartas[i].nombre;
    var dato = document.getElementById( i.toString() );
    dato.dataset.valor = carta;
  }
};

function resetearJuego () {
  cartas.sort(function() {return Math.random() - 0.5});
  for ( var i = 0 ; i < 16 ; i++ ) {
    var carta = cartas[i].nombre;
    var dato = document.getElementById( i.toString() );
    dato.dataset.valor = carta;
    colorCambio( i, '#FAD7A0', '?');
  } 

  movimientos = 0;
  fechaHoraIni = new Date().getTime();
  document.getElementById("movimientos").innerHTML = movimientos;
}

function girarCarta () {
  var evento = window.event;

  jugada2 = evento.target.dataset.valor;
  identificadorJ2 = evento.target.id;

  if(cartas[parseInt(identificadorJ2)].seleccion != true || cartas[parseInt(identificadorJ2)].seleccion != true){
	  if ( jugada1 !== "" ) {
	
	    if ( jugada1 === jugada2 && identificadorJ1 !== identificadorJ2 && cartas[parseInt(identificadorJ2)].seleccion != true && cartas[parseInt(identificadorJ1)].seleccion != true) {
	      
	      cartas[parseInt(identificadorJ1)].seleccion = true;
	      cartas[parseInt(identificadorJ2)].seleccion = true;
	
		  movimientos++;
		  colorCambio(identificadorJ1, "#ABEBC6", jugada1);
	      colorCambio(identificadorJ2, "#ABEBC6", jugada2);
		  document.getElementById("movimientos").innerHTML = movimientos;
	      vaciar();
	      comprobar();
	    }else if(identificadorJ1 !== identificadorJ2){
	      var self = this;
		  movimientos++;
	      setTimeout(function(){
	        colorCambio(self.identificadorJ1, "#FAD7A0", "?")
	        colorCambio(self.identificadorJ2, "#FAD7A0", "?")
	        vaciar()
	      },200);
	      colorCambio(identificadorJ2, "#AED6F1", jugada2);
		  document.getElementById("movimientos").innerHTML = movimientos;
	    }
	  } else if(jugada2 !== "valor") {
	
	    colorCambio(identificadorJ2, "#AED6F1", jugada2);
	
	    jugada1 = jugada2;
	    identificadorJ1 = identificadorJ2;
	  }
  }
};

function vaciar ()  {
  jugada1 = ""; 
  jugada2 = ""; 

  identificadorJ1 = "";
  identificadorJ2 = "";
}

function colorCambio (posicion, color, contenido) {
  document.getElementById(posicion.toString()).style.backgroundColor = color;
  document.getElementById(posicion.toString()).innerHTML = contenido;
} 

function comprobar () {
  var aciertos = 0;
  for( var i = 0 ; i < 16 ; i++ ){
    if ( cartas[i].seleccion == true ) {
      aciertos ++;
    }
  }

  if(aciertos == 16){
 	clearInterval(tiempo);
	document.getElementById("ranking").submit();
  }
}

function muestraReloj() {
  var ahora = new Date().getTime();

  var diferencia = ahora - fechaHoraIni;

  var horas = Math.floor((diferencia % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutos = Math.floor((diferencia % (1000 * 60 * 60)) / (1000 * 60));
  var segundos = Math.floor((diferencia % (1000 * 60)) / 1000);

  if(horas < 10) { horas = '0' + horas; }
  if(minutos < 10) { minutos = '0' + minutos; }
  if(segundos < 10) { segundos = '0' + segundos; }

  document.getElementById("reloj").innerHTML = horas+':'+minutos+':'+segundos;
}