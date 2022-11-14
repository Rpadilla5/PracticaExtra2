package com.hiberus.practicaExtra2.stock.controller;

import com.hiberus.practicaExtra2.library.StockDTO;
import com.hiberus.practicaExtra2.library.StockPrenda;
import com.hiberus.practicaExtra2.stock.domain.Stock;
import com.hiberus.practicaExtra2.stock.repository.StockRepository;
import com.hiberus.practicaExtra2.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockService stockService;

    @PostMapping(value = "/insertarStock")
    public @ResponseBody  ResponseEntity<?> insertarStock(@RequestBody StockDTO stockDTO){
        if(stockService.insertarStock(stockDTO)) {
            return new ResponseEntity<>("Stock creado", HttpStatus.OK);
        }
        return new ResponseEntity<>("Peticion erronea", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/verStock")
    public @ResponseBody List<Stock> verStock(){
        return stockRepository.findAll();
    }

    @GetMapping(value = "/verStock/almacen/{idAlmacen}")
    public @ResponseBody ResponseEntity<?> verStockDeUnAlmacen(@PathVariable String idAlmacen){
        if (!stockRepository.findByAlmacen(idAlmacen).isEmpty()){
            return new ResponseEntity<>(stockRepository.findByAlmacen(idAlmacen),HttpStatus.OK);
        }
        return new ResponseEntity<>("no existe el almacen",HttpStatus.BAD_REQUEST);
    }
    @GetMapping(value = "/verStock/prenda/{idPrenda}")
    public @ResponseBody ResponseEntity<?> verStockDeUnaPrenda(@PathVariable String idPrenda){
        if (!stockRepository.findByidprenda(idPrenda).isEmpty()) {
            StockPrenda stockPrenda = stockService.verStockPrenda(idPrenda);
            if (stockPrenda.getCantidadS() + stockPrenda.getCantidadM() + stockPrenda.getCantidadL() == 0) {
                return new ResponseEntity<>("no hay stok, la fecha es: " + stockService.ObtenerFecha(idPrenda), HttpStatus.OK);
            }
            return new ResponseEntity<>(stockPrenda, HttpStatus.OK);
        }
        return new ResponseEntity<>("Peticion erronea",HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/modificarStock")
    public @ResponseBody ResponseEntity<?> modificarStock(@RequestParam String almacen, @RequestParam String idPrenda, @RequestParam char talla, @RequestParam int cantidad){
        if (stockService.modificarCantidadStock(almacen, idPrenda, talla, cantidad)){
            return new ResponseEntity<>("Stock modificado", HttpStatus.OK);
        }
        return new ResponseEntity<>("Peticion erronea", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/modificarFecha")
    public @ResponseBody ResponseEntity<?> modificarFecha(@RequestParam String almacen, @RequestParam String idPrenda, @RequestParam char talla, @RequestParam String fecha){
        if (stockService.modificarFecha( almacen, idPrenda, talla, fecha)){
            return new ResponseEntity<>("Fecha modificada", HttpStatus.OK);
        }
        return new ResponseEntity<>("Peticion erronea", HttpStatus.BAD_REQUEST);
    }
}
