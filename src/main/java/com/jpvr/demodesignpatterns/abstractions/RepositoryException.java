package com.jpvr.demodesignpatterns.abstractions;

public class RepositoryException extends RuntimeException {

    public RepositoryException(final String message, final Throwable cause) {
        super(message, cause);
    }
} // end class RepositoryException extends RuntimeException
