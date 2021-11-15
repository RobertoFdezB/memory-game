package com.prueba.aplicacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.aplicacion.domain.entity.Partida;

@Service
public interface PartidaService extends SimpleServiceManager<Partida, Long> {

	public Partida findById(Long id);

	public List<Partida> getAll();
	
	public Partida insert(Partida entity);

	public Partida update(Partida entity);

	public void delete(Partida entity);
	
	public void deleteById(Long id);
	
	public void deleteAll();
}
