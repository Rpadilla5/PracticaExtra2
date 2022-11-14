package com.hiberus.practicaExtra2.stock.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idStock;

    String almacen;
    String idprenda;
    char talla;
    int cantidad;
    String fechaNuevaLlegada;
}
