package com.hiberus.practicaExtra.recursos.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medias")
public class Media {
    @Id
    String identificador;
    String rutaImagen;
    String dimension;
    String prioridadCarrusel;
    String productoAsociado;
}
