package com.Santiago.Novanex.app_NovaNex.Excepciones;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExcepcionDePedidos extends RuntimeException {

    public ExcepcionDePedidos(String mensaje) {
        super(mensaje);
    }

}

