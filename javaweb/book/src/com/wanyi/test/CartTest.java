package com.wanyi.test;

import com.wanyi.pojo.Cart;
import com.wanyi.pojo.CartItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();
    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"java",40,1));
        cart.addItem(new CartItem(2,"java1",32,3));
        cart.addItem(new CartItem(3,"java2",14,5));
        System.out.println(cart.toString());
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1,"java",40,1));
        cart.addItem(new CartItem(2,"java1",32,3));
        cart.addItem(new CartItem(3,"java2",14,5));
        cart.deleteItem(2);
        System.out.println(cart.toString());
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1,"java",40,1));
        cart.addItem(new CartItem(2,"java1",32,3));
        cart.addItem(new CartItem(3,"java2",14,5));
        cart.clear();
        System.out.println(cart.toString());
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1,"java",40,1));
        cart.addItem(new CartItem(2,"java1",32,3));
        cart.addItem(new CartItem(3,"java2",14,5));
        cart.updateCount(3,10);
        System.out.println(cart.toString());
    }
}