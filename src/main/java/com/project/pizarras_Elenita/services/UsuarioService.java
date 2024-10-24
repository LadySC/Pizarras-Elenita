/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.pizarras_Elenita.services;

import com.project.pizarras_Elenita.models.requests.RegistroUsuarioRequest;
import com.project.pizarras_Elenita.models.response.UsuarioResponse;
import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> getAllUsuarios();

    void createUsuario(RegistroUsuarioRequest request);

    UsuarioResponse getUsuarioById(String id);

    void deleteById(String id);

    void updatePedido(String id, RegistroUsuarioRequest request);
}
