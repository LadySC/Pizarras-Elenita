/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.services;

import com.project.pizarras_Elenita.models.requests.DeliveryRequest;
import com.project.pizarras_Elenita.models.response.DeliveryResponse;
import java.util.List;



public interface DeliveryService {
    List<DeliveryResponse> getAllDelivery();
    void createDelivery(DeliveryRequest request);
    DeliveryResponse getDeliveryById(String id);
    void deleteById(String id);
    void updateDelivery(String id, DeliveryRequest request);

}
