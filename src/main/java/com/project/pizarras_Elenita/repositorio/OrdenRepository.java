/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.pizarras_Elenita.repositorio;

import com.project.pizarras_Elenita.entities.DeliveryEntity;
import com.project.pizarras_Elenita.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author FAMILIA
 */
@Repository
public interface OrdenRepository extends JpaRepository<PedidoEntity,String>{
    
}
