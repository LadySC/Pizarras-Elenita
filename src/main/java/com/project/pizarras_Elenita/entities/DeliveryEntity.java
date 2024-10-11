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
import java.time.LocalDate;
import lombok.*;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="delivery")

public class DeliveryEntity{

@Id
@Column(name="delivery_id",length=6)
private String deliveryId;


@Column(name="fecha_delivery")
    private LocalDate fechaDelivery;

@Column(name="direccion_delivery",length=255)
private String pedidoId;

@ManyToOne
    @JoinColumn(name="pedido_id") 
    private PedidoEntity pedido; 


}
