package com.gfgtest.tradingapp.repository;

import com.gfgtest.tradingapp.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

}
