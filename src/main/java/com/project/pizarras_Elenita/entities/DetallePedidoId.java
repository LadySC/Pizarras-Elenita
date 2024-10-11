/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable  //fusion de las llaves foraneas 
public class DetallePedidoId {

    private String pedidoId;
    private String productoId;
}
