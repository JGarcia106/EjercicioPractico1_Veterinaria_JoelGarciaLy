package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.domain.Servicio;
import com.veterinaria.veterinaria.service.ServicioService;
import com.veterinaria.veterinaria.service.TipoServicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    private final ServicioService servicioService;
    private final TipoServicioService tipoServicioService;

    public ServicioController(ServicioService servicioService,
                              TipoServicioService tipoServicioService) {
        this.servicioService = servicioService;
        this.tipoServicioService = tipoServicioService;
    }

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("servicios",
                servicioService.listarServicios());
        return "servicio/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("tiposServicio",
                tipoServicioService.listarTiposServicio());
        return "servicio/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Servicio servicio = servicioService.buscarServicio(id);

        if (servicio == null) {
            return "redirect:/servicio/listado";
        }

        model.addAttribute("servicio", servicio);
        model.addAttribute("tiposServicio",
                tipoServicioService.listarTiposServicio());
        return "servicio/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Servicio servicio,
                          RedirectAttributes redirectAttributes) {
        servicioService.guardarServicio(servicio);
        redirectAttributes.addFlashAttribute(
                "mensaje", "Servicio guardado correctamente.");
        return "redirect:/servicio/listado";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id,
                           RedirectAttributes redirectAttributes) {
        servicioService.eliminarServicio(id);
        redirectAttributes.addFlashAttribute(
                "mensaje", "Servicio eliminado correctamente.");
        return "redirect:/servicio/listado";
    }
}