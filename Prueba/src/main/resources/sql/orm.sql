select top 10 jugador.nombre, jugador.equipo, partida.movimientos, partida.tiempo
from jugador
inner join partida
where partida.jugador_id = jugador.id
order by partida.movimientos, partida.tiempo