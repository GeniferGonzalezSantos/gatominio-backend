package com.br.univesp.gatominiobackend.repository;

import com.br.univesp.gatominiobackend.entity.CatProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatosRepository extends JpaRepository<CatProfile, Long> {

}
