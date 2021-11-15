package com.prueba.aplicacion.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.prueba.aplicacion.domain.DomainEntity;

public class Jugador implements DomainEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private String equipo;

	@OneToMany(targetEntity=Partida.class, mappedBy = "jugador", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
