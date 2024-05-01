package com.br.univesp.gatominiobackend.service.impl;

import com.br.univesp.gatominiobackend.DTO.RegistroVeterinarioDTO;
import com.br.univesp.gatominiobackend.DTO.RetornoGatoDTO;
import com.br.univesp.gatominiobackend.entity.CatProfile;
import com.br.univesp.gatominiobackend.repository.GatosRepository;
import com.br.univesp.gatominiobackend.repository.RegistroVeterianarioRepository;
import com.br.univesp.gatominiobackend.service.GatosService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GatosServiceImpl implements GatosService {

    private final GatosRepository gatosRepository;
    private final RegistroVeterianarioRepository registroVeterianarioRepository;

    public GatosServiceImpl(GatosRepository gatosRepository, RegistroVeterianarioRepository registroVeterianarioRepository) {
        this.gatosRepository = gatosRepository;
        this.registroVeterianarioRepository = registroVeterianarioRepository;
    }

    @Override
    public RetornoGatoDTO buscarGato(Long idGato) {
        var catProfile = gatosRepository.findById(idGato);
        RetornoGatoDTO retornoGatoDTO = new RetornoGatoDTO(catProfile.get());
        var registroVeterinario = registroVeterianarioRepository.findByIdGato_id(idGato);

        if (registroVeterinario.get(0) != null) {
            var registroVeterinarioDto = new RegistroVeterinarioDTO(registroVeterinario);
            retornoGatoDTO.addRegistroVeterinario(registroVeterinarioDto);
        }
        return retornoGatoDTO;

    }

    @Override
    public List<RetornoGatoDTO> listarGatos() {
        return List.of();
    }

    @Override
    public RetornoGatoDTO salvarGato(CatProfile catProfile) {
        return null;
    }
}
