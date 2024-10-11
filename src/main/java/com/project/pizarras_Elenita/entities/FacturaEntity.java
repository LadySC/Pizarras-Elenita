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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="factura")
public class FacturaEntity {
    @Id
    @Column(name="factura_id", length=6, nullable=false)
    private String facturaId;
    
    @Column(name="fecha_factura", nullable=false)
    private LocalDate fechaFactura;
    
    @Column(name="monto_total", precision=10, scale=2, nullable=false)
    private BigDecimal montoTotal;
    
    @Column(name="status", length=20)
    private String status;
    
    @ManyToOne
    @JoinColumn(name="pedido_id", nullable=false) 
    private PedidoEntity pedido; 
}
