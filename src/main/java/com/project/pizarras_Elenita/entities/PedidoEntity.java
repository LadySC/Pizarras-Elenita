/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @Column(name = "pedido_id", length = 6)
    private String pedidoId;

    @Column(name = "measurement", length = 50)
    private String measurement;

    @Column(name = "material", length = 50)
    private String material;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "metodo_delivery", length = 50)
    private String metodoDelivery;

    @Column(name = "cargo_envio")
    private BigDecimal cargoEnvio;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "status", length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private ClienteEntity usuario;

}
