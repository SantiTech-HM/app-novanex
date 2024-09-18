package com.Santiago.Novanex.app_NovaNex.Excepciones;

public class ExcepcionDePedidos extends RuntimeException {

    public ExcepcionDePedidos(String mensaje) {
        super(mensaje);
    }

    public ExcepcionDePedidos(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

