package com.matthew633jdi.ecommerce_platform.order.domain;

import com.matthew633jdi.ecommerce_platform.common.domain.BaseTimeEntity;
import com.matthew633jdi.ecommerce_platform.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(User user, BigDecimal totalPrice) {
        this.user = user;
        this.totalPrice = totalPrice;
        this.orderStatus = OrderStatus.PENDING; // 초기 주문 상태 설정
    }

    public void changeOrderStatus(OrderStatus newStatus) {
        this.orderStatus = newStatus;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void calculateTotalPrice() {
        BigDecimal calculatedPrice = BigDecimal.ZERO;
        for (OrderItem item : orderItems) {
            calculatedPrice = calculatedPrice.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        this.totalPrice = calculatedPrice;
    }

}
