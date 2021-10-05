package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    public void save(Trade trade) {
        tradeRepository.save(trade);
    }

    public Trade updateById(Integer id) {
        return this.findById(id);
    }

    public void updateByTrade(Trade trade, Integer id) {
        trade.setId(id);
        tradeRepository.save(trade);
    }

    public void delete(Integer id) {
        tradeRepository.delete(this.findById(id));
    }

    private Trade findById(Integer id) {
        return tradeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Trade Id:" + id));
    }

}
