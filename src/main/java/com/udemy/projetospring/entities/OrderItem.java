package com.udemy.projetospring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.projetospring.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author carol
 */
@Entity
@Table(name = "tb_orderItem")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK(); // Contém as associações
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    //classe para definir a chave primaria
    //faz um loop na API
    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    //classe para definir a chave primaria
    public void setOrder(Order order) {
        id.setOrder(order);
    }

    //classe para definir a chave primaria
    @JsonIgnore
    public Product getProduct() {
        return id.getProduct();
    }

    //classe para definir a chave primaria
    public void setOrder(Product product) {
        id.setProduct(product);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItem other = (OrderItem) obj;
        return Objects.equals(this.id, other.id);
    }

}
