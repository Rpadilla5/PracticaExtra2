package com.hiberus.practicaExtra.recursos.controller;

import com.hiberus.practicaExtra.recursos.domain.Media;
import com.hiberus.practicaExtra.recursos.domain.Slogan;
import com.hiberus.practicaExtra.recursos.repository.MediaRepository;
import com.hiberus.practicaExtra.recursos.repository.SloganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/recursos")
public class RecursosController {

    @Autowired
    MediaRepository mediaRepository;

    @Autowired
    SloganRepository sloganRepository;

    @GetMapping(value = "/verMedia/{idProducto}")
    public Media obtenerMediaDeProducto(@PathVariable String idProducto){
        return mediaRepository.findByProductoAsociado(idProducto);
    }

    @GetMapping(value = "/verSlogan/{idFamilia}")
    public Slogan obtenerSloganDeFamilia(@PathVariable String idFamilia){
        return sloganRepository.findByFamiliaAsociada(idFamilia);
    }
}
