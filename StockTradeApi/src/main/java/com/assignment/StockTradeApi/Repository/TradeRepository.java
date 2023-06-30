package com.assignment.StockTradeApi.Repository;

import com.assignment.StockTradeApi.Entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {


}
