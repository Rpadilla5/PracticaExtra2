package com.hiberus.practicaExtra2.library;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockPrenda {
    String idPrenda;
    int cantidadS;
    int cantidadM;
    int cantidadL;

    //String fechaNuevaLlegada;

}
