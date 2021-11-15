package com.prueba.aplicacion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.aplicacion.domain.entity.Partida;
import com.prueba.aplicacion.mapper.PartidaMapper;
import com.prueba.aplicacion.service.PartidaService;

@Service
public class PartidaServiceImpl implements PartidaService {

	@Autowired
	private PartidaMapper partidaMapper;

	@Override
	public Partida findById(Long id) {
		return partidaMapper.findById(id);
	}

	@Override
	public List<Partida> getAll() {
		List<Partida> partidaList = new ArrayList<>();

		try {
			partidaList = partidaMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return partidaList;
		}
		return partidaList;
	}

	@Override
	public Partida insert(Partida entity) {
		return partidaMapper.insert(entity);
	}

	@Override
	public Partida update(Partida entity) {
		return partidaMapper.update(entity);
	}

	@Override
	public void delete(Partida entity) {
		partidaMapper.delete(entity);
	}
	

	@Override
	public void deleteById(Long id) {
		partidaMapper.deleteById(id);
	}

	@Override
	public void deleteAll() {
		partidaMapper.deleteAll();
	}
}
