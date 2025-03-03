package com.gfgtest.tradingapp.service;

import com.gfgtest.tradingapp.model.Trade;
import com.gfgtest.tradingapp.repository.TradeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Slf4j
@Service
public class TradingServiceImpl implements TradingService{
    
    //dependency injection of repository to perform CRUD operations provided by repository
    private final TradeRepository tradeRepository;
    @Autowired
    public TradingServiceImpl(TradeRepository tradeRepository){
        this.tradeRepository = tradeRepository;
    }


    @Override
    public Trade createTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public List<Trade> getAllTrades(String type, Long userID) {
        List<Trade> tradesArray = tradeRepository.findAll();
        return tradesArray.stream()
                .filter(trade -> (type == null || trade.getType().equalsIgnoreCase(type)))
                .filter((trade -> (userID == null || trade.getUserId().equals(userID))))
                .sorted((t1,t2)-> Long.compare(t2.getId(),t1.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Trade> getTradeById(Long id) {

        return tradeRepository.findById(id);
    }
}
