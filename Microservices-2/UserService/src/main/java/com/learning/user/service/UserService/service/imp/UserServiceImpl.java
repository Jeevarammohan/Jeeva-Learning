package com.learning.user.service.UserService.service.imp;

import com.learning.user.service.UserService.exception.ResourceNotFoundException;
import com.learning.user.service.UserService.external.HotelService;
import com.learning.user.service.UserService.model.Hotel;
import com.learning.user.service.UserService.model.Rating;
import com.learning.user.service.UserService.model.User;
import com.learning.user.service.UserService.repo.UserRepository;
import com.learning.user.service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;


    private Logger logger =  Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public User save(User user) {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found for the given user id"));
        Rating[] ratings= restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId, Rating[].class);
        List<Rating> ratingList= Arrays.stream(ratings).toList();
        List<Rating> ratingsNew = ratingList.stream().map(rating ->
        {
            logger.info("hotel id "+rating.getHotelId());
            Hotel hotel = hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
            logger.info(" "+hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingsNew);
        logger.info(ratingList+" ");
        return user;
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
