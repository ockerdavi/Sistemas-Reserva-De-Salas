package com.salas.reserva.controller;

import com.salas.reserva.model.Reserva;
import com.salas.reserva.repository.ReservaRepository;
import com.salas.reserva.repository.SalaRepository;
import com.salas.reserva.repository.UsuarioRepository;
import com.salas.reserva.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservaController {
    
    private final ReservaService reservaService;
    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;
    private final UsuarioRepository usuarioRepository;
    
    public ReservaController(ReservaService reservaService,
                             ReservaRepository reservaRepository,
                             SalaRepository salaRepository,
                             UsuarioRepository usuarioRepository) {
        this.reservaService = reservaService;
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    
        @GetMapping("/reservas")
    public String listar(@RequestParam(required = false) Long salaId, Model model) {
        if (salaId != null) {
            model.addAttribute("reservas", reservaRepository.findBySalaId(salaId));
            model.addAttribute("salaFiltro", salaId);
        } else {
            model.addAttribute("reservas", reservaRepository.findAll());
        }
        model.addAttribute("salas", salaRepository.findAll());
        return "reservas/lista";
    }
    
    @GetMapping("/reservas/nova")
    public String formNova(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("salas", salaRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "reservas/form";
    }
    
       @PostMapping("/reservas")
    public String salvar(@ModelAttribute Reserva reserva, 
                         org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        try {
            reservaService.salvar(reserva);
            return "redirect:/reservas";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("erro", e.getMessage());
            return "redirect:/reservas/nova";
        }
    }
    
    @GetMapping("/reservas/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        reservaRepository.deleteById(id);
        return "redirect:/reservas";
    }
}