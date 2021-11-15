package com.prueba.aplicacion.domain;

import java.io.Serializable;

public interface DomainEntity<ID extends Serializable> extends Serializable{
	
	ID getId();
}