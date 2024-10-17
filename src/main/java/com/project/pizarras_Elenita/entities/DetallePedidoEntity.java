/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class DetallePedidoEntity {

    @EmbeddedId
    private DetallePedidoId DetallePedidoId;

    @ManyToOne
    @MapsId("pedidoId") // Referencia al pedido
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @ManyToOne
    @MapsId("productoId") // Referencia al producto
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;
    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "subtotal")
    private BigDecimal subtotal;
}
