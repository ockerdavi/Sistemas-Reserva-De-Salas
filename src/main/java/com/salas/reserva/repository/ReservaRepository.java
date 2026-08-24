package com.salas.reserva.repository;

import com.salas.reserva.model.Reserva;
import com.salas.reserva.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    List<Reserva> findBySalaAndData(Sala sala, LocalDate data);
    
    List<Reserva> findBySalaId(Long salaId);
}