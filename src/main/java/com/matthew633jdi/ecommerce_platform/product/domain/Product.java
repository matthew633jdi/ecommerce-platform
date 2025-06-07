package com.matthew633jdi.ecommerce_platform.product.domain;

import com.matthew633jdi.ecommerce_platform.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity @Getter
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Builder
    public Product(String name, String description, BigDecimal price, Integer stockQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void addStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("the quantity cannot be smaller than zero.");
        }
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("the quantity cannot be smaller than zero.");
        }
        if (this.stockQuantity < quantity) {
            throw new IllegalStateException("there is a lack of inventory.");
        }
        this.stockQuantity -= quantity;
    }

    public void updateInfo(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}