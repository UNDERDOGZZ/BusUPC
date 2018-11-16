package com.bus.service;

import java.util.List;

import com.bus.entities.Sede;

public interface SedeService extends CrudService<Sede> {
	List<Sede> findByName(String name) throws Exception;
}
