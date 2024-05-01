package com.br.univesp.gatominiobackend.service;

import com.br.univesp.gatominiobackend.DTO.RetornoGatoDTO;
import com.br.univesp.gatominiobackend.entity.CatProfile;

import java.util.List;

public interface GatosService {
   RetornoGatoDTO buscarGato(Long idGato);
   List<RetornoGatoDTO> listarGatos();
   RetornoGatoDTO salvarGato(CatProfile catProfile);
}
