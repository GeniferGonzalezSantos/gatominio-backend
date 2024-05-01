package com.br.univesp.gatominiobackend.repository;

import com.br.univesp.gatominiobackend.entity.RegistroVeterinario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroVeterianarioRepository extends JpaRepository<RegistroVeterinario, Long>{

    List<RegistroVeterinario> findByIdGato_id(Long idGato);
}
