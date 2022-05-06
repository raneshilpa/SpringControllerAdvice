package com.example.springcontrolleradvice.controller;

import com.example.springcontrolleradvice.Service.ProductService;
import com.example.springcontrolleradvice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

@Autowired
    ProductService pService;

    @GetMapping("/products")
    public List<Product> getList () {
        return pService.getList();
    }

    @GetMapping("/products/{id}")
    public Product get (@PathVariable Integer id) {
        return pService.getProduct(id);
    }
    @PostMapping("/product/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        Product pr= null;
        try{
            pr= this.pService.addProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).build();


        }catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).build();

        }

    }

    @DeleteMapping("/product/deleteproduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id)
    {
        try {
            this.pService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/product/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Integer id)
    {
        try {
            this.pService.updateProduct(product, id);
            return ResponseEntity.ok().body(product);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }



}
