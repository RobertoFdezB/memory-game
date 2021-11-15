package com.prueba.aplicacion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.prueba.aplicacion.domain.entity.Jugador;
import com.prueba.aplicacion.vo.RankingVO;

@Mapper
public interface JugadorMapper {

	Jugador findById(long id);
	
//	@Select("select * from jugador")
	List<Jugador> getAll();

	Jugador insert(Jugador entity);
	
	Jugador update(Jugador entity);

	void delete(Jugador entity);
	
	void deleteById(Long id);
	
	void deleteAll();

	List<RankingVO> obtenerRanking();
}