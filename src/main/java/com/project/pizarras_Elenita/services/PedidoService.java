/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.pizarras_Elenita.services;

import com.project.pizarras_Elenita.models.requests.OrdenRequest;
import com.project.pizarras_Elenita.models.response.OrdenResponse;
import java.util.List;

/**
 *
 * @author FAMILIA
 */
public interface PedidoService {

    List<OrdenResponse> getAllPedidoEntity();

    void createPedidoEntity(OrdenRequest request);

    OrdenResponse getPedidoEntityById(String id);

    void deletePedidoEntityById(String id);

    void updatePedidoEntityById(String id, OrdenRequest request);
}
