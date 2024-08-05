package com.example.servicestoreproject.controller;

import com.example.servicestoreproject.dto.StoreDto;
import com.example.servicestoreproject.entity.StockHistory;
import com.example.servicestoreproject.service.FeignClient.ProductInterface;
import com.example.servicestoreproject.service.StockHistory.StockHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/stock")
@Tag(name="stock history service")
public class StockHistoryController {

    private final StockHistoryService stockHistoryService;
    @Autowired
    public StockHistoryController(StockHistoryService stockHistoryService) {
        this.stockHistoryService = stockHistoryService;
    }
    @Autowired
    private ProductInterface productInterface;

    @PostMapping("/{id}/addstock")
    @Operation(summary = "  add stock")
    public ResponseEntity<String> addStock(@RequestParam int amount, @PathVariable int id){
        stockHistoryService.addStock(id,amount);

        return new ResponseEntity<>("stock added successfully", HttpStatus.CREATED);
    }


    @PostMapping("/{id}/consumestock")
    @Operation(summary = "  consume stock")
    public ResponseEntity<String> consumeStock(@RequestParam int amount, @PathVariable int id){
        if(productInterface.getProduct(id).getStock_quantity()<amount){
            return new ResponseEntity<>("amount not enough", HttpStatus.CREATED);
        }
        else {
            stockHistoryService.consumeStock(id, amount);
            return new ResponseEntity<>("stock consumed successfully", HttpStatus.CREATED);
        }
    }
    @GetMapping("/getallstockhistorires")
    @Operation(summary = "get all stock histories")
    public ResponseEntity<List<StockHistory>> getAll(){
        return new ResponseEntity<>(stockHistoryService.getAllStockHistories(),HttpStatus.OK);
    }

    @GetMapping("{id}/getallstockhistorires")
    @Operation(summary = "get all stock histories for a certain product")
    public ResponseEntity<List<StockHistory>> getAllStock(@PathVariable int id){
        return new ResponseEntity<>(stockHistoryService.getStockHistoryByid(id),HttpStatus.OK);
    }
    @GetMapping("{id}/isavailable")
    @Operation(summary = "check if product is available or not")
    public ResponseEntity<Boolean> isavailable(@PathVariable int id){
        return new ResponseEntity<>(stockHistoryService.checkAvailability(id),HttpStatus.OK);
    }

}
