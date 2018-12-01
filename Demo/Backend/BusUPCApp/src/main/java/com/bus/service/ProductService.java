package com.bus.service;

import java.time.LocalDate;
import java.util.List;

import com.bus.entities.Product;

public interface ProductService extends CrudService<Product> {
	List<Product> findByDateBetween(LocalDate startDate, LocalDate endDate)throws Exception;
}
