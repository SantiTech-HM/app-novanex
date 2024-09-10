package com.Santiago.Novanex.app_NovaNex.EntidadesOModelos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "clientes")
public class EntidadClientes {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
}
