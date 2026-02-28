package com.capgemini.springbootbasic;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationException {

    // Handles all general exceptions
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex) {
        return "General Exception: " + ex.getMessage();
    }

    // Handles custom DataNotExist exception
    @ExceptionHandler(DataNotExist.class)
    public String handleDataNotExist(DataNotExist ex) {
        return "Data Not Exist: " + ex.getMessage();
    }
}