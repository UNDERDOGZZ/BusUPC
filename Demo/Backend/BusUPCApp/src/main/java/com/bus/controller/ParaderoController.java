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

import com.bus.entities.Paradero;
import com.bus.service.ParaderoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/paraderos")
@Api(value="REST informacion de paraderos")
public class ParaderoController {
	
	@Autowired
	private ParaderoService paraderoService;

	@ApiOperation("Resgistro de paraderos")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveParadero(@Valid @RequestBody Paradero paradero)
	{
		try {
			Paradero par = new Paradero();
			par = paraderoService.save(paradero);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(par.getId()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation("Listado de paraderos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Paradero>> fetchParaderos(){
		try {
			List<Paradero> paraderos = new ArrayList<>();
			paraderos= paraderoService.findAll();
			return new ResponseEntity<List<Paradero>>(paraderos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Paradero>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener paradero por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paradero> fetchParadero(@PathVariable("id") Integer id) {

		try {
			Optional<Paradero> paradero = paraderoService.findById(id);

			if (!paradero.isPresent()) {
				return new ResponseEntity<Paradero>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Paradero>(paradero.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Paradero>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar paradero")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Paradero paradero) {
		try {
			paraderoService.update(paradero);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar paradero por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Paradero> paradero = paraderoService.findById(id);

			if (!paradero.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				paraderoService.deleteById(id);
				return new ResponseEntity<>("Paradero se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
