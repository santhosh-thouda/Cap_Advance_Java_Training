package com.capgemini.springbootbasic;

public class DataNotExist extends RuntimeException {

    public DataNotExist(String message) {
        super(message);
    }
}