package com.udemy.projetospring.services;

import com.udemy.projetospring.entities.Product;
import com.udemy.projetospring.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carol
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    
    //repository retorna um optional, que ira retornar o objeto implementado
    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}
