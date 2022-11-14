package com.hiberus.practicaExtra2.prendas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/prendas")
public class PrendasController {

    @GetMapping(value = "/verPrendas")
    public @ResponseBody ResponseEntity<?> verPrendas(){
        return new ResponseEntity<>("funciona", HttpStatus.OK);
    }
}
