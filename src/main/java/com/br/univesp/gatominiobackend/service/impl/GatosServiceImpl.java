package com.br.univesp.gatominiobackend.service.impl;

import com.br.univesp.gatominiobackend.DTO.RegistroVeterinarioDTO;
import com.br.univesp.gatominiobackend.DTO.RetornoGatoDTO;
import com.br.univesp.gatominiobackend.entity.CatProfile;
import com.br.univesp.gatominiobackend.repository.GatosRepository;
import com.br.univesp.gatominiobackend.repository.RegistroVeterianarioRepository;
import com.br.univesp.gatominiobackend.service.GatosService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return retornoGatoDTO;

    }

    @Override
    public List<RetornoGatoDTO> listarGatos() {
        var dtoList = new ArrayList<RetornoGatoDTO>();
        var listaGatos = gatosRepository.findAll();
        for (CatProfile catProfile : listaGatos) {
            var retornoGatoDTO = new RetornoGatoDTO(catProfile);

            dtoList.add(retornoGatoDTO);
        }
        return dtoList;
    }

    @Override
    public RetornoGatoDTO salvarGato(CatProfile catProfile) {
        gatosRepository.save(catProfile);
        var dto = new RetornoGatoDTO(catProfile);
        return dto;
    }
}
