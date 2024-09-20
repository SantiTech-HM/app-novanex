package com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos;

import java.time.LocalDateTime;

public class PedidosDTO {


    private Integer id;
    private Integer clienteId;
    private Integer estadoId;
    private Integer estadoDevolucionId;
    private Integer metodoPagoId;
    private Double precioTotal;
    private LocalDateTime fechaCreacion;


    // Getters y setters para todos los campos


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public Integer getEstadoDevolucionId() {
        return estadoDevolucionId;
    }

    public void setEstadoDevolucionId(Integer estadoDevolucionId) {
        this.estadoDevolucionId = estadoDevolucionId;
    }

    public Integer getMetodoPagoId() {
        return metodoPagoId;
    }

    public void setMetodoPagoId(Integer metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
