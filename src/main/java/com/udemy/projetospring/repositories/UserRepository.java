
package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carol
 */

public interface UserRepository extends JpaRepository<User, Long>{
    //nao precisa criar a implementação da inteface, pois a implementação é feita pelo SPRING   
}
