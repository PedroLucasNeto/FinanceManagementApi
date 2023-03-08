package com.financemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financemanagement.model.Product;
import com.financemanagement.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public boolean createProduct(Product product) {

		if (product != null) {
			productRepository.save(product);
			return true;
		}
		return false;
	}

	public void deleteProduct(Long id) throws Exception {
		Product deleteProduct = productRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Product with this ID: " + id));
		productRepository.delete(deleteProduct);
	}

	public Product updateProduct(Long id, Product product) throws Exception {
		Product updatedProduct = productRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Product with this ID: " + id));
		updatedProduct.setDescription(product.getDescription());
		updatedProduct.setPrice(product.getPrice());

		productRepository.save(updatedProduct);
		return updatedProduct;
	}

	public Iterable<Product> listProducts() {
		Iterable<Product> listProducts = productRepository.findAll();
		return listProducts;
	}

	public Iterable<Product> findByName(String description) {
		Iterable<Product> products = productRepository.findByDescription(description);
		return products;
	}

	public Product findById(Long id) throws Exception {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Product with this ID: " + id));
		return product;
	}

}
