/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.business;

import com.project.pizarras_Elenita.entities.ProductoEntity;
import com.project.pizarras_Elenita.models.requests.ProductoRequest;
import com.project.pizarras_Elenita.models.response.ProductoResponse;
import com.project.pizarras_Elenita.repositorio.ProductoRepository;
import com.project.pizarras_Elenita.services.ProductoService;
import com.project.pizarras_Elenita.utilities.Identifier;
import com.project.pizarras_Elenita.utilities.Util;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ryzen
 */
@Service
@RequiredArgsConstructor
public class ProductoBusiness implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoResponse> getAllProductos() {
        return this.productoRepository.findAll().stream().map(this::toResponse)
                .toList();
    }

    @Override
    public void createProducto(ProductoRequest request) {
        Optional<ProductoEntity> existingProducto = productoRepository.findByNombreProducto(request.getProductName());
        if (existingProducto.isPresent()) {
            throw new RuntimeException("El nombre del producto ya está en uso.");
        } else {
            ProductoEntity productoEntity = ProductoEntity.builder()
                    .productoId(Util.generateRandomId(Identifier.PRODUCTO.getValue())) // Generar un ID único, si es necesario
                    .nombreProducto(request.getProductName())
                    .descripcion(request.getDescription())
                    .precio(request.getPrice())
                    .build();

            productoRepository.save(productoEntity);
        }
    }

    @Override
    public ProductoResponse getProductoById(String id) {
        Optional<ProductoEntity> findProducto = this.productoRepository.findById(id);
        if (findProducto.isEmpty()) {
            throw new RuntimeException("El producto no existe");
        }
        return this.toResponse(findProducto.get());
    }

    private ProductoResponse toResponse(ProductoEntity entity) {
        return new ModelMapper().map(entity, ProductoResponse.class);
    }

    @Override
    public void deleteById(String id) {
        Optional<ProductoEntity> findProducto = this.productoRepository.findById(id);
        if (findProducto.isEmpty()) {
            throw new RuntimeException("El producto no existe");
        }
        this.productoRepository.delete(findProducto.get());
    }

    @Override
    public void updateProducto(String id, ProductoRequest request) {
        Optional<ProductoEntity> findProducto = this.productoRepository.findById(id);
        if (findProducto.isEmpty()) {
            throw new RuntimeException("El producto no existe");
        }

        ProductoEntity productoEntity = findProducto.get();
        productoEntity.setNombreProducto(request.getProductName());
        productoEntity.setDescripcion(request.getDescription());
        productoEntity.setPrecio(request.getPrice());

        productoRepository.save(productoEntity);
    }

}
