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


import com.bus.entities.Horario;
import com.bus.service.HorarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/horarios")
@Api(value="REST informacion de horarios")

public class HorarioController {

	@Autowired
	private HorarioService horarioService;
	
	@ApiOperation("Registro de horarios")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveHorario(@Valid @RequestBody Horario horario)
	{
		try {
			Horario hor = new Horario();
			hor= horarioService.save(horario);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hor.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@ApiOperation("Listado de horarios")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Horario>> fetchHorarios(){
		try {
			List<Horario> horarios = new ArrayList<>();
			horarios= horarioService.findAll();
			return new ResponseEntity<List<Horario>>(horarios,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Horario>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener horario por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Horario> fetchHorario(@PathVariable("id") Integer id) {

		try {
			Optional<Horario> hor = horarioService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<Horario>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Horario>(hor.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Horario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar horario")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Horario horario) {
		try {
			horarioService.update(horario);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar horario por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Horario> hor = horarioService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				horarioService.deleteById(id);
				return new ResponseEntity<>("Horario se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
