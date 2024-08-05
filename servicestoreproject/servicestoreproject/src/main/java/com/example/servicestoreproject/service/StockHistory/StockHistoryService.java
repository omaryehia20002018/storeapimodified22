package com.example.servicestoreproject.service.StockHistory;

import com.example.servicestoreproject.entity.StockHistory;

import java.util.List;

public interface StockHistoryService {
    public void addStock(int productid, int amount);
    public void consumeStock(int productid, int amount);
    public List<StockHistory>getAllStockHistories();

    public List<StockHistory>getStockHistoryByid(int id);
    public boolean checkAvailability(int id);
}
