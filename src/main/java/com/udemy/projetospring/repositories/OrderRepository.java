
package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carol
 */

public interface OrderRepository extends JpaRepository<Order, Long>{
    //nao precisa criar a implementação da inteface, pois a implementação é feita pelo SPRING   
}
