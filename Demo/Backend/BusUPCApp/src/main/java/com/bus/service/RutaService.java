package com.bus.service;

import java.util.List;

import com.bus.entities.Ruta;

public interface RutaService extends CrudService<Ruta>{

	List<Ruta> fetchByOrigenAndDestino(String origen, String destino) throws Exception;
}
