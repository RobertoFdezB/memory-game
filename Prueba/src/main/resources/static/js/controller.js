app.controller('juegoController', [ '$scope', '$http',
                                     
	function($scope, $http) {
	
	var cartas = new Array( 
	  {nombre: '1', seleccion: false}, {nombre: '2', seleccion: false}, 
	  {nombre: '3', seleccion: false}, {nombre: '4', seleccion: false}, 
	  {nombre: '5', seleccion: false}, {nombre: '6', seleccion: false}, 
	  {nombre: '7', seleccion: false}, {nombre: '8', seleccion: false}, 
	  {nombre: '1', seleccion: false}, {nombre: '2', seleccion: false}, 
	  {nombre: '3', seleccion: false}, {nombre: '4', seleccion: false}, 
	  {nombre: '5', seleccion: false}, {nombre: '6', seleccion: false}, 
	  {nombre: '7', seleccion: false}, {nombre: '8', seleccion: false} );
	    
		var intentos = 0;
		var jugada1 = "";
		var jugada2 = "";
		var identificadorJ1 = "";
		var identificadorJ2 = "";
	
		$scope.iniciarPartida() = function() {
		  var dato = document.getElementById("juego");
		  dato.style.opacity = 1;
		
		  cartas.sort(function() {return Math.random() - 0.5});
		  for ( var i = 0 ; i < 16 ; i++ ) {
		    var carta = cartas[i].nombre;
		    var dato = document.getElementById( i.toString() );
		    dato.dataset.valor = carta;
		  }
		}
		
		$scope.resetearJuego() = function() {
				cartas.sort(function() {return Math.random() - 0.5});
		  for ( var i = 0 ; i < 16 ; i++ ) {
		    var carta = cartas[i].nombre;
		    var dato = document.getElementById( i.toString() );
		    dato.dataset.valor = carta;
		    colorCambio( i, 'black', '?');
		  } 
		}
		
		$scope.girarCarta() = function() {
		  var evento = window.event;
		
		  jugada2 = evento.target.dataset.valor;
		  identificadorJ2 = evento.target.id;
		
		if(cartas[parseInt(identificadorJ2)].seleccion != true || cartas[parseInt(identificadorJ2)].seleccion != true){
		  if ( jugada1 !== "" ) {
		
		    if ( jugada1 === jugada2 && identificadorJ1 !== identificadorJ2 && cartas[parseInt(identificadorJ2)].seleccion != true &&               cartas[parseInt(identificadorJ1)].seleccion != true) {
		      
		      cartas[parseInt(identificadorJ1)].seleccion = true;
		      cartas[parseInt(identificadorJ2)].seleccion = true;
		
		      colorCambio(identificadorJ2, "blue", jugada2);
		      vaciar();
		      comprobar();
		    }else if(identificadorJ1 !== identificadorJ2){
		      var self = this;
		      setTimeout(function(){
		        colorCambio(self.identificadorJ1, "black", "?")
		        colorCambio(self.identificadorJ2, "black", "?")
		        vaciar()
		      },200); 
		
		      colorCambio(identificadorJ2, "blue", jugada2);
		    }
		  } else if(jugada2 !== "valor") {
		
		    colorCambio(identificadorJ2, "blue", jugada2);
		
		    jugada1 = jugada2;
		    identificadorJ1 = identificadorJ2;
		  }
		}
		
		$scope.vaciar() = function() {
			  jugada1 = ""; 
			  jugada2 = ""; 
			
			  identificadorJ1 = "";
			  identificadorJ2 = "";
		}
		
		$scope.colorCambio (posicion, color, contenido) = function() {
		  document.getElementById(posicion.toString()).style.backgroundColor = color;
		  document.getElementById(posicion.toString()).innerHTML = contenido;
		}
		
			$scope.vaciar() = function() {
				var aciertos = 0;
				  for( var i = 0 ; i < 16 ; i++ ){
				    if ( cartas[i].seleccion == true ) {
				      aciertos ++;
				    }
				
				  }
				
				  if(aciertos == 16){
				    document.getElementById("juego").innerHTML = "GANASTE";
					crearJugador();
				  }
			}
		}

		$scope.crearJugador = function() {
			$http.post('/createJugador', 
				{
					nombre : $scope.nombre,
					equipo : $scope.equipo
				}
			).success(function(data) {
				$scope.msg = 'Jugador creado correctamente';
			}).error(function(data) {
				$scope.msg = 'Se ha producido un error';
			});
		}
} ]);
