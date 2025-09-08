package com.learning.hotel.HotelService.controller;

import com.learning.hotel.HotelService.model.Hotel;
import com.learning.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return new  ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
        return new ResponseEntity<>(hotelService.getHotelById(id), HttpStatus.OK);
    }

}
