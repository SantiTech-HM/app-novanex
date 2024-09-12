package com.Santiago.Novanex.app_NovaNex.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionNoFound extends RuntimeException {

    public ExceptionNoFound(String s) {
        super(s);
    }
}
