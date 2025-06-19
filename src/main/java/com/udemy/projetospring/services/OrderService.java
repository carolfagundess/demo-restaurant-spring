package com.udemy.projetospring.services;

import com.udemy.projetospring.entities.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udemy.projetospring.repositories.OrderRepository;

/**
 *
 * @author carol
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    
    //repository retorna um optional, que ira retornar o objeto implementado
    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
