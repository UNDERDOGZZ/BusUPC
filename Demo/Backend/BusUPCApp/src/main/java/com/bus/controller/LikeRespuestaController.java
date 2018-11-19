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

import com.bus.entities.LikeRespuesta;
import com.bus.service.LikeRespuestaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/likerespuestas")
@Api(value = "REST información de likes de respuestas")
public class LikeRespuestaController {

	@Autowired
	private LikeRespuestaService likeAnswerService;

	@ApiOperation("Lista de likes de preguntas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LikeRespuesta>> fetchStudents() {
		try {
			List<LikeRespuesta> likes = new ArrayList<>();
			likes = likeAnswerService.findAll();
			return new ResponseEntity<List<LikeRespuesta>>(likes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<LikeRespuesta>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener like por id de preguntas")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LikeRespuesta> fetchStudent(@PathVariable("id") Integer id) {

		try {
			Optional<LikeRespuesta> like = likeAnswerService.findById(id);

			if (!like.isPresent()) {
				return new ResponseEntity<LikeRespuesta>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<LikeRespuesta>(like.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LikeRespuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Guardar like de preguntas")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody LikeRespuesta like) {
		try {
			LikeRespuesta s = new LikeRespuesta();
			s = likeAnswerService.save(like);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Actualizar likes de preguntas")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody LikeRespuesta like) {
		try {
			likeAnswerService.update(like);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Borrar like de preguntas")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<LikeRespuesta> like = likeAnswerService.findById(id);

			if (!like.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				likeAnswerService.deleteById(id);
				return new ResponseEntity<>("Signo se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener like por id de preguntas y estudiantes")
	@GetMapping(value = "/answer/{ansId}/student/{studId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LikeRespuesta> fetchLikeQuestionsById(@PathVariable("ansId") int ansId, @PathVariable("studId") int studId) {

		try {
			Optional<LikeRespuesta> like = likeAnswerService.fetchLikeByAnswersAndStudents(ansId, studId);
			if (!like.isPresent()) {
				return new ResponseEntity<LikeRespuesta>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<LikeRespuesta>(like.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LikeRespuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Eliminar todos los likes por id")
	@DeleteMapping(value ="/answer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteAllLikesById(@PathVariable("id") int id) {
		try {
			likeAnswerService.deleteInBulk(id);
			return new ResponseEntity<>("Likes eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
