package com.learning.rating.services;

import com.learning.rating.model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    Rating createRating(Rating rating);
    List<Rating> findRatingsByUserId(String userId);

    List<Rating> findRatingsByHotelId(String hotelId);

    List<Rating> getAllRatings();


}
