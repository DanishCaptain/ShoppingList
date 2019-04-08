package org.mendybot.android.shopping.model.domain;

import java.util.UUID;

class ShoppingItem implements Comparable<ShoppingItem> {
    private final UUID id;

    public ShoppingItem(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int compareTo(ShoppingItem shoppingItem) {
        return id.compareTo(shoppingItem.id);
    }
}
