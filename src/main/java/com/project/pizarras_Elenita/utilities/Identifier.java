/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.project.pizarras_Elenita.utilities;

import lombok.Getter;

@Getter
public enum Identifier {
    CLIENTE("CLI"),
    DELIVERY("DLV"),
    DETALLE_PEDIDO("DPE"),
    FACTURA("FCT"),
    PAGO("PGO"),
    PEDIDO("PED"),
    PRODUCTO("PRD"),
    REMISION("RMI");

    private final String value;

    Identifier(String value) {
        this.value = value;
    }
}
