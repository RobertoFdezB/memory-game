package com.prueba.aplicacion.domain.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.prueba.aplicacion.domain.DomainEntity;

public class Partida implements DomainEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date fecha;

	private Integer movimientos;

	private LocalTime tiempo;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=Jugador.class)
	@JoinColumn(name="jugador_id")
	private Jugador jugador;

	public Partida(Date fecha, Integer movimientos, LocalTime tiempo, Jugador jugador) {
		super();
		this.fecha = fecha;
		this.movimientos = movimientos;
		this.tiempo = tiempo;
		this.jugador = jugador;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the movimientos
	 */
	public Integer getMovimientos() {
		return movimientos;
	}

	/**
	 * @param movimientos the movimientos to set
	 */
	public void setMovimientos(Integer movimientos) {
		this.movimientos = movimientos;
	}

	/**
	 * @return the tiempo
	 */
	public LocalTime getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(LocalTime tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * @return the jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}