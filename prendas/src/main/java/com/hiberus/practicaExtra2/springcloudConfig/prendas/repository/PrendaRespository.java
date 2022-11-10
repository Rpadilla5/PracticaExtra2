package com.hiberus.practicaExtra2.springcloudConfig.prendas.repository;

import com.hiberus.practicaExtra2.springcloudConfig.prendas.domain.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrendaRespository extends JpaRepository<Prenda,String> {
}
