package com.hiberus.practicaExtra2.library;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class StockDTO {

    String almacen;
    String idprenda;
    char talla;
    int cantidad;
    String fechaNuevaLlegada;
}
