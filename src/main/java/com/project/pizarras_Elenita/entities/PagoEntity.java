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
@Table(name = "pago")
public class PagoEntity {

    @Id
    @Column(name = "pago_id", length = 6, nullable = false)
    private String pagoId;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "metodo_pago", length = 50)
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;
}
