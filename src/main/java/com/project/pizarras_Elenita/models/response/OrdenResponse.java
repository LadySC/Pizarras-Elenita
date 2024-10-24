/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.models.response;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.project.pizarras_Elenita.models.response.DetallePedidoResponse;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenResponse {

    private String orderId;
    private String userId;
    private String measurement;
    private String material;
    private BigDecimal Price;
    private String deliveryMethod;
    private LocalDateTime orderDate;
    private String status;

    private List<DetallePedidoResponse> productList;
=======
/**
 *
 * @author FAMILIA
 */
public class OrdenResponse {
    
>>>>>>> e1aae83d2c733d21e1e8e81391a3b46df3416d7c
}
