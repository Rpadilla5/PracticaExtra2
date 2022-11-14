package com.hiberus.practicaExtra2.prendas.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prenda {
    @Id
    String referencia;
    String familia;
    String nombre;
    String descripcion;
    float precioBase;
    char talla;
}
