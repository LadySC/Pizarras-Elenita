/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.pizarras_Elenita.services;

import com.project.pizarras_Elenita.models.requests.ProductoRequest;
import com.project.pizarras_Elenita.models.response.ProductoResponse;
import java.util.List;

/**
 *
 * @author Ryzen
 */
public interface ProductoService {

    List<ProductoResponse> getAllProductos();

    void createProducto(ProductoRequest request);

    ProductoResponse getProductoById(String id);

    void deleteById(String id);

    void updateProducto(String id, ProductoRequest request);

}
