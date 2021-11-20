package com.prueba.aplicacion.vo;

import java.sql.Time;

public class RankingVO {

	private String nombre;

	private String equipo;

	private Integer movimientos;

	private Time tiempo;

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
	public Time getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}

}
