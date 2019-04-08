package org.mendybot.android.shopping.model;

import org.mendybot.android.shopping.model.domain.ShoppingList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

public final class ShoppingModel {
    private static ShoppingModel singleton;
    private ArrayList<ShoppingChangeListener> listeners = new ArrayList<>();
    private LinkedHashMap<UUID, ShoppingList> listM = new LinkedHashMap<>();
    private ArrayList<ShoppingList> listL = new ArrayList<>();

    private ShoppingModel() {
    }

    public List<ShoppingList> getLists() {
        return listL;
    }

    public ShoppingList lookupList(UUID id) throws DoesNotExistException {
        ShoppingList list = listM.get(id);
        if (list == null) {
            throw new DoesNotExistException(id);
        }
        return list;
    }

    public ShoppingList createList(UUID id) throws AlreadyExistsException {
        ShoppingList list = listM.get(id);
        if (list == null) {
            list = new ShoppingList(id);
            listM.put(id, list);
            listL.add(list);
            notifyShoppingListAdd(list);
        } else {
            throw new AlreadyExistsException(id);
        }
        return list;
    }

    public ShoppingList createList() {
        ShoppingList list = new ShoppingList();
        listM.put(list.getId(), list);
        listL.add(list);
        notifyShoppingListAdd(list);
        return list;
    }

    private void notifyShoppingListAdd(ShoppingList list) {
        for (ShoppingChangeListener lis : listeners) {
            lis.listAdded(list);
        }
    }

    public void addShoppingChangeListener(ShoppingChangeListener lis) {
        listeners.add(lis);
    }


    public synchronized static ShoppingModel getInstance() {
        if (singleton == null) {
            singleton = new ShoppingModel();
        }
        return singleton;
    }

}
