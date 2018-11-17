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

import com.bus.entities.Ruta;
import com.bus.service.RutaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rutas")
@Api(value="REST informacion de rutas")
public class RutasController {

	@Autowired
	private RutaService rutaService;
	
	@ApiOperation("Registro de rutas")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveRuta(@Valid @RequestBody Ruta ruta)
	{
		try {
			Ruta rut = new Ruta();
			rut = rutaService.save(ruta);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rut.getId()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@ApiOperation("Listado de rutas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ruta>> fetchRutas(){
		try {
			List<Ruta> rutas = new ArrayList<>();
			rutas= rutaService.findAll();
			return new ResponseEntity<List<Ruta>>(rutas,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Ruta>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener ruta por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ruta> fetchRuta(@PathVariable("id") Integer id) {

		try {
			Optional<Ruta> ruta = rutaService.findById(id);

			if (!ruta.isPresent()) {
				return new ResponseEntity<Ruta>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Ruta>(ruta.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Ruta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar ruta")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Ruta ruta) {
		try {
			rutaService.update(ruta);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar ruta por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Ruta> ruta = rutaService.findById(id);

			if (!ruta.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				rutaService.deleteById(id);
				return new ResponseEntity<>("Ruta se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
