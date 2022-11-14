package com.hiberus.practicaExtra2.prendas.controller;

import com.hiberus.practicaExtra2.prendas.repository.PrendaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/prendas")
public class PrendasController {
    @Autowired
    PrendaRespository prendaRespository;

    @GetMapping(value = "/verPrendas")
    public @ResponseBody ResponseEntity<?> verPrendas(){
        return new ResponseEntity<>("funciona", HttpStatus.OK);
    }

    @GetMapping(value = "/existePrenda/{idPrenda}")
    public @ResponseBody boolean existePrenda(@PathVariable String idPrenda){
        if (prendaRespository.findById(idPrenda).isPresent()){
            return true;
        }
        return true;
    }
}
