package com.bus.service;

import java.util.List;

import com.bus.entities.Horario;

public interface HorarioService extends CrudService<Horario> {

	List<Horario> fetchByRutaId(int id)throws Exception;
}
