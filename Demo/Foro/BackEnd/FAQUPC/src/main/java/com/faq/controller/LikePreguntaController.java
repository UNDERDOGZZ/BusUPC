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

import com.faq.entities.LikePregunta;
import com.faq.service.LikePreguntaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/likepreguntas")
@Api(value = "REST información de likes")
public class LikePreguntaController {

	@Autowired
	private LikePreguntaService likeQuestionService;

	@ApiOperation("Lista de likes de preguntas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LikePregunta>> fetchLikeQuestions() {
		try {
			List<LikePregunta> likes = new ArrayList<>();
			likes = likeQuestionService.findAll();
			return new ResponseEntity<List<LikePregunta>>(likes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<LikePregunta>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener like por id de preguntas")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LikePregunta> fetchLikeQuestion(@PathVariable("id") Integer id) {

		try {
			Optional<LikePregunta> like = likeQuestionService.findById(id);

			if (!like.isPresent()) {
				return new ResponseEntity<LikePregunta>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<LikePregunta>(like.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LikePregunta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Guardar like de preguntas")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody LikePregunta like) {
		try {
			LikePregunta s = new LikePregunta();
			s = likeQuestionService.save(like);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Actualizar likes de preguntas")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody LikePregunta like) {
		try {
			likeQuestionService.update(like);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Borrar like de preguntas")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<LikePregunta> like = likeQuestionService.findById(id);

			if (!like.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				likeQuestionService.deleteById(id);
				return new ResponseEntity<>("Like se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation("Obtener like por id de preguntas y estudiantes")
	@GetMapping(value = "/question/{questId}/student/{studId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LikePregunta> fetchLikeQuestionsById(@PathVariable("questId") int questId,@PathVariable("studId") int studId) {

		try {
			Optional<LikePregunta> like = likeQuestionService.fetchLikeByQuestionsAndStudents(questId, studId);
			if (!like.isPresent()) {
				return new ResponseEntity<LikePregunta>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<LikePregunta>(like.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LikePregunta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Eliminar todos los liks por id")
	@DeleteMapping(value ="/question/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteAllLikesById(@PathVariable("id") int id) {
		try {
			likeQuestionService.deleteInBulk(id);
			return new ResponseEntity<>("Likes eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
