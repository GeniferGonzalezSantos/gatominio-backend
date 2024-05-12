package com.br.univesp.gatominiobackend.controller;

import com.br.univesp.gatominiobackend.DTO.RetornoGatoDTO;
import com.br.univesp.gatominiobackend.entity.CatProfile;
import com.br.univesp.gatominiobackend.service.GatosService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Controller
public class GatosController {
    private final GatosService gatosService;

    public GatosController(GatosService gatosService) {
        this.gatosService = gatosService;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/buscarGatoComFoto/{idGato}")
    public ResponseEntity<RetornoGatoDTO> searchCatProfile(@PathVariable(value = "idGato") Long idGato) {
        var catProfile = gatosService.buscarGato(idGato);
        Path path = Paths.get(catProfile.getLink_foto());
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
            byte[] imageBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
            String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
            catProfile.setLink_foto(imageBase64);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return ResponseEntity.ok(catProfile);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/buscarGato/{idGato}")
    public ResponseEntity<RetornoGatoDTO> searchCat(@PathVariable(value = "idGato") Long idGato) {
        var catProfile = gatosService.buscarGato(idGato);
        return ResponseEntity.ok(catProfile);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscarGato")
    public ResponseEntity<Iterable<RetornoGatoDTO>> searchAllCatProfile() {
        var catProfile = gatosService.listarGatos();
        return ResponseEntity.ok(catProfile);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/salvarGatoComFoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RetornoGatoDTO> saveCatProfileWithImage(@RequestPart("catProfile") CatProfile catProfile, @RequestParam("image") MultipartFile image) {
        var dto = gatosService.salvarGatoComFoto(catProfile, image);
        return ResponseEntity.ok(dto);

    }
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/salvarGato")
    public ResponseEntity<RetornoGatoDTO> saveCatProfile(@RequestBody CatProfile catProfile) {
        var dto = gatosService.salvarGato(catProfile);
        return ResponseEntity.ok(dto);

    }

}
