/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tipo_cliente")
public class TipoClienteEntity {
    @Id
    @Column(name="tipo_cliente_id", length=6, nullable=false)
    private String idTipoCliente;
    
    @Column (name="tipo_cliente", length=20)
    private String tipoCliente;
    
}
