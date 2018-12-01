package com.bus.controller;

import java.net.URI;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

import com.bus.entities.Product;
import com.bus.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productos")
@Api(value = "REST informacion de productos")
public class ProductController {

	@Autowired
	private ProductService productService;

	@ApiOperation("Registro de product")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveproduct(@Valid @RequestBody Product product) {
		try {
			Product prod = new Product();
			prod = productService.save(product);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prod.getId())
					.toUri();

			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@ApiOperation("Listado de product")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> fetchHorarios() {
		try {
			List<Product> products = new ArrayList<>();
			products = productService.findAll();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener estudiante por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> fetchStudent(@PathVariable("id") Integer id) {

		try {
			Optional<Product> product = productService.findById(id);

			if (!product.isPresent()) {
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar product")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Product product) {
		try {
			productService.update(product);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar product por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Product> product = productService.findById(id);

			if (!product.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				productService.deleteById(id);
				return new ResponseEntity<>("product se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Obtener product por fechaInicio y FechaFin")
	@GetMapping(value = "/search/{fechaInicio}/{FechaFin}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findByDateBetween(@DateTimeFormat(iso = ISO.DATE) @PathVariable("fechaInicio") LocalDate fechaInicio, @DateTimeFormat(iso = ISO.DATE)
			@PathVariable("FechaFin") LocalDate FechaFin) {

		try {
			List<Product> products = new ArrayList<>();
			products = productService.findByDateBetween(fechaInicio, FechaFin);
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
