package com.udemy.projetospring.services;

import com.udemy.projetospring.entities.User;
import com.udemy.projetospring.repositories.UserRepository;
import com.udemy.projetospring.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author carol
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    //repository retorna um optional, que ira retornar o objeto implementado
    public User findById(Long id) {
        System.out.println("Buscando usuário ID: " + id); // Log simples
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> {
            System.out.println("Usuário não encontrado: " + id); // Log do erro
            return new ResourceNotFoundException(id);
        });
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    public User update(Long id, User obj) {
        try {
            User entUser = userRepository.getReferenceById(id);
            updateData(entUser, obj);
            return userRepository.save(entUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setNome(obj.getNome());
        entity.setPhone(obj.getPhone());
    }
}
