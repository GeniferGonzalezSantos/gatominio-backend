package com.br.univesp.gatominiobackend.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cat_profile")
public class CatProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "caracteristica")
    private String caracteristica;
    @Column(name = "indicador_castracao")
    private Boolean isCastrado;
    @Column(name = "indicador_felv")
    private Boolean isFelv;
    @Column(name = "indicador_fiv")
    private Boolean isFiv;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "nome_tutor")
    private String tutor;

    @OneToMany(mappedBy = "idGato", cascade = CascadeType.ALL )
    private List<RegistroVeterinario> registroVeterinario;


}
