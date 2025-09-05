package com.learning.hotel.HotelService.services;

import com.learning.hotel.HotelService.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(String id);
}
