package com.hiberus.practicaExtra.recursos.repository;

import com.hiberus.practicaExtra.recursos.domain.Media;
import com.hiberus.practicaExtra.recursos.domain.Slogan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SloganRepository extends JpaRepository<Slogan,String> {
    public Slogan findByFamiliaAsociada(String familiaAsociada);

}
