package com.br.univesp.gatominiobackend.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "visita_veterinario")
public class VisitaVeterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "registro_veterinario_id")
    private RegistroVeterinario idRegistroVeterinario;

    private String diagnostico;

    private String motivo;

    private String tratamento;

    private LocalDateTime dataVisita;
}
