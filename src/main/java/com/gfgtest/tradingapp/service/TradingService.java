package com.gfgtest.tradingapp.service;

import com.gfgtest.tradingapp.model.Trade;


import java.util.List;
import java.util.Optional;

// interface to give overview of functions that needs to be implemented
public interface TradingService {
    Trade createTrade(Trade trade); //return a Trade object
    List<Trade>getAllTrades(String type, Long userID);  //returns list of Trade objects
    Optional<Trade>getTradeById(Long id);   //returns Trade object if found else NULL
}

// Implementation for this interface will be in TradingServiceImpl