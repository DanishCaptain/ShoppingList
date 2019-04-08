package org.mendybot.android.shopping.model;

import java.util.UUID;

class DoesNotExistException extends Throwable {
    public DoesNotExistException(UUID id) {
        super("does not exist: "+id.toString());
    }
}
