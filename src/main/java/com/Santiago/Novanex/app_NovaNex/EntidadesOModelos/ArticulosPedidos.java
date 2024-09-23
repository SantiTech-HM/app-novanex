//package com.Santiago.Novanex.app_NovaNex.EntidadesOModelos;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Table(name = "articulos_pedidos")
//public class ArticulosPedidos {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "pedido_id" , nullable = false)
//    private Pedidos pedido;
//
//    @ManyToOne
//    @JoinColumn(name = "producto_id", nullable = false)
//    private Productos producto;
//
//    private Integer cantidad;
//
//    private Double precio;
//
//    // Getters y setters
//
//
//    public Integer getCantidad() {
//        return cantidad;
//    }
//
//    public void setCantidad(Integer cantidad) {
//        this.cantidad = cantidad;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Pedidos getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(Pedidos pedido) {
//        this.pedido = pedido;
//    }
//
//    public Double getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(Double precio) {
//        this.precio = precio;
//    }
//
//    public Productos getProducto() {
//        return producto;
//    }
//
//    public void setProducto(Productos producto) {
//        this.producto = producto;
//    }
//}
