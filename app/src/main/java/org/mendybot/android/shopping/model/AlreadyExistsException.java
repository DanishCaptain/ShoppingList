package org.mendybot.android.shopping.model;

import java.util.UUID;

class AlreadyExistsException extends Throwable {
    public AlreadyExistsException(UUID id) {
        super("already exists: "+id.toString());
    }
}
