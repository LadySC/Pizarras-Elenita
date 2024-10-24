/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.business;

import com.project.pizarras_Elenita.entities.ClienteEntity;
import com.project.pizarras_Elenita.entities.PedidoEntity;
import com.project.pizarras_Elenita.models.requests.OrdenRequest;
import com.project.pizarras_Elenita.models.response.OrdenResponse;
import com.project.pizarras_Elenita.repositorio.ClienteRepository;
import com.project.pizarras_Elenita.repositorio.OrdenRepository;
import com.project.pizarras_Elenita.services.PedidoService;
import com.project.pizarras_Elenita.utilities.Identifier;
import com.project.pizarras_Elenita.utilities.Util;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAMILIA
 */
@Service
@RequiredArgsConstructor
public class PedidoBusiness implements PedidoService {

    private final OrdenRepository ordenRepository;
    private final ClienteRepository clienteRepository;


    private OrdenResponse toResponse(PedidoEntity entity) {
        return new ModelMapper().map(entity, OrdenResponse.class);
    }

    @Override
    public List<OrdenResponse> getAllPedidoEntity() {
        return this.ordenRepository.findAll().stream().map(this::toResponse)
                .toList();
    }

    @Override
    public void createPedidoEntity(OrdenRequest request) {
        Optional<ClienteEntity> existingCliente = clienteRepository.findByCorreo(request.getCorreo());
        if (existingCliente.isEmpty()) {
            throw new RuntimeException("El correo ya está en uso por otro usuario.");
        } else {
            PedidoEntity pedidoEntity = PedidoEntity.builder()
                    .pedidoId(Util.generateRandomId(Identifier.PEDIDO.getValue())) // Generar un ID único, si es necesario
                    .measurement(request.getMedidas())
                    .material(request.getMaterial())
                    .precio(request.getPrecio())
                    .metodoDelivery(request.getMetododelivery())
                    .cargoEnvio(request.getCargoenvio())
                    .fechaPedido(request.getFechapedido())
                    .status(request.getStatus())
                    .usuario(existingCliente.get())
                    .build();
            ordenRepository.save(pedidoEntity);
        }
    }

    @Override
    public OrdenResponse getPedidoEntityById(String id) {
        Optional<PedidoEntity> findPedido = this.ordenRepository.findById(id);
        if (findPedido.isEmpty()) {
            throw new RuntimeException("El pedido no existe");
        }
        return this.toResponse(findPedido.get());
    }

    @Override
    public void deletePedidoEntityById(String id) {
        Optional<PedidoEntity> findPedido = this.ordenRepository.findById(id);
        if (findPedido.isEmpty()) {
            throw new RuntimeException("El pedido no existe");
        }
        this.ordenRepository.delete(findPedido.get());
    }

    @Override
    public void updatePedidoEntityById(String id, OrdenRequest request) {
    }

    private OrdenResponse toRespose(PedidoEntity entity) {
        return new ModelMapper().map(entity, OrdenResponse.class);
    }
}
