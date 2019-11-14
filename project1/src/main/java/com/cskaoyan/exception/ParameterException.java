package com.cskaoyan.exception;

import lombok.Data;

@Data
public class ParameterException extends Exception{
    String parameter;

    public ParameterException(String message, String parameter) {
        super(message);
        this.parameter = parameter;
    }
}
