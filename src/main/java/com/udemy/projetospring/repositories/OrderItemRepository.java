
package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carol
 */

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    //nao precisa criar a implementação da inteface, pois a implementação é feita pelo SPRING   
}
