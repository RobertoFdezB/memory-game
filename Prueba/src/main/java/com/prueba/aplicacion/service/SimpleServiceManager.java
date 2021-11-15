package com.prueba.aplicacion.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.aplicacion.domain.DomainEntity;

/**
 * Interfaz del servicio genérico capaz de realizar las operaciones CRUD básicas sobre una entidad de dominio.
 * 
 * @author Rober
 *
 * @param <T>
 * @param <ID>
 */
@Service
public interface SimpleServiceManager<T extends DomainEntity<ID>, ID extends Serializable> {
	
	/**
	 * Busca un objeto persistente de tipo T cuyo id coincida con el dado
	 * 
	 * @param id
	 * @return
	 */
	T findById(ID id);
	
	/**
	 * Busca todos los objetos persistentes de tipo T
	 * 
	 * @return
	 */
	List<T> getAll();
	
	/**
	 * Inserta una entidad de tipo T
	 * 
	 * @param entity
	 * @return
	 */
	T insert(T entity);
	
	/**
	 * Modifica una entidad de tipo T
	 * 
	 * @param entity
	 * @return
	 */
	T update(T entity);
	
	/**
	 * Borra una entidad de tipo T
	 * 
	 * @param entity
	 */
	void delete(T entity);
	
	/**
	 * Borra un objeto persistente cuyo id coincida con el dado
	 * 
	 * @param id
	 */
	void deleteById(Long id);
	
	/**
	 * Borra todos los objetos persistentes
	 * 
	 */
	void deleteAll();
}
