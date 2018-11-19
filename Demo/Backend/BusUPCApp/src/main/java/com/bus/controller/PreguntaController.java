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

import com.bus.entities.Pregunta;
import com.bus.service.PreguntaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/preguntas")
@Api(value = "REST información de preguntas")
public class PreguntaController {

	@Autowired
	private PreguntaService questionService;

	@ApiOperation("Lista de preguntas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pregunta>> fetchQuestions() {
		try {
			List<Pregunta> questions = new ArrayList<>();
			questions = questionService.findAll();
			return new ResponseEntity<List<Pregunta>>(questions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Pregunta>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Lista de preguntas ordenados")
	@GetMapping(value = "/ordered", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pregunta>> fetchQuestionsOrdered() {
		try {
			List<Pregunta> questions = new ArrayList<>();
			questions = questionService.fetchAllOrderByRating();
			return new ResponseEntity<List<Pregunta>>(questions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Pregunta>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener preguntas por texto")
	@GetMapping(value = "/search/{text}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pregunta>> fetchByText(@PathVariable("text") String text) {
		try {
			List<Pregunta> questions = new ArrayList<>();
			questions = questionService.fetchByText(text);
			return new ResponseEntity<List<Pregunta>>(questions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Pregunta>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Registro de preguntas")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveQuestion(@Valid @RequestBody Pregunta patient) {
		try {
			Pregunta que = new Pregunta();
			que = questionService.save(patient);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar datos de preguntas")
	@PutMapping(value = "/up/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateQuestion(@Valid @RequestBody Pregunta question) {
		try {
			questionService.update(question);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Eliminar pregunta por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteQuestion(@PathVariable("id") Integer id) {

		try {
			Optional<Pregunta> question = questionService.findById(id);

			if (!question.isPresent()) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			} else {
				questionService.deleteById(id);
				return new ResponseEntity<>("Paciente se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
