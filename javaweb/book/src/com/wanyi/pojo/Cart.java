package com.wanyi.pojo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private int totalCount;
    private double totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public int getTotalCount() {
        return totalCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }

    public void addItem(CartItem cartItem) {
        if (items.containsKey(cartItem.getId())) {
            CartItem item = items.get(cartItem.getId());
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice() * item.getCount());
        } else {
            items.put(cartItem.getId(), cartItem);
        }
        update();

    }

    public void deleteItem(int id) {
        items.remove(id);
        update();
    }

    public void clear() {
        items.clear();
        update();
    }

    public void updateCount(int id, int count) {
        CartItem item = items.get(id);
        item.setCount(count);
        item.setTotalPrice(count * item.getPrice());
        update();
    }

    public void update() {
        totalPrice = 0;
        totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
            totalPrice += entry.getValue().getCount() * entry.getValue().getPrice();
        }
    }

}
