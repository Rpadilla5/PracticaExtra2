package com.hiberus.practicaExtra.recursos.repository;

import com.hiberus.practicaExtra.recursos.domain.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media,String> {
    public Media findByProductoAsociado(String productoAsociado);
}
