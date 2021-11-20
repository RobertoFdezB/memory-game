package com.prueba.aplicacion.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.aplicacion.domain.entity.Jugador;
import com.prueba.aplicacion.mapper.JugadorMapper;
import com.prueba.aplicacion.service.JugadorService;
import com.prueba.aplicacion.vo.RankingVO;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	private JugadorMapper jugadorMapper;

	@Override
	public Jugador findById(Long id) {
		return jugadorMapper.findById(id);
		
	}

	@Override
	public List<Jugador> getAll() {
		List<Jugador> jugadorList = new ArrayList<>();

		try {
			jugadorList = jugadorMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return jugadorList;
		}
		return jugadorList;
	}

	@Override
	public Jugador insert(Jugador entity) {
		return jugadorMapper.insert(entity);
	}

	@Override
	public Jugador update(Jugador entity) {
		return jugadorMapper.update(entity);
	}

	@Override
	public void delete(Jugador entity) {
		jugadorMapper.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		jugadorMapper.deleteById(id);
	}

	@Override
	public void deleteAll() {
		jugadorMapper.deleteAll();
	}

	@Override
	public List<RankingVO> obtenerRanking() {
		List<RankingVO> rankingSinOrdenar = jugadorMapper.obtenerRanking();

		return rankingSinOrdenar.stream()
				.sorted(Comparator.comparingInt(RankingVO::getMovimientos).thenComparing(RankingVO::getTiempo))
				.collect(Collectors.toList());
	}

}
