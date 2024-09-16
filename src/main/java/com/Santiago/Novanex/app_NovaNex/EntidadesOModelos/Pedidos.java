package com.Santiago.Novanex.app_NovaNex.EntidadesOModelos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes clientes;

    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadosPedido estadosPedido;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_devolucion_id")
    private EstadosDevolucion estadosDevolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pago_id", nullable = false)
    private MetodosPago metodosPago;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public EstadosPedido getEstadosPedido() {
        return estadosPedido;
    }

    public void setEstadosPedido(EstadosPedido estadosPedido) {
        this.estadosPedido = estadosPedido;
    }

    public EstadosDevolucion getEstadosDevolucion() {
        return estadosDevolucion;
    }

    public void setEstadosDevolucion(EstadosDevolucion estadosDevolucion) {
        this.estadosDevolucion = estadosDevolucion;
    }

    public MetodosPago getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(MetodosPago metodosPago) {
        this.metodosPago = metodosPago;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
