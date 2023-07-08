package com.assignment.StockTradeApi.controller;

import com.assignment.StockTradeApi.Entity.Trade;
import com.assignment.StockTradeApi.Service.TradeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest
public class TradeControllerTest {


    @MockBean
    public TradeService service;

    @Autowired
    public MockMvc mockMvc;

    @Test
    void saveTest() throws Exception {

        Trade trade1 = Trade.builder()
                .userId(23)
                .type("BUY")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Trade trade2 = Trade.builder()
                .id(1)
                .userId(23)
                .type("BUY")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Mockito.when(service.saveEntity(trade1)).thenReturn(trade2);

        mockMvc.perform(MockMvcRequestBuilders.post("/trades").contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\"userId\":23,\n" +
                                "\"type\":\"BUY\",\n" +
                                "\"symbol\":\"ABX\",\n" +
                                "\"shares\":30,\n" +
                                "\"price\":134,\n" +
                                "\"timestamp\":153152270100\n" +
                                "}")).andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(trade1.getUserId()));
    }

    @Test
    void getAllTest() throws Exception {

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

        Mockito.when(service.getAllTrades()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/trades").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].userId").value(trade1.getUserId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(Matchers.hasSize(3)));

    }

    @Test
    void getByTradeId() throws Exception {


        Trade trade = Trade.builder()
                .id(1)
                .userId(23)
                .type("buy")
                .symbol("ABX")
                .shares(30)
                .price(134)
                .timestamp(153152270100L).build();

        Mockito.when(service.findById(1)).thenReturn(Optional.ofNullable(trade));

        mockMvc.perform(MockMvcRequestBuilders.get("/trades/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(trade.getUserId()));




    }
}
