package com.prueba.aplicacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.aplicacion.domain.entity.Jugador;
import com.prueba.aplicacion.vo.RankingVO;

@Service
public interface JugadorService extends SimpleServiceManager<Jugador, Long> {

	public Jugador findById(Long id);

	public List<Jugador> getAll();
	
	public Jugador insert(Jugador entity);

	public Jugador update(Jugador entity);

	public void delete(Jugador entity);
	
	public void deleteById(Long id);
	
	public void deleteAll();
	
	public List<RankingVO> obtenerRanking();

}
