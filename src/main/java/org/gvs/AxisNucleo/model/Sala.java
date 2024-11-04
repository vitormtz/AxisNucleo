/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gvs.AxisNucleo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import org.gvs.AxisNucleo.enums.StatusSala;

/**
 *
 * @author vitor
 */
@Data
@Entity
@Table(name = "salas")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSala;

    @Column(nullable = false, unique = true, length = 10)
    private String numero;

    @Column(nullable = false)
    private Integer capacidade;

    private String descricao;

    @Column(name = "tem_projetor")
    private boolean temProjetor;

    @Column(name = "tem_computador")
    private boolean temComputador;

    @Enumerated(EnumType.STRING)
    private StatusSala status;

    private boolean ativa;

    @PrePersist
    protected void onCreate() {
        status = StatusSala.DISPONIVEL;
        ativa = true;
    }
}
