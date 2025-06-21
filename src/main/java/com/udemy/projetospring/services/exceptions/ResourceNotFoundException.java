
package com.udemy.projetospring.services.exceptions;

/**
 *
 * @author carol
 */
public class ResourceNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found: " + id);
    }
}
