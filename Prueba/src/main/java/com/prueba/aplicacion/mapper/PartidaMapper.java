package com.prueba.aplicacion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.prueba.aplicacion.domain.entity.Partida;

@Mapper
public interface PartidaMapper {

	Partida findById(long id);

	List<Partida> getAll();

	Partida insert(Partida entity);

	Partida update(Partida entity);

	void delete(Partida entity);
	
	void deleteById(Long id);
	
	void deleteAll();
}