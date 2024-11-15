/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.pizarras_Elenita.repositorio;

import com.project.pizarras_Elenita.entities.RolEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 Aqui hay consultas principales
 mayoria de los metodos CRUD
 */
@Repository
public interface RolRepository extends JpaRepository<RolEntity, String> {

    /*Traera toda la lista de roles solo por el nombre*/
    List<RolEntity> findByRolNombreIn(List<String> roles);
}
