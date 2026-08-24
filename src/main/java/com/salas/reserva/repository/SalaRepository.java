package com.salas.reserva.repository;

import com.salas.reserva.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
    
    boolean existsByNome(String nome);
    
    List<Sala> findByNomeContainingIgnoreCase(String nome);
}