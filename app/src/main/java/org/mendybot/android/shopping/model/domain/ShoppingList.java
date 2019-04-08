package org.mendybot.android.shopping.model.domain;

import java.util.ArrayList;
import java.util.UUID;

public class ShoppingList implements Comparable<ShoppingList> {
    private ArrayList<ShoppingItem> items = new ArrayList<>();
    private final UUID id;

    public ShoppingList() {
        this(UUID.randomUUID());
    }

    public ShoppingList(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int compareTo(ShoppingList shoppingList) {
        return id.compareTo(shoppingList.id);
    }
}
