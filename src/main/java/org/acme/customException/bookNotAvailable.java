package org.acme.customException;

public class bookNotAvailable extends Exception{
    public bookNotAvailable()
    {
        super("Book is not in stock");
    }
    public bookNotAvailable(String message)
    {
        super(message);
    }

}
