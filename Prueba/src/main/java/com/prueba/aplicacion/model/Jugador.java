package com.prueba.aplicacion.model;

import java.io.Serializable;
import java.util.List;

public class Jugador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private String equipo;

	private List<Partida> partidas;

	public Jugador(String nombre, String equipo) {
		super();
		this.nombre = nombre;
		this.equipo = equipo;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the equipo
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	/**
	 * @return the partidas
	 */
	public List<Partida> getPartidas() {
		return partidas;
	}

	/**
	 * @param partidas the partidas to set
	 */
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

}
