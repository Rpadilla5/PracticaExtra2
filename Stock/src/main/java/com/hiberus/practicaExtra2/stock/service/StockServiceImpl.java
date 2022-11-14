package com.hiberus.practicaExtra2.stock.service;

import com.hiberus.practicaExtra2.library.StockDTO;
import com.hiberus.practicaExtra2.library.StockPrenda;
import com.hiberus.practicaExtra2.stock.domain.Stock;
import com.hiberus.practicaExtra2.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    RestTemplate restTemplate=new RestTemplate();
    @Autowired
    StockRepository stockRepository;
    public boolean insertarStock(StockDTO stockDTO){
        if (posibleInsertar(stockDTO)) {
            Stock stock = Stock.builder()
                    .almacen(stockDTO.getAlmacen())
                    .idprenda(stockDTO.getIdprenda())
                    .talla(stockDTO.getTalla())
                    .cantidad(stockDTO.getCantidad())
                    .fechaNuevaLlegada(stockDTO.getFechaNuevaLlegada())
                    .build();
            stockRepository.save(stock);
            return true;
        }
        return false;
    }

    private boolean posibleInsertar(StockDTO stockDTO){
        String URI = "http://localhost:8089/prendas/existePrenda/" + stockDTO.getIdprenda();
        boolean respuesta=restTemplate.getForObject(URI, boolean.class);
        if (respuesta && stockDTO.getCantidad()>=0 && ('S'==stockDTO.getTalla() || 'M'==stockDTO.getTalla()  || 'L'==stockDTO.getTalla())) {
            return true;
        }
        return false;
    }

    public boolean modificarCantidadStock( String almacen,  String idPrenda,  char talla,  int cantidad){
        if (!(stockRepository.findByAlmacenAndIdprendaAndTalla(almacen,idPrenda,talla)==null)){
            Stock stock =stockRepository.findByAlmacenAndIdprendaAndTalla(almacen,idPrenda,talla);
            stock.setCantidad(cantidad);
            stockRepository.save(stock);
            return true;
        }
        return false;
    }

    public  boolean modificarFecha( String almacen,  String idPrenda,  char talla,  String fecha){
        if (!(stockRepository.findByAlmacenAndIdprendaAndTalla(almacen,idPrenda,talla)==null)){
            Stock stock =stockRepository.findByAlmacenAndIdprendaAndTalla(almacen,idPrenda,talla);
            stock.setFechaNuevaLlegada(fecha);
            stockRepository.save(stock);
            return true;
        }
        return false;
    }

    public StockPrenda verStockPrenda(String idPrenda){
        StockPrenda stockPrenda = StockPrenda.builder()
                .idPrenda(idPrenda)
                .cantidadS(0)
                .cantidadM(0)
                .cantidadL(0)
                .build();
        if (!stockRepository.findByidprenda(idPrenda).isEmpty()) {
            List<Stock> stocks = stockRepository.findByidprenda(idPrenda);
            for (Stock aux : stocks) {
                if (aux.getTalla() == 'S') {
                    stockPrenda.setCantidadS(stockPrenda.getCantidadS() + aux.getCantidad());
                }
                if (aux.getTalla() == 'M') {
                    stockPrenda.setCantidadM(stockPrenda.getCantidadM() + aux.getCantidad());
                }
                if (aux.getTalla() == 'L') {
                    stockPrenda.setCantidadS(stockPrenda.getCantidadL() + aux.getCantidad());
                }
            }
            return stockPrenda;

        }
        return stockPrenda;
    }

    public String ObtenerFecha(String idPrenda){
        List<Stock> stocks = stockRepository.findByidprenda(idPrenda);
        return  stocks.get(0).getFechaNuevaLlegada();
    }


}
