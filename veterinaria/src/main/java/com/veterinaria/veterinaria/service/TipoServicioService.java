package com.veterinaria.veterinaria.service;

import com.veterinaria.veterinaria.domain.TipoServicio;
import com.veterinaria.veterinaria.repository.TipoServicioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TipoServicioService {

    private final TipoServicioRepository tipoServicioRepository;

    public TipoServicioService(TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }

    public List<TipoServicio> listarTiposServicio() {
        return tipoServicioRepository.findAll();
    }

    public TipoServicio buscarTipoServicio(Integer id) {
        return tipoServicioRepository.findById(id).orElse(null);
    }

    public TipoServicio guardarTipoServicio(TipoServicio tipoServicio) {
        return tipoServicioRepository.save(tipoServicio);
    }

    public void eliminarTipoServicio(Integer id) {
        tipoServicioRepository.deleteById(id);
    }

    public long contarServicios() {
        return tipoServicioRepository.count();
    }
}