package com.abhi.hotel.hotelService.impl;

import com.abhi.hotel.hotelService.exceptions.ResourceNotFoundException;
import com.abhi.hotel.hotelService.entities.Hotel;
import com.abhi.hotel.hotelService.repositories.HotelRepository;
import com.abhi.hotel.hotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepo;

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel getHotelbyId(int id) {
        return hotelRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("user not found with given id"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }
}
