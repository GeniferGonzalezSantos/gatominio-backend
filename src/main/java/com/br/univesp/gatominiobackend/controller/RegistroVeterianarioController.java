package com.br.univesp.gatominiobackend.controller;

import com.br.univesp.gatominiobackend.DTO.RegistroVeterinarioDTO;
import com.br.univesp.gatominiobackend.entity.CatProfile;
import com.br.univesp.gatominiobackend.entity.RegistroVeterinario;
import com.br.univesp.gatominiobackend.repository.GatosRepository;
import com.br.univesp.gatominiobackend.repository.RegistroVeterianarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
public class RegistroVeterianarioController {

    private  final RegistroVeterianarioRepository registroVeterianarioRepository;
    private final GatosRepository gatosRepository;

    public RegistroVeterianarioController(RegistroVeterianarioRepository registroVeterianarioRepository, GatosRepository gatosRepository) {
        this.registroVeterianarioRepository = registroVeterianarioRepository;
        this.gatosRepository = gatosRepository;
    }
    @CrossOrigin
    @GetMapping("/buscarRegistroVeterinario/{idGato}")
    public ResponseEntity<List<RegistroVeterinario>> searchRegistroVeterinario(@PathVariable(value = "idGato") Long idGato) {

        var registroVeterinario = registroVeterianarioRepository.findByIdGato_id(idGato);
        return ResponseEntity.ok(registroVeterinario);
    }

    @CrossOrigin
    @PostMapping("/salvarRegistroVeterinario/{idGato}")
    public ResponseEntity<RegistroVeterinarioDTO> saveRegistroVeterinario(@PathVariable(value = "idGato") Long idGato, @RequestBody RegistroVeterinarioDTO dto) {
        CatProfile catProfile = gatosRepository.findById(idGato).get();
        RegistroVeterinario registroVeterinario = new RegistroVeterinario();
        registroVeterinario.setIdGato(catProfile);
        registroVeterinario.setDiagnostico(dto.getDiagnostico());
        registroVeterinario.setMotivo(dto.getMotivo());
        registroVeterinario.setTratamento(dto.getTratamento());
        registroVeterinario.setDataConsulta(dto.getDataConsulta());
        registroVeterianarioRepository.save(registroVeterinario);
        return ResponseEntity.created(URI.create("/buscarRegistroVeterinario/" + catProfile.getId())).body(new RegistroVeterinarioDTO(registroVeterinario));
    }
}
