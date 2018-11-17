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

import com.faq.entities.Question;
import com.faq.service.QuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/questions")
@Api(value = "REST información de preguntas")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@ApiOperation("Lista de preguntas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Question>> fetchQuestions() {
		try {
			List<Question> questions = new ArrayList<>();
			questions = questionService.findAll();
			return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Question>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Lista de preguntas ordenados")
	@GetMapping(value = "/ordered", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Question>> fetchQuestionsOrdered() {
		try {
			List<Question> questions = new ArrayList<>();
			questions = questionService.fetchAllOrderByRating();
			return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Question>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener preguntas por texto")
	@GetMapping(value = "/search/{text}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Question>> fetchByText(@PathVariable("text") String text) {
		try {
			List<Question> questions = new ArrayList<>();
			questions = questionService.fetchByText(text);
			return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Question>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Registro de preguntas")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveQuestion(@Valid @RequestBody Question patient) {
		try {
			Question que = new Question();
			que = questionService.save(patient);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar datos de preguntas")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateQuestion(@Valid @RequestBody Question question) {
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
			Optional<Question> question = questionService.findById(id);

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
