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

import com.prueba.aplicacion.domain.entity.Partida;
import com.prueba.aplicacion.service.PartidaService;

@RestController
@RequestMapping("/api")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;    
    
    @GetMapping("/partidas")
	public ResponseEntity<List<Partida>> getAllPartidas() {
		try {
			List<Partida> partidas = partidaService.getAll();

			if (partidas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(partidas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/partida/{id}")
	public ResponseEntity<Partida> getPartidaById(@PathVariable("id") long id) {
		Partida partida = partidaService.findById(id);

		if (partida != null) {
			return new ResponseEntity<>(partida, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/createPartida")
	public ResponseEntity<Partida> createPartida(@RequestBody Partida partida) {
		try {
			Partida partidaCreate = partidaService.insert(new Partida(partida.getMovimientos(), partida.getTiempo()));
			return new ResponseEntity<>(partidaCreate, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatePartida/{id}")
	public ResponseEntity<Partida> updatePartida(@PathVariable("id") long id, @RequestBody Partida partida) {
		Partida partidaData = partidaService.findById(id);

		if (partidaData != null) {
			Partida partidaUpdate = partidaData;
			partidaUpdate.setMovimientos(partida.getMovimientos());
			partidaUpdate.setTiempo(partida.getTiempo());
			partidaUpdate.setJugador(partida.getJugador());
			return new ResponseEntity<>(partidaService.update(partidaUpdate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletePartida")
	public ResponseEntity<HttpStatus> deletePartida(@RequestBody Partida partida) {
		try {
			partidaService.delete(partida);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deletePartida/{id}")
	public ResponseEntity<HttpStatus> deletePartidaById(@PathVariable("id") long id) {
		try {
			partidaService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletePartidas")
	public ResponseEntity<HttpStatus> deleteAllPartidas() {
		try {
			partidaService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}