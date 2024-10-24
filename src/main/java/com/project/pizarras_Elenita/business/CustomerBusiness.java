
package com.project.pizarras_Elenita.business;

import com.project.pizarras_Elenita.entities.ClienteEntity;
import com.project.pizarras_Elenita.entities.RolEntity;
import com.project.pizarras_Elenita.entities.TipoClienteEntity;
import com.project.pizarras_Elenita.models.requests.RegistroUsuarioRequest;
import com.project.pizarras_Elenita.models.response.UsuarioResponse;
import com.project.pizarras_Elenita.repositorio.ClienteRepository;
import com.project.pizarras_Elenita.services.UsuarioService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.project.pizarras_Elenita.repositorio.RolRepository;
import com.project.pizarras_Elenita.repositorio.TipoClienteRepository;
import com.project.pizarras_Elenita.utilities.Util;
import java.util.HashSet;
import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
public class CustomerBusiness implements UsuarioService {

    private final ClienteRepository clienteRepository;
    private final RolRepository rolRepository;
    private final TipoClienteRepository tipoClienteRepository;

    @Override
    public List<UsuarioResponse> getAllUsuarios() {
        return this.clienteRepository.findAll().stream().map(this::toResponse)
                .toList();
    }

    @Override
    public void createUsuario(RegistroUsuarioRequest request) {
        Optional<ClienteEntity> existingCliente = clienteRepository.findByCorreo(request.getCorreo());
        if (existingCliente.isPresent()) {
            throw new RuntimeException("El correo ya está en uso por otro usuario.");
        } else {
            List<RolEntity> roles = this.rolRepository.findByRolNombreIn(request.getRoles());
            List<TipoClienteEntity> tipoClienteSet = this.tipoClienteRepository.findByTipoClienteIn(request.getTipoClientes());
            ClienteEntity clienteEntity = ClienteEntity.builder()
                    .usuarioId(Util.generateRandomId(com.project.pizarras_Elenita.utilities.Identifier.CLIENTE.getValue())) // Generar un ID único, si es necesario
                    .nombre(request.getNombre())
                    .correo(request.getCorreo())
                    .numero(request.getTelefono())
                    .direccion(request.getDireccion())
                    .tipoListaCliente(new HashSet<>(tipoClienteSet))
                    .contra(request.getContra())
                    .listaRoles(new HashSet<>(roles))
                    .build();

            clienteRepository.save(clienteEntity);
        }
    }

    @Override
    public UsuarioResponse getUsuarioById(String id) {
        Optional<ClienteEntity> findCliente = this.clienteRepository.findById(id);
        if (findCliente.isEmpty()) {
            throw new RuntimeException("El cliente no existe");
        }
        return this.toResponse(findCliente.get());

    }

    @Override
    public void deleteById(String id) {
        Optional<ClienteEntity> findCliente = this.clienteRepository.findById(id);
        if (findCliente.isEmpty()) {
            throw new RuntimeException("El cliente no existe");
        }
        this.clienteRepository.delete(findCliente.get());
    }

    @Override
    public void updatePedido(String id, RegistroUsuarioRequest request) {

    }

    private UsuarioResponse toResponse(ClienteEntity entity) {
        return new ModelMapper().map(entity, UsuarioResponse.class);
    }
    
}
