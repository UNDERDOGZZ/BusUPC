package com.bus.service;

import java.util.List;

import com.bus.entities.Cliente;

public interface ClienteService extends CrudService<Cliente>{
	List<Cliente> findByNombre(String nombre) throws Exception;
}
