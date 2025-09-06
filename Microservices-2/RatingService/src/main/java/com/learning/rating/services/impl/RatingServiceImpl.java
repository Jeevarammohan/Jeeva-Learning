package com.learning.rating.services.impl;

import com.learning.rating.model.Rating;
import com.learning.rating.repo.RatingRepository;
import com.learning.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> findRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> findRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
