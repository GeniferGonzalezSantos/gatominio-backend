package com.br.univesp.gatominiobackend.service.impl;

import com.br.univesp.gatominiobackend.DTO.RegistroVeterinarioDTO;
import com.br.univesp.gatominiobackend.DTO.RetornoGatoDTO;
import com.br.univesp.gatominiobackend.entity.CatProfile;
import com.br.univesp.gatominiobackend.repository.GatosRepository;
import com.br.univesp.gatominiobackend.repository.RegistroVeterianarioRepository;
import com.br.univesp.gatominiobackend.service.GatosService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public RetornoGatoDTO salvarGatoComFoto(CatProfile catProfile, MultipartFile image) {
        handleCatImage(catProfile, image);
        var dto = new RetornoGatoDTO(catProfile);
        return dto;
    }

    @Override
    public RetornoGatoDTO salvarGato(CatProfile catProfile) {
        var catProfileSaved = gatosRepository.save(catProfile);
        var dto = new RetornoGatoDTO(catProfileSaved);
        return dto;
    }

    @Override
    public void excluirGato(Long idGato) {
        gatosRepository.deleteById(idGato);
    }

    public void handleCatImage(CatProfile catProfile, MultipartFile image) {
        try {
            // Define the directory where the image will be saved
            String directory = "src/main/resources/static/cat_profile_images/";
            byte[] bytes = image.getBytes();

            // Create the directory if it does not exist
            Path path = Paths.get(directory);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            // Define the path to the image file
            Path filePath = Paths.get(directory + catProfile.getNome()+"_"+catProfile.getTutor()+ ".jpg");

            // Save the image
            Files.write(filePath, bytes);

            // Update the CatProfile entity with the path to the image
            catProfile.setFotoPerfil(filePath.toString());

            // Save the updated CatProfile entity
            gatosRepository.save(catProfile);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
}
