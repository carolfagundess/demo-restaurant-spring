 
package com.udemy.projetospring.controller;

import com.udemy.projetospring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carol
 */
@RestController
@RequestMapping( value = "/users")
public class UserController {
    
    @GetMapping
    public ResponseEntity<User> findAll(){
        
        User u = new User(1L, "cliente1", "545425452");
        
        return ResponseEntity.ok().body(u);
        
    }
}
