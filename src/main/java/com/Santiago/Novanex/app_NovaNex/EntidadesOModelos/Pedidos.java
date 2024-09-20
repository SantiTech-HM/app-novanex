package com.Santiago.Novanex.app_NovaNex.EntidadesOModelos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Objects;

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
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadosPedido estadoPedido;

    @ManyToOne
    @JoinColumn(name = "estado_devolucion_id")
    private EstadosDevolucion estadoDevolucion;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id", nullable = false)
    private MetodosPago metodoPago;

    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    // Getters y setters

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public EstadosPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadosPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public EstadosDevolucion getEstadoDevolucion() {
        return estadoDevolucion;
    }

    public void setEstadoDevolucion(EstadosDevolucion estadoDevolucion) {
        this.estadoDevolucion = estadoDevolucion;
    }

    public MetodosPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodosPago metodoPago) {
        this.metodoPago = metodoPago;
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


    // Equals, hashCode
    // equals method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return Objects.equals(id, pedidos.id) &&
                Objects.equals(cliente, pedidos.cliente) &&
                Objects.equals(estadoPedido, pedidos.estadoPedido) &&
                Objects.equals(estadoDevolucion, pedidos.estadoDevolucion) &&
                Objects.equals(metodoPago, pedidos.metodoPago) &&
                Objects.equals(precioTotal, pedidos.precioTotal) &&
                Objects.equals(fechaCreacion, pedidos.fechaCreacion);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, estadoPedido, estadoDevolucion,
                metodoPago, precioTotal, fechaCreacion);
    }

    // toString method
    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", estado=" + estadoPedido +
                ", estadoDevolucion=" + estadoDevolucion +
                ", metodoPago=" + metodoPago +
                ", precioTotal=" + precioTotal +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
