package com.udemy.projetospring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udemy.projetospring.entities.enums.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author carol
 */
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;
    private Integer orderStatus;

    //ASSOCIACAO MUITOS PEDIDOS PARA UM CLIENTE
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private User client;
    
    //ASSOCIACAO UM PEDIDO PARA MUITOS ITEMS // armazenas os items do pedido
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();
    
    //associacao one to one, tendo os mesmos IDsss
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(Long id, Instant momento, OrderStatus orderStatus, User user) {
        this.id = id;
        this.momento = momento;
        setOrderStatus(orderStatus);
        this.client = user;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //retonar todos os items do pedido
    public Set<OrderItem> getItems() {
        return items;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
    
    public Double getTotal(){
        double sum = 0;
        for (OrderItem item : items) {
            sum = sum + item.getSubtotal();
        }
        return sum;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Order other = (Order) obj;
        return Objects.equals(this.id, other.id);
    }

}
