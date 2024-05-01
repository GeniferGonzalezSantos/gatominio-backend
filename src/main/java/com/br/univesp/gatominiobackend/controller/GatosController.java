package com.br.univesp.gatominiobackend.controller;

import com.br.univesp.gatominiobackend.DTO.RetornoGatoDTO;
import com.br.univesp.gatominiobackend.entity.CatProfile;
import com.br.univesp.gatominiobackend.service.GatosService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GatosController {
    private final GatosService gatosService;

    public GatosController(GatosService gatosService) {
        this.gatosService = gatosService;
    }

    @GetMapping("/buscarGato/{idGato}")
    public ResponseEntity<RetornoGatoDTO> searchCatProfile(@PathVariable(value = "idGato") Long idGato) {
        var catProfile = gatosService.buscarGato(idGato);

       return ResponseEntity.ok(catProfile);
    }

    @GetMapping("/buscarGato")
    public ResponseEntity<Iterable<RetornoGatoDTO>> searchAllCatProfile() {
        var catProfile = gatosService.listarGatos();
        return ResponseEntity.ok(catProfile);
    }

    @PostMapping("/salvarGato")
    public ResponseEntity<RetornoGatoDTO> saveCatProfile(@RequestBody  CatProfile catProfile) {
        var dto = gatosService.salvarGato(catProfile);
        return ResponseEntity.ok(dto);

    }

}
