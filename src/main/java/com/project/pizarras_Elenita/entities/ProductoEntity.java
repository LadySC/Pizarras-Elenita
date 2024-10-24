/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="producto")
public class ProductoEntity {

    @Id
    @Column(name = "producto_id", length = 6, nullable = false)
    private String productoId;

    @Column(name = "nombre_producto", length = 100)
    private String nombreProducto;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "precio")
    private BigDecimal precio;

}
