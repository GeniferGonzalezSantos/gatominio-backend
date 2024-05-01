package com.br.univesp.gatominiobackend.DTO;

import com.br.univesp.gatominiobackend.entity.RegistroVeterinario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegistroVeterinarioDTO {

    private Long idGato;
    private String diagnostico;
    private String motivo;
    private String tratamento;

    public RegistroVeterinarioDTO(List<RegistroVeterinario> registroVeterinario) {
        for (RegistroVeterinario registro : registroVeterinario) {
            this.idGato = registro.getIdGato().getId();
            this.diagnostico = registro.getDiagnostico();
            this.motivo = registro.getMotivo();
            this.tratamento = registro.getTratamento();
        }
    }
}
