package com.br.univesp.gatominiobackend.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "registro_veterinario")
public class RegistroVeterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cat_profile_id")
    private CatProfile idGato;

    @OneToMany(mappedBy = "idRegistroVeterinario", cascade = CascadeType.ALL)
    private List<VisitaVeterinario> visitasVeterinario;

    @OneToMany(mappedBy = "idRegistroVeterinario", cascade = CascadeType.ALL)
    private List<Medicamento> medicacaoAplicada;

    private String diagnostico;

    private String motivo;
    
    private String tratamento;

}