package org.mendybot.android.shopping.model;

import org.junit.Test;
import org.mendybot.android.shopping.model.domain.ShoppingList;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class ShoppingModelTest {

    @Test
    public void scenario1() {
        List<ShoppingList> list = ShoppingModel.getInstance().getLists();
        assertEquals(0, list.size());
        ShoppingList sl = null;
        try {
            sl = ShoppingModel.getInstance().lookupList(UUID.fromString("1ce241bd-7a32-486c-b09b-db48753c6e40"));
            fail("problem");
        } catch (DoesNotExistException e) {
            // assumed
        }
        assertNull(sl);
        try {
            sl = ShoppingModel.getInstance().createList(UUID.fromString("1ce241bd-7a32-486c-b09b-db48753c6e40"));
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
            fail("problem");
        }
        assertNotNull(sl);
        ShoppingModel.getInstance().createList();
        List<ShoppingList> list2 = ShoppingModel.getInstance().getLists();
        assertEquals(2, list2.size());

    }

}