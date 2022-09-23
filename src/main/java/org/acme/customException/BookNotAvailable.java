package org.acme.customException;

public class BookNotAvailable extends RuntimeException{

    public BookNotAvailable(String message) {
        super(message);
    }
}
