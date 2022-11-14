package com.hiberus.practicaExtra2.stock.controller;

import com.hiberus.practicaExtra2.library.StockDTO;
import com.hiberus.practicaExtra2.stock.domain.Stock;
import com.hiberus.practicaExtra2.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired
    StockRepository stockRepository;

    @PostMapping(value = "/insertarStock")
    public @ResponseBody  ResponseEntity<?> insertarStock(StockDTO stockDTO){
        if(true) {
            Stock stock = Stock.builder()
                    .almacen(stockDTO.getAlmacen())
                    .idprenda(stockDTO.getIdprenda())
                    .talla(stockDTO.getTalla())
                    .cantidad(stockDTO.getCantidad())
                    .fechaNuevaLlegada(stockDTO.getFechaNuevaLlegada())
                    .build();

            stockRepository.save(stock);
            return new ResponseEntity<>("Stock creado", HttpStatus.OK);

        }
        return new ResponseEntity<>("Peticion erronea", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/verStock")
    public @ResponseBody List<Stock> verStock(){
        return stockRepository.findAll();
    }
}
