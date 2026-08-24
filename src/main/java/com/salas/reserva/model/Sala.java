package com.salas.reserva.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "salas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer capacidade;

    @Column
    private String descricao;
    
}
