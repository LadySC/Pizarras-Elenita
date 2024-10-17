package com.project.pizarras_Elenita.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
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
@Table(name = "guia_de_remision")
public class RemisionEntity {

    @Id
    @Column(name = "guia_remision_id", length = 6, nullable = false)
    private String remisionId;

    @Column(name = "numero_guia", length = 50)
    private String remisionNumero;

    @Column(name = "fecha_emision")
    private LocalDate remisionFecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private ClienteEntity usuario;

}
