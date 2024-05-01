package com.br.univesp.gatominiobackend.DTO;

import com.br.univesp.gatominiobackend.entity.CatProfile;
import com.br.univesp.gatominiobackend.entity.RegistroVeterinario;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class RetornoGatoDTO {
    private Long id;
    private String caracteristica;
    private Boolean isCastrado;
    private Boolean isFelv;
    private Boolean isFiv;
    private Integer idade;
    private String nome;
    private String endereco;
    private String tutor;
    private List<RegistroVeterinarioDTO> registroVeterinario = new ArrayList<>();


    public RetornoGatoDTO(CatProfile catProfile) {
        this.id = catProfile.getId();
        this.caracteristica = catProfile.getCaracteristica();
        this.isCastrado = catProfile.getIsCastrado();
        this.isFelv = catProfile.getIsFelv();
        this.isFiv = catProfile.getIsFiv();
        this.idade = catProfile.getIdade();
        this.nome = catProfile.getNome();
        this.endereco = catProfile.getEndereco();
        this.tutor = catProfile.getTutor();
        if (catProfile.getRegistroVeterinario() != null)
            this.registroVeterinario = new RegistroVeterinarioDTO().retornaListaRegistrosDto(catProfile.getRegistroVeterinario());

    }

    public void addRegistroVeterinario(RegistroVeterinarioDTO registroVeterinario) {
        this.registroVeterinario.add(registroVeterinario);
    }
}
