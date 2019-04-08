package org.mendybot.android.shopping.model;

import org.mendybot.android.shopping.model.domain.ShoppingList;

interface ShoppingChangeListener {
    void listAdded(ShoppingList list);
}
