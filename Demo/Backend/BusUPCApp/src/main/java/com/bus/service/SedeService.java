package com.bus.service;

import java.util.List;

import com.bus.entities.Sede;

public interface SedeService extends CrudService<Sede> {
	List<Sede> findByNombre(String nombre) throws Exception;
}
