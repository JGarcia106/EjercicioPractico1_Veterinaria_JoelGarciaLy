package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cita")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("citas", citaService.listarCitas());
        return "cita/listado";
    }
}