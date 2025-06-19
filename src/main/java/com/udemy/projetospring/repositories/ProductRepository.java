
package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carol
 */

public interface ProductRepository extends JpaRepository<Product, Long>{
    //nao precisa criar a implementação da inteface, pois a implementação é feita pelo SPRING   
}
