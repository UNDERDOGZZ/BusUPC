package com.bus.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.bus.entities.Tarjeta;
import com.bus.service.TarjetaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tarjetas")
@Api(value="REST informacion de tarjetas")
public class TarjetaController {
	
	@Autowired
	private TarjetaService tarjetaService;
	
	@ApiOperation("Registro de tarjetas")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveTarjeta(@Valid @RequestBody Tarjeta tarjeta) {
		try {
			Tarjeta tar = new Tarjeta();
			tar = tarjetaService.save(tarjeta);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tar.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Listado de tarjetas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tarjeta>> fetchTarjetas() {
		try {
			List<Tarjeta> tarjetas = new ArrayList<>();
			tarjetas = tarjetaService.findAll();
			return new ResponseEntity<List<Tarjeta>>(tarjetas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Tarjeta>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Actualizar tarjeta")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Tarjeta tarjeta) {
		try {
			tarjetaService.update(tarjeta);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation("Eliminar tarjeta por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Tarjeta> tarjeta = tarjetaService.findById(id);

			if (!tarjeta.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				tarjetaService.deleteById(id);
				return new ResponseEntity<>("Tarjeta se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation("Obtener tarjeta por id")
	@GetMapping(value = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tarjeta> fetchTarjeta(@PathVariable("id") Integer id) {

		try {
			Optional<Tarjeta> tarjeta = tarjetaService.findById(id);

			if (!tarjeta.isPresent()) {
				return new ResponseEntity<Tarjeta>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Tarjeta>(tarjeta.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Tarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
