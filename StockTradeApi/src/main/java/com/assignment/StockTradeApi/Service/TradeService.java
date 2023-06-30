package com.assignment.StockTradeApi.Service;

import com.assignment.StockTradeApi.Entity.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeService {

    public Trade saveEntity(Trade trade);

    public List<Trade> getAllTrades();

    public Optional<Trade> findById(int tradeId);
}
