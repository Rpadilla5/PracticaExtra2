package com.hiberus.practicaExtra2.stock.service;

import com.hiberus.practicaExtra2.library.StockDTO;
import com.hiberus.practicaExtra2.library.StockPrenda;
import com.hiberus.practicaExtra2.stock.domain.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public interface StockService{

    public boolean insertarStock(StockDTO stockDTO);
    public boolean modificarCantidadStock( String almacen,  String idPrenda,  char talla,  int cantidad);
    public  boolean modificarFecha( String almacen,  String idPrenda,  char talla,  String fecha);

    public StockPrenda verStockPrenda(String idPrenda);
    public String ObtenerFecha(String idPrenda);

}
