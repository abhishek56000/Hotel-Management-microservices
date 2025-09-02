package com.abhi.hotel.hotelService.services;

import com.abhi.hotel.hotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel save(Hotel hotel);

    public Hotel getHotelbyId(int id);

    public List<Hotel> getAllHotels();

}
