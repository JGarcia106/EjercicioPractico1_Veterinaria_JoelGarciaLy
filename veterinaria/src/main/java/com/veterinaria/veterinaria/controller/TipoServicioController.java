package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.domain.TipoServicio;
import com.veterinaria.veterinaria.service.TipoServicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tipo-servicio")
public class TipoServicioController {

    private final TipoServicioService tipoServicioService;

    public TipoServicioController(TipoServicioService tipoServicioService) {
        this.tipoServicioService = tipoServicioService;
    }

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("tiposServicio",
                tipoServicioService.listarTiposServicio());
        return "tipo-servicio/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("tipoServicio", new TipoServicio());
        return "tipo-servicio/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(TipoServicio tipoServicio,
                          RedirectAttributes redirectAttributes) {
        tipoServicioService.guardarTipoServicio(tipoServicio);
        redirectAttributes.addFlashAttribute(
                "mensaje", "Tipo de servicio guardado correctamente.");
        return "redirect:/tipo-servicio/listado";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        TipoServicio tipoServicio =
                tipoServicioService.buscarTipoServicio(id);

        if (tipoServicio == null) {
            return "redirect:/tipo-servicio/listado";
        }

        model.addAttribute("tipoServicio", tipoServicio);
        return "tipo-servicio/formulario";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id,
                           RedirectAttributes redirectAttributes) {
        tipoServicioService.eliminarTipoServicio(id);
        redirectAttributes.addFlashAttribute(
                "mensaje", "Tipo de servicio eliminado correctamente.");
        return "redirect:/tipo-servicio/listado";
    }
}