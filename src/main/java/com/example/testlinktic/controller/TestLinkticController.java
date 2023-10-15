package com.example.testlinktic.controller;

import com.example.testlinktic.model.Product;
import com.example.testlinktic.repository.ProductRepository;
import com.example.testlinktic.service.TestLinkService;
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
        private TestLinkService testLinkService;

        @GetMapping("/get-products")
        public ResponseEntity<List<Product>> getAllProducts() {
          return testLinkService.getAllProducts();
        }

        @GetMapping("/get-product/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
           return testLinkService.getProductById(id);
        }

        @PostMapping("/create-product")
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {
            return testLinkService.createProduct(product);
        }

        @PostMapping("/update-product/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
          return testLinkService.updateProduct(id,product);
        }

        @DeleteMapping("/delete-product/{id}")
        public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
            return testLinkService.deleteProduct(id);
        }

}
