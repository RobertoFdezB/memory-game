package com.prueba.aplicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.aplicacion.domain.entity.Jugador;
import com.prueba.aplicacion.service.JugadorService;
import com.prueba.aplicacion.vo.RankingVO;

@RestController
@RequestMapping("/api")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;    
    
    @GetMapping("/jugadores")
	public ResponseEntity<List<Jugador>> getAllJugadores() {
		try {
			List<Jugador> jugadores = jugadorService.getAll();

			if (jugadores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(jugadores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/jugador/{id}")
	public ResponseEntity<Jugador> getJugadorById(@PathVariable("id") long id) {
		Jugador jugador = jugadorService.findById(id);

		if (jugador != null) {
			return new ResponseEntity<>(jugador, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/createJugador")
	public ResponseEntity<Jugador> createJugador(@RequestBody Jugador jugador) {
		try {
			Jugador jugadorCreate = jugadorService.insert(new Jugador(jugador.getNombre(), jugador.getEquipo()));
			return new ResponseEntity<>(jugadorCreate, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateJugador/{id}")
	public ResponseEntity<Jugador> updateJugador(@PathVariable("id") long id, @RequestBody Jugador jugador) {
		Jugador jugadorData = jugadorService.findById(id);

		if (jugadorData != null) {
			Jugador jugadorUpdate = jugadorData;
			jugadorUpdate.setNombre(jugador.getNombre());
			jugadorUpdate.setEquipo(jugador.getEquipo());
			return new ResponseEntity<>(jugadorService.update(jugadorUpdate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteJugador")
	public ResponseEntity<HttpStatus> deleteJugador(@RequestBody Jugador jugador) {
		try {
			jugadorService.delete(jugador);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteJugador/{id}")
	public ResponseEntity<HttpStatus> deleteJugadorById(@PathVariable("id") long id) {
		try {
			jugadorService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteJugadores")
	public ResponseEntity<HttpStatus> deleteAllJugadores() {
		try {
			jugadorService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
    @GetMapping("/ranking")
	public ResponseEntity<List<RankingVO>> obtenerRanking() {
		try {
			List<RankingVO> ranking = jugadorService.obtenerRanking();

			if (ranking.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(ranking, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
