package com.br.univesp.gatominiobackend.service;

import com.br.univesp.gatominiobackend.DTO.RetornoGatoDTO;
import com.br.univesp.gatominiobackend.entity.CatProfile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GatosService {
   RetornoGatoDTO buscarGato(Long idGato);
   List<RetornoGatoDTO> listarGatos();
   RetornoGatoDTO salvarGatoComFoto(CatProfile catProfile, MultipartFile image);

   RetornoGatoDTO salvarGato(CatProfile catProfile);
}
