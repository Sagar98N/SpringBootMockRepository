package com.assignment.StockTradeApi.repository;

import com.assignment.StockTradeApi.Entity.Trade;
import com.assignment.StockTradeApi.Repository.TradeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TradeRepositoryTest {

    @Autowired
    TradeRepository repository;

    @Test
    void saveTest(){

        Trade trade1 = Trade.builder()
                .userId(23)
                .type("BUY")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Assertions.assertEquals(repository.save(trade1).getUserId(),trade1.getUserId());

    }

    @Test
    void getAllTest(){
        Trade trade1 = Trade.builder()
                .userId(23)
                .type("buy")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Trade trade2 = Trade.builder()
                .userId(33)
                .type("sell")
                .symbol("GOOGL")
                .shares(40)
                .price(200)
                .timestamp(153152270900L).build();

        Trade trade3 = Trade.builder()
                .userId(56)
                .type("sell")
                .symbol("APPL")
                .shares(50)
                .price(350)
                .timestamp(153152270600L).build();

        repository.save(trade1);
        repository.save(trade2);
        repository.save(trade3);

        Assertions.assertEquals(repository.findAll().size(),3);
    }


    @Test
    void getByTradeIdTest(){

        Trade trade1 = Trade.builder()
                .userId(23)
                .type("buy")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Trade trade2 = repository.save(trade1);

        Assertions.assertTrue(repository.findById(trade2.getId()).isPresent());

    }
}
