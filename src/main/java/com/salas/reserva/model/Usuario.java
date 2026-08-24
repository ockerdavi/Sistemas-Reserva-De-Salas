package com.salas.reserva.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable =  false)
    private String nome;

    @Column(nullable =  false, unique = true)
    private String email;

    
    @Column(nullable =  false, unique = true)
    private String matricula;
    
}
