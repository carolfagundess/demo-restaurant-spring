
package com.udemy.projetospring.repositories;

import com.udemy.projetospring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carol
 */

public interface CategoryRepository extends JpaRepository<Category, Long>{
    //nao precisa criar a implementação da inteface, pois a implementação é feita pelo SPRING   
}
