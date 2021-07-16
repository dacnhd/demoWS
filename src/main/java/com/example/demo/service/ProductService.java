package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Component(value = "productService")
@WebService
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @WebMethod
    public boolean save(Product product){
        productRepository.save(product);
        return true;
    }

    @WebMethod
    public List<Product> getList(){
        return productRepository.findAll();
    }

    @WebMethod
    public boolean sellProduct(int id, int quantity){
        Product product = productRepository.findById(id).get();
        product.setQuantity(quantity);
        productRepository.save(product);
        return true;
    }
}
