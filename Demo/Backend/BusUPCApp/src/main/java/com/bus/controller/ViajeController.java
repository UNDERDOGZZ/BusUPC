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

import com.bus.entities.Viaje;
import com.bus.service.ViajeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/viajes")
@Api(value="REST informacion de viajes")
public class ViajeController {

	@Autowired
	private ViajeService viajeService;
	
	@ApiOperation("Registro de viajes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveViaje(@Valid @RequestBody Viaje viaje) {
		try {
			Viaje via = new Viaje();
			via = viajeService.save(viaje);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(via.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Listado de viajes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Viaje>> fetchViajes() {
		try {
			List<Viaje> viajes = new ArrayList<>();
			viajes = viajeService.findAll();
			return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Viaje>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Actualizar viaje")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Viaje viaje) {
		try {
			viajeService.update(viaje);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation("Eliminar viaje por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Viaje> viaje = viajeService.findById(id);

			if (!viaje.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				viajeService.deleteById(id);
				return new ResponseEntity<>("Viaje se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation("Obtener tarjeta por id")
	@GetMapping(value = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Viaje> fetchViaje(@PathVariable("id") Integer id) {

		try {
			Optional<Viaje> viaje = viajeService.findById(id);

			if (!viaje.isPresent()) {
				return new ResponseEntity<Viaje>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Viaje>(viaje.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Viaje>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
