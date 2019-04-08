package com.danishcaptain.mb.shoppinglist.model;

import com.danishcaptain.mb.shoppinglist.MainActivity;

public final class ItemModel {
    private static ItemModel singleton;

    private ItemModel() {
    }

    public void init(MainActivity activity) {
    }

    public synchronized static ItemModel getInstance() {
        if (singleton == null) {
            singleton = new ItemModel();
        }
        return singleton;
    }

}
