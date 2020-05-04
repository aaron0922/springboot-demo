package com.aaron.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.aaron.demo.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

//    @GetMapping(value = "/products/{id}")
//    public Product getProduct(@PathVariable("id") String id) {
//        Product product = new Product();
//        product.setId(id);
//        product.setName("Horror Movie Episode " + id);
//
//        return product;
//    }

    private List<Product> productDB = new ArrayList<>();

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
        Product product0 = new Product();
        product0.setId("111");
        product0.setName("hello");
        productDB.add(product0);

        Optional<Product> productOp = productDB.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

System.out.println(productOp);

        if (productOp.isPresent()) {
            Product product = productOp.get();
            return ResponseEntity.ok().body(product);
        }

        return ResponseEntity.notFound().build();
    }
}

