package com.udemy.projetospring.services;

import com.udemy.projetospring.entities.Category;
import com.udemy.projetospring.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carol
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    
    //repository retorna um optional, que ira retornar o objeto implementado
    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
