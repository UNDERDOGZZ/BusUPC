package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.entities.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNombre(String nombre);
}
