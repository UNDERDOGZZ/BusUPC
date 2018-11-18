package com.faq.controller;

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

import com.faq.entities.Answer;
import com.faq.service.AnswerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/answers")
@Api(value = "REST información de respuestas")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@ApiOperation("Lista de respuestas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Answer>> fetchAnswers() {
		try {
			List<Answer> answers = new ArrayList<>();
			answers = answerService.findAll();
			return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Answer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Lista de respuestas ordenada")
	@GetMapping(value = "/ordered", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Answer>> fetchAnswersOrdered() {
		try {
			List<Answer> answers = new ArrayList<>();
			answers = answerService.fetchAllOrderByRating();
			return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Answer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Lista de respuesta por pregunta id")
	@GetMapping(value = "/question/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Answer>> fetchAnswersByQuestionId(@PathVariable("id") Integer id) {
		try {
			List<Answer> answers = new ArrayList<>();
			answers = answerService.fetchByQuestionID(id);
			return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Answer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Guardar preguntas")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Answer answer) {
		try {
			Answer a = new Answer();
			a = answerService.save(answer);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Actualizar preguntas")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Answer answer) {
		try {
			answerService.update(answer);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar preguntas")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Answer> answer = answerService.findById(id);

			if (!answer.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				answerService.deleteById(id);
				return new ResponseEntity<>("Comentario se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation("Eliminar todos las respuestas por id")
	@DeleteMapping(value ="/question/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteAllLikesById(@PathVariable("id") int id) {
		try {
			answerService.deleteInBulk(id);
			return new ResponseEntity<>("Respuestas eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
