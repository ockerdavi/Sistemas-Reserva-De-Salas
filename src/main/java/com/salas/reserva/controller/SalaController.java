package com.salas.reserva.controller;

import com.salas.reserva.model.Sala;
import com.salas.reserva.repository.SalaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalaController {
    
    private final SalaRepository salaRepository;
    
    public SalaController(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }
    
        @GetMapping("/salas")
    public String listar(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("salas", salaRepository.findByNomeContainingIgnoreCase(nome));
            model.addAttribute("nomeFiltro", nome);
        } else {
            model.addAttribute("salas", salaRepository.findAll());
        }
        return "salas/lista";
    }

        @GetMapping("/salas/nova")
    public String formNova(Model model) {
        model.addAttribute("sala", new Sala());
        return "salas/form";
    }
    
    @PostMapping("/salas")
    public String salvar(@ModelAttribute Sala sala) {
        salaRepository.save(sala);
        return "redirect:/salas";
    }

        @GetMapping("/salas/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        Sala sala = salaRepository.findById(id).orElseThrow();
        model.addAttribute("sala", sala);
        return "salas/form";
    }
    
    @GetMapping("/salas/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        salaRepository.deleteById(id);
        return "redirect:/salas";
    }
}