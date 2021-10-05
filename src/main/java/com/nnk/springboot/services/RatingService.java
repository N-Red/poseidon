package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public void save(Rating rating) {
        ratingRepository.save(rating);
    }

    public Rating updateById(Integer id) {
        return this.findById(id);
    }

    public void updateByRating(Rating rating, Integer id) {
        rating.setId(id);
        ratingRepository.save(rating);
    }

    private Rating findById(Integer id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Rating Id:" + id));
    }

    public void delete(Integer id) {
        Rating rating = this.findById(id);
        ratingRepository.delete(rating);
    }
}
