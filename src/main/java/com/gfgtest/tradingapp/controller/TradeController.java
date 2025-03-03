package com.gfgtest.tradingapp.controller;

import com.gfgtest.tradingapp.model.Trade;
import com.gfgtest.tradingapp.service.TradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/trades")
@RestController
public class TradeController {

    private final TradingService tradingService;

    @Autowired
    public TradeController(TradingService tradingService) {
        this.tradingService = tradingService;
    }

    //Post request to create a new trade
    @PostMapping
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade){
        Trade createdTrade = tradingService.createTrade(trade);
        return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
    }

    //get request to return all trades in db
    @GetMapping
    public ResponseEntity<List<Trade>> getAllTrades(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Long userID){
        List<Trade> trades = tradingService.getAllTrades(type, userID);
        return new ResponseEntity<>(trades, HttpStatus.OK);
    }

    //get request to return trade for given id
    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable Long id){
        Trade trade = tradingService.getTradeById(id).orElse(null);
        return new ResponseEntity<>(trade, HttpStatus.OK);
    }

    //Delete, put, patch methods not allowed (405 status code)
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.PUT})
    public  ResponseEntity<Void>handleInvalidRequestMethod(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }





}
