package com.br.univesp.gatominiobackend.DTO;

import com.br.univesp.gatominiobackend.entity.RegistroVeterinario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistroVeterinarioDTO {

    @JsonIgnore
    private Long idGato;
    private String diagnostico;
    private String motivo;
    private String tratamento;
    private String dataConsulta;
    public RegistroVeterinarioDTO() {
    }

    public RegistroVeterinarioDTO(List<RegistroVeterinario> registroVeterinario) {
        for (RegistroVeterinario registro : registroVeterinario) {
            this.diagnostico = registro.getDiagnostico();
            this.motivo = registro.getMotivo();
            this.tratamento = registro.getTratamento();
            this.dataConsulta = registro.getDataConsulta();
        }
    }


    public RegistroVeterinarioDTO(RegistroVeterinario registroVeterinario) {
        this.idGato = registroVeterinario.getIdGato().getId();
        this.diagnostico = registroVeterinario.getDiagnostico();
        this.motivo = registroVeterinario.getMotivo();
        this.tratamento = registroVeterinario.getTratamento();
    }
    public List<RegistroVeterinarioDTO> retornaListaRegistrosDto(List<RegistroVeterinario> registroVeterinario){
        var listaDtos = new ArrayList<RegistroVeterinarioDTO>();
        for (RegistroVeterinario registro : registroVeterinario) {
            var dto = new RegistroVeterinarioDTO();
            dto.setDiagnostico(registro.getDiagnostico());
            dto.setMotivo(registro.getMotivo());
            dto.setTratamento(registro.getTratamento());
            dto.setDataConsulta(registro.getDataConsulta());
            listaDtos.add(dto);
        }
        return listaDtos;
    }
}
