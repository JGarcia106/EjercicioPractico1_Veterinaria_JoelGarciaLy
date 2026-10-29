package com.veterinaria.veterinaria.service;

import com.veterinaria.veterinaria.domain.Servicio;
import com.veterinaria.veterinaria.repository.ServicioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    public Servicio buscarServicio(Integer id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }
}