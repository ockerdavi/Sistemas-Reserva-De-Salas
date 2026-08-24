package com.salas.reserva.controller;

import com.salas.reserva.model.Usuario;
import com.salas.reserva.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {
    
    private final UsuarioRepository usuarioRepository;
    
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @GetMapping("/usuarios")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios/lista";
    }
    
    @GetMapping("/usuarios/novo")
    public String formNovo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }
    
    @PostMapping("/usuarios")
    public String salvar(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/usuarios/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        model.addAttribute("usuario", usuario);
        return "usuarios/form";
    }
    
    @GetMapping("/usuarios/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}