package com.dzone.exception_handling_in_java_streams;

public class Try<Exception, R> {
    private final Exception failure;
    private final R succes;
    public Try(Exception failure, R succes) {
        this.failure = failure;
        this.succes = succes;
    }
}