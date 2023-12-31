package com.example.testlinktic;

import com.example.testlinktic.model.Product;
import com.example.testlinktic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class TestLinkticController {

        @Autowired
        private ProductRepository productRepository;

        @GetMapping("/products")
        public ResponseEntity<List<Product>> getAllProducts() {
            try {
                List<Product> products = new ArrayList<>(productRepository.findAll());
                if (products.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(products, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        @GetMapping("/product/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
            try {
                Optional<Product> productData = productRepository.findById(id);
                return productData.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        @PostMapping("/create")
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {
            try {
                Product productObj = new Product();
                productObj.setName(product.getName());
                productObj.setDescription(product.getDescription());
                productObj.setPrice(product.getPrice());
                productRepository.save(productObj);

                return new ResponseEntity<>(productObj, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping("/update/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
            try {
                Optional<Product> productData = productRepository.findById(id);
                if (productData.isPresent()) {
                    Product productObj = productData.get();
                    productObj.setName(product.getName());
                    productObj.setDescription(product.getDescription());
                    productObj.setPrice(product.getPrice());
                    productRepository.save(productObj);

                    return new ResponseEntity<>(productObj, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
            try {
                productRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

}
