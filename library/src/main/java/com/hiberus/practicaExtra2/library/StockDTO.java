package com.hiberus.practicaExtra2.library;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class StockDTO {

    String almacen;
    String idprenda;
    char talla;
    int cantidad;
    String fechaNuevaLlegada;
}
