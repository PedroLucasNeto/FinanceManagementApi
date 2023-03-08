package com.financemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanagement.model.Product;
import com.financemanagement.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping
	ResponseEntity<Product> createProduct(@RequestBody Product product) {
		boolean success = productService.createProduct(product);
		if (success) {
			return new ResponseEntity<Product>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping 
	ResponseEntity<Product> deleteProduct(@PathVariable Long id) throws Exception {
		productService.deleteProduct(id);
			return new ResponseEntity<Product>(HttpStatus.OK);
	}

	@PutMapping("/{id}") 
	ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
		productService.updateProduct(id, product);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity <Iterable<Product>> listProducts(){
		Iterable<Product> listProducts = productService.listProducts();
		return new ResponseEntity<Iterable<Product>>(listProducts, HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	ResponseEntity<Iterable<Product>> getProductByName(@PathVariable String name){
		List<Product> products = (List<Product>) productService.findByName(name);
		if (products.isEmpty()) {
			return new ResponseEntity<Iterable<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	ResponseEntity<Product> getProductById(@PathVariable Long id) throws Exception{
		Product product = productService.findById(id);
		if (product.equals(null)) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}