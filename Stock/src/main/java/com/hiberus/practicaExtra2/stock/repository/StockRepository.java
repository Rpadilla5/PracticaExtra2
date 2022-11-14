package com.hiberus.practicaExtra2.stock.repository;

import com.hiberus.practicaExtra2.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
    List<Stock> findByidprenda(String idprenda);
    List<Stock> findByAlmacen(String almacen);
    Stock findByAlmacenAndIdprendaAndTalla(String almacen, String idprenda, char talla);
}
