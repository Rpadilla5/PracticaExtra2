package com.hiberus.practicaExtra.recursos.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Slogans")
public class Slogan {
    @Id
    String identificador;
    String textoSlogan;
    String textoAlternativo;
    String familiaAsociada;
}
