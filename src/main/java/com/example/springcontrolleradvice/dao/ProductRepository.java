package com.example.springcontrolleradvice.dao;

import com.example.springcontrolleradvice.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer>
{
    public Product findById(int id);

}
