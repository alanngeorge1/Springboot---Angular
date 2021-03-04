package com.alanngeorge1.AngularJava.rest.exeception;


import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ApiErrors {
    @Getter
    private final List<String> errors;

    public ApiErrors(List<String> errors){
        this.errors = errors;
    }

    public ApiErrors(String message){
        this.errors = Collections.singletonList(message);
    }

}

