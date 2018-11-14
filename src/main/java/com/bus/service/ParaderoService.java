package com.bus.service;

import java.util.List;

import com.bus.entities.Paradero;

public interface ParaderoService extends CrudService<Paradero> {

	List<Paradero> fetchByRutaId(int rutaId)throws Exception;
}
