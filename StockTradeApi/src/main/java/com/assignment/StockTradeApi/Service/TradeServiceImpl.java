package com.assignment.StockTradeApi.Service;

import com.assignment.StockTradeApi.Entity.Trade;
import com.assignment.StockTradeApi.Repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeRepository tradeRepository;
    @Override
    public Trade saveEntity(Trade trade) {

        return tradeRepository.save(trade);
    }

    @Override
    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    @Override
    public Optional<Trade> findById(int tradeId) {
        return tradeRepository.findById(tradeId);
    }
}
