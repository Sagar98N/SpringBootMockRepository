package com.assignment.StockTradeApi.Controller;



import com.assignment.StockTradeApi.Entity.Trade;
import com.assignment.StockTradeApi.Service.TradeService;
import com.assignment.StockTradeApi.Service.TradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @PostMapping("/trades")
    public ResponseEntity<Trade> save(@RequestBody Trade trade){
        Trade trade1 = tradeService.saveEntity(trade);
        return new ResponseEntity<>(trade1, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/trades")
    public ResponseEntity<List<Trade>> getAll(){
        List<Trade> list = tradeService.getAllTrades();
        return  new ResponseEntity<>(list, HttpStatusCode.valueOf(201));
    }



    @GetMapping("/trades/{tradeId}")
    public ResponseEntity<Optional<Trade>> getByTradeId(@PathVariable int tradeId){
        Optional<Trade> trade = tradeService.findById(tradeId);
        if(trade.isPresent()){
            return  new ResponseEntity<>(trade, HttpStatusCode.valueOf(200));
        }

        return new ResponseEntity<>(HttpStatusCode.valueOf(404));

    }


    @DeleteMapping("/trades/{tradeId}")
    public ResponseEntity<Optional<Trade>> deleteByTradeId(@PathVariable int tradeId){
        return new ResponseEntity<>(HttpStatusCode.valueOf(405));

    }

    @PutMapping("/trades/{tradeId}")
    public ResponseEntity<Optional<Trade>> putBytradesTradeId(@PathVariable int tradeId){
        return new ResponseEntity<>(HttpStatusCode.valueOf(405));

    }

    @PatchMapping("/trades/{tradeId}")
    public ResponseEntity<Optional<Trade>> patchByTradeId(@PathVariable int tradeId){
        return new ResponseEntity<>(HttpStatusCode.valueOf(405));

    }
}
