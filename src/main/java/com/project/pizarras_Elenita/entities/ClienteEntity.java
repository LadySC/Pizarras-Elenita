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
@Table(name="usuario")
public class ClienteEntity {
    @Id
    @Column(name="usuario_id", length=6, nullable=false)
    private String usuarioId;
    
    @Column(name="tipo_cliente_id", length=6)
    private String tipoClienteId;
    
    @Column(name="nombre", length=100)
    private String nombre;
    
    @Column(name="correo", length=20, unique=true)
    private String correo;
    
    @Column(name="numero", length=20)
    private String numero;
    
    @Column(name="direccion", length=255)
    private String direccion;
    
    @Column(name="contra", length=50)
    private String contra;
    
    @ManyToMany
    @JoinTable(
     name="usuario_tipo_cliente",
     joinColumns= @JoinColumn(name="usuario_id"),
     inverseJoinColumns= @JoinColumn(name="tipo_cliente_id")
     )
    private Set <TipoClienteEntity> tipoListaCliente;
    
    @ManyToMany
    @JoinTable(
     name="usuario_rol",
     joinColumns= @JoinColumn(name="usuario_id"),
     inverseJoinColumns= @JoinColumn(name="rol_id")
     )
    private Set <RolEntity> listaRoles;
    
}
