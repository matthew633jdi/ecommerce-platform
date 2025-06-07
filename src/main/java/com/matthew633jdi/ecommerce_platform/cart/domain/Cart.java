package com.matthew633jdi.ecommerce_platform.cart.domain;

import com.matthew633jdi.ecommerce_platform.common.domain.BaseTimeEntity;
import com.matthew633jdi.ecommerce_platform.product.domain.Product;
import com.matthew633jdi.ecommerce_platform.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@Table(name = "carts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    public void addProductToCart(Product product, int quantity) {

        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity(quantity);
                return;
            }
        }

        CartItem newCartItem = new CartItem(this, product, quantity);
        this.cartItems.add(newCartItem);
    }

    public void removeProductFromCart(Product product) {
        cartItems.removeIf(item -> item.getProduct().equals(product));
    }

    public void clearCart() {
        this.cartItems.clear();
    }
}
