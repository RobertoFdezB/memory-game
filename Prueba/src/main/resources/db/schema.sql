DROP TABLE IF EXISTS jugador;
create table jugador
(
	id IDENTITY NOT NULL PRIMARY KEY,
	nombre VARCHAR(255) NOT NULL,
	equipo VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS partida;
create table partida
(
	id IDENTITY NOT NULL PRIMARY KEY,
	movimientos INT NOT NULL,
	tiempo TIME NOT NULL,
	jugador_id INT8
);

ALTER TABLE partida ADD CONSTRAINT FK_PARTIDA_JUGADOR FOREIGN KEY (jugador_id) REFERENCES jugador(id) ON DELETE CASCADE;