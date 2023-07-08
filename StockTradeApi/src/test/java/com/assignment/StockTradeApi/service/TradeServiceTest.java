package com.assignment.StockTradeApi.service;

import com.assignment.StockTradeApi.Entity.Trade;
import com.assignment.StockTradeApi.Repository.TradeRepository;
import com.assignment.StockTradeApi.Service.TradeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TradeServiceTest {

    @Mock
    TradeRepository repository;

    @InjectMocks
    TradeServiceImpl service;

    @Test
    void saveTest(){

        Trade trade1 = Trade.builder()
                .userId(23)
                .type("buy")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Trade trade2 = Trade.builder()
                .id(1)
                .userId(23)
                .type("buy")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Mockito.when(repository.save(trade1)).thenReturn(trade2);

        Assertions.assertNotNull(service.saveEntity(trade1).getId());

    }

    @Test
    void getAllTest(){

        Trade trade1 = Trade.builder()
                .id(1)
                .userId(23)
                .type("buy")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Trade trade2 = Trade.builder()
                .id(2)
                .userId(33)
                .type("sell")
                .symbol("GOOGL")
                .shares(40)
                .price(200)
                .timestamp(153152270900L).build();

        Trade trade3 = Trade.builder()
                .id(3)
                .userId(56)
                .type("sell")
                .symbol("APPL")
                .shares(50)
                .price(350)
                .timestamp(153152270600L).build();

        List<Trade> list = new ArrayList<>();
        list.add(trade1);
        list.add(trade2);
        list.add(trade3);

        Mockito.when(repository.findAll()).thenReturn(list);

        Assertions.assertEquals(service.getAllTrades().size(),3);
    }

    @Test
    void getByTradeIdTest(){

        Trade trade1 = Trade.builder()
                .id(1)
                .userId(23)
                .type("buy")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(trade1));

        Assertions.assertTrue(service.findById(1).isPresent());

    }
}
