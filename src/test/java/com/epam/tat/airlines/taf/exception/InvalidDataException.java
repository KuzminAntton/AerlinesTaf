package com.epam.tat.airlines.taf.exception;

/**
 * @author Uladzislau Seuruk.
 */
public class InvalidDataException extends RuntimeException {
    public InvalidDataException() {
        super();
    }

    public InvalidDataException(Exception e) {
        super(e);
    }

    public InvalidDataException(String msg) {
        super(msg);
    }

    public InvalidDataException(String msg, Exception e) {
        super(msg, e);
    }
}
