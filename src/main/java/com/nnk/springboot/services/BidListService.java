package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidListService {
    @Autowired
    private BidListRepository bidListRepository;

    public Object findAll() {
        return bidListRepository.findAll();
    }

    public BidList findById(Integer id) {
        return bidListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid BidList Id:" + id));
    }

    public void save(BidList bid) {
        bidListRepository.save(bid);
    }

    public BidList updateById(Integer id) {
        BidList bid = this.findById(id);
        return bid;
    }

    public void updateByBid(BidList bid, Integer id) {
        bid.setId(id);
        bidListRepository.save(bid);
    }

    public void delete(Integer id) {
        BidList bidList = this.findById(id);
        bidListRepository.delete(bidList);
    }
}
