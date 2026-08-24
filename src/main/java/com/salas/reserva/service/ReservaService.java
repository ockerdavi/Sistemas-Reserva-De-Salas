package com.salas.reserva.service;

import com.salas.reserva.model.Reserva;
import com.salas.reserva.model.Sala;
import com.salas.reserva.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservaService {
    
    private final ReservaRepository reservaRepository;
    
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    
    public Reserva salvar(Reserva reserva) {
        List<Reserva> existentes = reservaRepository.findBySalaAndData(
            reserva.getSala(), reserva.getData()
        );
        
        for (Reserva existente : existentes) {
            if (conflita(reserva, existente)) {
                throw new RuntimeException("Conflito de horário!");
            }
        }
        
        return reservaRepository.save(reserva);
    }
    
    private boolean conflita(Reserva r1, Reserva r2) {
        return r1.getHorarioInicio().isBefore(r2.getHorarioFim()) 
            && r1.getHorarioFim().isAfter(r2.getHorarioInicio());
    }
}   