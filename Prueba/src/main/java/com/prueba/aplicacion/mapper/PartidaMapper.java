package com.prueba.aplicacion.mapper;
 
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
 
import com.prueba.aplicacion.model.Jugador;
 
@Mapper
public interface PartidaMapper {
	
	Jugador selectPartidaById(long idPartida);
}