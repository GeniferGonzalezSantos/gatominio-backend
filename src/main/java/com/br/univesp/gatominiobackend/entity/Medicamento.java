package com.br.univesp.gatominiobackend.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "registro_veterinario_id")
    private RegistroVeterinario idRegistroVeterinario;

    private String marcaMedicamento;
    private String tipoMedicamento;
    private LocalDate ultimaDose;
    private LocalDate proximaDose;
}
