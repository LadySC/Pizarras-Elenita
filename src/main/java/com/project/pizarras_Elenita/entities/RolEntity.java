/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class RolEntity {

    @Id
    @Column(name = "rol_id", length = 6, nullable = false)
    private String rolId;

    @Column(name = "rol_nombre", length = 30, unique = true)
    private String rolNombre;
    
    @ManyToMany
    @JoinTable(
     name="rol_autoridad",
     joinColumns= @JoinColumn(name="rol_id"),
     inverseJoinColumns= @JoinColumn(name="autoridad_id")
     )
    private Set <AutoridadEntity> autoridades;

}
