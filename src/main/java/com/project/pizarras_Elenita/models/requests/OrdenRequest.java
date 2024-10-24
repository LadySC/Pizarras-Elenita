/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.models.requests;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenRequest {

    private String correo;
    private String paymentId;
    private String medidas;
    private String material;
    private BigDecimal precio;
    private String metododelivery;
    private BigDecimal cargoenvio;
    @Builder.Default
    private LocalDate fechapedido = LocalDate.now();
    private String status;

    private BigDecimal totalPrice;
    private List<ArticuloCompradoRequest> items;

    public BigDecimal calculateTotalPrice() {
        this.totalPrice = this.items.stream()
                .map(ArticuloCompradoRequest::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return this.totalPrice;
    }
;
}
