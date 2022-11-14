package com.hiberus.practicaExtra2.stock.repository;

import com.hiberus.practicaExtra2.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Integer> {
}
