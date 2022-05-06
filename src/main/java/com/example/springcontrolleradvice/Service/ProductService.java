package com.example.springcontrolleradvice.Service;

import com.example.springcontrolleradvice.dao.ProductRepository;
import com.example.springcontrolleradvice.entity.Product;
import com.example.springcontrolleradvice.exceptions.NoDataFoundException;
import com.example.springcontrolleradvice.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


   // private static List<Product> list = new ArrayList<>();

//    static {
//        list.add(new Product(1, "iPhone XR", 500.00));
//        list.add(new Product(2, "Galaxy Note 10", 700.00));
//        list.add(new Product(3, "Oneplus Nord", 400.00));
//        list.add(new Product(4, "Galaxy S10", 750.00));
//        list.add(new Product(5, "iPhone 11", 700.00));
//    }
 // get all products
    public List<Product> getList () {
        List<Product> list= (List<Product>) this.productRepository.findAll();
        if (list.size() > 0) {
            return list;
        }
        throw new NoDataFoundException("No products available");
    }

    //add product
    public Product addProduct(Product p)
    {
        Product result = this.productRepository.save(p);

        return result;
    }

// get product by id
    public Product getProduct(Integer id) {
//        Optional<Product> theProduct = list.stream().filter(p -> p.getId() == id).findFirst();
//        if (!theProduct.isPresent()) {
//            throw new ResourceNotFoundException("Product not found for the id->"+id);
//        }
//        return theProduct.get();
        Optional<Product> product =null;
        try
        {
            product= this.productRepository.findById(id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return product.get();
    }

    public void deleteProduct(Integer id)
    {
        this.productRepository.deleteById(id);

    }
    public void updateProduct(Product product,Integer id)
    {
        product.setId(id);
        productRepository.save(product);

    }
}
