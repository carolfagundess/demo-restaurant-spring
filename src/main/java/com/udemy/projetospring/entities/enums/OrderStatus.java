
package com.udemy.projetospring.entities.enums;

/**
 *
 * @author carol
 */
public enum OrderStatus {
    
    WAITING_PAYMENT(1),
    PAID(2),
    DELIVERED(3),
    CANCELED(4);
    
    private int code;
    
    private OrderStatus(int code){
        this.code = code;
    }
    
    public int getCode(){
        return code;
    }
    
    public static OrderStatus valueOf(int code){
        for (OrderStatus order : OrderStatus.values()) {
            if (order.getCode() == code) {
                return order;
            }
        }
        throw new IllegalArgumentException("Valor invalido");
    }
}
