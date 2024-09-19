package com.Santiago.Novanex.app_NovaNex.EntidadesOModelos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadosPedido estadosPedido;

    @ManyToOne
    @JoinColumn(name = "estado_devolucion_id")
    private EstadosDevolucion estadosDevolucion;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id", nullable = false)
    private MetodosPago metodosPago;

    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    // Constructores

//    public Pedidos() {
//    }
//
//    public Pedidos(Integer id, Clientes clientes, EstadosPedido estadosPedido,
//                   EstadosDevolucion estadosDevolucion, MetodosPago metodosPago,
//                   Double precioTotal, LocalDateTime fechaCreacion) {
//        this.id = id;
//        this.clientes = clientes;
//        this.estadosPedido = estadosPedido;
//        this.estadosDevolucion = estadosDevolucion;
//        this.metodosPago = metodosPago;
//        this.precioTotal = precioTotal;
//        this.fechaCreacion = fechaCreacion;
//    }
    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
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

    // Equals, hashCode y toString

    // equals method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return Object.equals(id, pedidos.id) &&
                Object.equals(clientes, pedidos.clientes) &&
                Object.equals(estadosPedido, pedidos.estadosPedido) &&
                Object.equals(estadosDevolucion, pedidos.estadosDevolucion) &&
                Object.equals(metodosPago, pedidos.metodosPago) &&
                Object.equals(precioTotal, pedidos.precioTotal) &&
                Object.equals(fechaCreacion, pedidos.fechaCreacion);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Object.hash(id, clientes, estadosPedido, estadosDevolucion,
                metodosPago, precioTotal, fechaCreacion);
    }

    // toString method
    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", cliente=" + clientes +
                ", estado=" + estadosPedido +
                ", estadoDevolucion=" + estadosDevolucion +
                ", metodoPago=" + metodosPago +
                ", precioTotal=" + precioTotal +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
